package com.javareact.javafullstack.Service;

import com.javareact.javafullstack.Entity.EmployeeEntity;
import com.javareact.javafullstack.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;
import java.time.LocalDateTime;

@Service // it is used to mark the class as a service provider, which holds the business logic
public class EmployeeService {
    @Autowired // it is used to wire the EmployeeRepository bean into the EmployeeService, allowing us to use its methods to perform database operations related to employees.
    private EmployeeRepository employeeRepository;

    public Iterable<EmployeeEntity> allEmployeesList() {
        try {
         return employeeRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error fetching employee list: " + e.getMessage());
            return null;
        }
    }

    public EmployeeEntity getEmployeeById(Long id) {
        try {
            return employeeRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error fetching employee by id: " + e.getMessage());
            return null;
        }
    }

    public String createEmployee(EmployeeEntity employee) {
        try {
            if (employeeRepository.existsById(employee.getId())) {
                return "Employee with id " + employee.getId() + " already exists";
            }
            employee.setCreatedAt(LocalDateTime.now());
            employeeRepository.save(employee).getId();
            return "Employee with id " + employee.getId() + " created successfully";
        } catch (Exception e) {
            System.out.println("Error creating employee: " + e.getMessage());
            return "Failed to create employee";
        }
    }

    public String deleteEmployee(Long id) {
        try {
            if(employeeRepository.findById(id).isEmpty()){
                return "Employee with id " + id + " does not exist";
            }
            employeeRepository.deleteById(id);
            return "Employee with id " + id + " deleted successfully";
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            return "Failed to delete employee";
        }
    }

    public String updateEmployee(Long id, EmployeeEntity newEntry) {
        try {
            EmployeeEntity old = employeeRepository.findById(id).orElse(null);
            if(old!=null){
                old.setEmail(newEntry.getEmail()!=null && !newEntry.getEmail().isEmpty() ? newEntry.getEmail() : old.getEmail());
                old.setPhone(newEntry.getPhone()!=null && !newEntry.getPhone().isEmpty() ? newEntry.getPhone() : old.getPhone());
                old.setUpdatedAt(LocalDateTime.now());
            } else {
                return "Employee with id " + id + " does not exist";
            }
            employeeRepository.save(old);
            return "Employee with id " + id + " updated successfully";
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
            return "Failed to update employee";
        }
    }
}


//controller -> service -> repository -> database