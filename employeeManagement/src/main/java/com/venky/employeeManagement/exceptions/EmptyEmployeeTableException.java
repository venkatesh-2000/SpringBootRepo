package com.venky.employeeManagement.exceptions;

public class EmptyEmployeeTableException extends RuntimeException{
    public EmptyEmployeeTableException(String message) {
        super(message);
    }
}
