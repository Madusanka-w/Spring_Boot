package com.example.userdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "userRole")
    private String userRole;

    @Column(name = "userLocation")
    private String userLocation;

    @OneToOne(targetEntity = Vehicle.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

}

