package com.example.userdetails.controller;

import com.example.userdetails.model.Employee;
import com.example.userdetails.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeVehicleController {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private VehicleRepository vehicleRepository;

//    @PostMapping("/employeeVehicle")
//    public Employee getEmployeeVehicles(@PathVariable("id") Integer id){
//
//        return employeeRepository.save(request.getEmployee());
//    }



    @GetMapping("/getAllVehicle")
    public List<Employee> findAllVehicle(){
        return employeeRepository.findAll();
    }
}
