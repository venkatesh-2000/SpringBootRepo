package com.venky.employeeManagement.controller;

import com.venky.employeeManagement.model.Employee;
import com.venky.employeeManagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl{

    private final EmployeeService employeeService;
    public EmployeeControllerImpl(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    private Employee createEmployee(@RequestBody Employee employee){

        return employeeService.createEmployee(employee);
    }

    @GetMapping
    private List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    private Employee getEmployeeById( Employee employee, @PathVariable("id") int empId){

        return employeeService.getEmployeeById(empId);
    }

    @PutMapping
    private Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    private Employee deleteEmployee(@PathVariable("id") int empId){
        return employeeService.deleteEmployee(empId);
    }

}
