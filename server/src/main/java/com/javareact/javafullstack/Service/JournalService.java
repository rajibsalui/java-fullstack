package com.javareact.javafullstack.Service;

import com.javareact.javafullstack.Entity.EmployeeEntity;
import com.javareact.javafullstack.Entity.JournalEntity;
import com.javareact.javafullstack.Repository.JournalRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private EmployeeService employeeService;

    public Iterable<JournalEntity> getAllEntries() {
        try {
            return journalRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error fetching journal entries: " + e.getMessage());
            return null;
        }
    }

    public List<JournalEntity> getEntriesByEmployeeId(Long employeeId) {
        try {
            EmployeeEntity employee = employeeService.getEmployeeById(employeeId);
            if(employee == null){
                return null;
            }
            List<JournalEntity> entries = journalRepository.findByEmployeeId(employeeId);
            return entries;
        } catch (Exception e) {
            System.out.println("Error fetching journal entries for employee: " + e.getMessage());
            return null;
        }
    }

    public String createEntry(JournalEntity journal) {
        try {
            // Verify that the employee exists
            EmployeeEntity employee = employeeService.getEmployeeById(journal.getEmployeeId());
            if(employee == null){
                return "Employee with id " + journal.getEmployeeId() + " does not exist";
            }
            
            // Set the creation date if not already set
            if(journal.getDate() == null) {
                journal.setDate(LocalDateTime.now());
            }
            
            // Save the journal entry
            JournalEntity savedJournal = journalRepository.save(journal);
            return "Journal entry created successfully with id: " + savedJournal.getId();
        } catch (Exception e) {
            System.out.println("Error creating journal entry: " + e.getMessage());
            return "Failed to create journal entry: " + e.getMessage();
        }
    }
    
    public String deleteEntry(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            if(!journalRepository.existsById(objectId)) {
                return "Journal entry with id " + id + " does not exist";
            }
            journalRepository.deleteById(objectId);
            return "Journal entry with id " + id + " deleted successfully";
        } catch (Exception e) {
            System.out.println("Error deleting journal entry: " + e.getMessage());
            return "Failed to delete journal entry: " + e.getMessage();
        }
    }

    public String updateEntry(String id, JournalEntity newEntry) {
        try {
            ObjectId objectId = new ObjectId(id);
            JournalEntity old = journalRepository.findById(objectId).orElse(null);
            if(old != null){
                old.setTitle(newEntry.getTitle() != null ? newEntry.getTitle() : old.getTitle());
                old.setContent(newEntry.getContent() != null ? newEntry.getContent() : old.getContent());
                // Update the date to current time on update
                old.setDate(LocalDateTime.now());
                journalRepository.save(old);
                return "Journal entry with id " + id + " updated successfully";
            } else {
                return "Journal entry with id " + id + " does not exist";
            }
        } catch (Exception e) {
            System.out.println("Error updating journal entry: " + e.getMessage());
            return "Failed to update journal entry: " + e.getMessage();
        }
    }
}
