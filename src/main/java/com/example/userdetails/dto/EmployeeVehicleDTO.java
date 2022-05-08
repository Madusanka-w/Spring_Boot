package com.example.userdetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVehicleDTO {

//    private Employee employee;

    private int id;
    private String firstName;
    private String lastName;
    private String vehicleType;
    private String vehicleNumber;

}
