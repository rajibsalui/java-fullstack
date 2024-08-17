package com.javareact.javafullstack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//import java.util.ArrayList;


@RestController
public class EmpController {

   // List<Employee> employees = new ArrayList<>();
    //@Autowired
    EmployeeService employeeService= new EmployeeServiceImpl();

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        
        
        return employeeService.readEmployees();
    }
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
        //employees.add(employee);
        
    }
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id) ? "Deleted Successfully" : "Employee not found";
        //employees.remove(id);
    }
}
