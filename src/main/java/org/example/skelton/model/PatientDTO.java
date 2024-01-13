package org.example.skelton.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PatientDTO {

    private Integer id;
    private String name;
    private String phone;
    private Set<PatientAddressDTO> address;
}
