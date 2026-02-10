package com.javareact.javafullstack.Controllers;

import com.javareact.javafullstack.Entity.EmployeeEntity;
import com.javareact.javafullstack.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired // it is used to wire the EmployeeService bean into the EmployeeController, allowing us to use its methods to perform operations related to employees.
    private EmployeeService employeeService;


    // get all
    @GetMapping("/employeelist")
    // This method is used for fetching all the employees from the SQL database
    public Iterable<EmployeeEntity> allEmployeesList() {

        return employeeService.allEmployeesList();
    }
    //get by id
    @GetMapping("/employeelist/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // create
    @PostMapping("/create")
    public String createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.createEmployee(employee);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    // update
    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employee) {
        return employeeService.updateEmployee(id, employee);
    }
}
