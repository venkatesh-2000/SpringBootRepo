package com.venky.employeeManagement.service;

import com.venky.employeeManagement.exceptions.EmployeeNotFoundException;
import com.venky.employeeManagement.exceptions.EmptyEmployeeTableException;
import com.venky.employeeManagement.model.Employee;
import com.venky.employeeManagement.repository.EmployeeRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository  employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees(){
        if(employeeRepository.findAll().isEmpty())
            throw new EmptyEmployeeTableException("Employee table is empty.. Please register an Employee");
        else
            return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int empId) {

        return employeeRepository.findById(empId).orElseThrow(()-> new EmployeeNotFoundException("Employee Not Found with id: "+ empId));

    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Employee emp = getEmployeeById(employee.getEmpId());

        emp.setName(employee.getName());
        emp.setRole(employee.getRole());
        emp.setSalary(employee.getSalary());

        return employeeRepository.save(emp);
    }

    @Override
    public Employee deleteEmployee(int empId) {
        Employee emp = getEmployeeById(empId);

        try {
            employeeRepository.deleteById(empId);
        } catch (Exception e) {
            throw new EmployeeNotFoundException("Employee Not Found with Id: "+empId);
        }
        return emp;
    }


}
