package com.javareact.javafullstack.Service;

import com.javareact.javafullstack.Entity.EmployeeEntity;
import com.javareact.javafullstack.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;
import java.time.LocalDateTime;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<EmployeeEntity> allEmployeesList() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public String createEmployee(EmployeeEntity employee) {
        //set time
        employee.setCreatedAt(LocalDateTime.now());
        employeeRepository.save(employee).getId();
        return "Employee with id " + employee.getId() + " created successfully";
    }

    public String deleteEmployee(Long id) {
        var f = employeeRepository.findById(id);

        if (f.isEmpty()) {
            // employee does not exist
            return "Employee with id " + id + " does not exist";

        } else {
            // employee is present
            employeeRepository.delete(f.get());
            return "Employee with id " + id + " deleted successfully";
        }
    }

    public String updateEmployee(Long id, EmployeeEntity newEntry) {
        EmployeeEntity old = employeeRepository.findById(id).orElse(null);
        if(old!=null){
            old.setEmail(newEntry.getEmail()!=null && !newEntry.getEmail().isEmpty() ? newEntry.getEmail() : old.getEmail());
            old.setPhone(newEntry.getPhone()!=null && !newEntry.getPhone().isEmpty() ? newEntry.getPhone() : old.getPhone());
            old.setUpdatedAt(LocalDateTime.now());
        }
        employeeRepository.save(old);
        return "Employee with id " + id + " updated successfully";
    }
}


//controller -> service -> repository -> database