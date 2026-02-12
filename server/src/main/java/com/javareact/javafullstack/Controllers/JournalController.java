package com.javareact.javafullstack.Controllers;

import com.javareact.javafullstack.Entity.JournalEntity;
import com.javareact.javafullstack.Service.EmployeeService;
import com.javareact.javafullstack.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalService journalService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/entries")
    public Iterable<JournalEntity> getAllEntries() {
        return journalService.getAllEntries();
    }
    
    // Create a journal entry for a specific employee
    @PostMapping("/create/{employeeId}")
    public String createEntry(@PathVariable Long employeeId, @RequestBody JournalEntity journal) {
        journal.setEmployeeId(employeeId);
        return journalService.createEntry(journal);
    }
    
    // Get all journal entries for a specific employee
    @GetMapping("/entries/{employeeId}")
    public List<JournalEntity> getEntriesByEmployeeId(@PathVariable Long employeeId) {
        return journalService.getEntriesByEmployeeId(employeeId);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteEntry(@PathVariable String id) {
        return journalService.deleteEntry(id);
    }
    
    @PutMapping("/update/{id}")
    public String updateEntry(@PathVariable String id, @RequestBody JournalEntity journal) {
        return journalService.updateEntry(id, journal);
    }
}

// @PathVariable is used to bind the value of a URI template variable to a method parameter in Spring MVC.