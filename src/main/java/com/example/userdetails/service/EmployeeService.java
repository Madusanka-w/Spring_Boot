package com.example.userdetails.service;

import com.example.userdetails.dto.EmployeeVehicleDTO;
import com.example.userdetails.model.Employee;

import java.util.List;

public interface EmployeeService {

    //Save employee details
    Employee saveEmployee(Employee employee);

    //get all employee details
    List<Employee> getAllEmployee();

    //get employee by id
    Employee getEmployeeById(int id);

    //delete employee
    void deleteEmployee(Integer id);

    //update employee details
    Employee updateEmployee(Employee employee, Integer id);

    List<EmployeeVehicleDTO> getAllEmployeesVehicle();


}
