package com.example.restservice.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Party {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String legalName;


}
