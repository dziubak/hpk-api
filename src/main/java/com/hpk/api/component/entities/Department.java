package com.hpk.api.component.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department {
    private int id;
    private String name;
    private String abbreviation;
    private String description;
    private boolean status;
}
