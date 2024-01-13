package org.example.skelton.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "patient_address")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PatientAddress {

    @Id
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "detailed_address")
    private String detailedAddress;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

}
