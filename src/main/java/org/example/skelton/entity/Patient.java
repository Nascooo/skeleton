package org.example.skelton.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "patient")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient {


    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "mobile_number")
    private String phone;
    @OneToMany
    @JoinColumn(name = "address_id")
    private Set<PatientAddress> address;
}
