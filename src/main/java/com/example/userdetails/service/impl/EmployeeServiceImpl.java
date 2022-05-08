package com.example.userdetails.service.impl;

import com.example.userdetails.dto.EmployeeVehicleDTO;
import com.example.userdetails.exception.ResourceNotFoundException;
import com.example.userdetails.model.Employee;
import com.example.userdetails.repository.EmployeeRepository;
import com.example.userdetails.repository.VehicleRepository;
import com.example.userdetails.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private VehicleRepository vehicleRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("not found"));
    }

    @Override
    public void deleteEmployee(Integer id) {
        //check employee is existing in DB
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("not found"));

        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {

        //check employee is already existing in DB
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("not found"));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setUserRole(employee.getUserRole());
        existingEmployee.setUserLocation(employee.getUserLocation());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public List<EmployeeVehicleDTO> getAllEmployeesVehicle() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private EmployeeVehicleDTO convertEntityToDTO(Employee employee){
        EmployeeVehicleDTO employeeVehicleDTO = new EmployeeVehicleDTO();
        employeeVehicleDTO.setId(employee.getId());
        employeeVehicleDTO.setFirstName(employee.getFirstName());
        employeeVehicleDTO.setVehicleType(employee.getVehicle().getVehicleType());
        employeeVehicleDTO.setVehicleNumber(employee.getVehicle().getVehicleNumber());
        return employeeVehicleDTO;
    }

}
