package com.example.userdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleId", nullable = false)
    private int id;

    @Column(name = "vehicleNumber")
    private String vehicleNumber;

    @Column(name = "vehicleType")
    private String vehicleType;
}
