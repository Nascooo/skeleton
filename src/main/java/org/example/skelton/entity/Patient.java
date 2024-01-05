package org.example.skelton.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "patient")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient {


    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
}
