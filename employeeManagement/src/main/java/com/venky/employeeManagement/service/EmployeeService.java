package com.venky.employeeManagement.service;

import com.venky.employeeManagement.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int empId);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(int empId);
}
