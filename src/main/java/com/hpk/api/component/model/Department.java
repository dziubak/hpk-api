package com.hpk.api.component.model;

import io.swagger.annotations.ApiModelProperty;

public class Department {
    @ApiModelProperty(notes = "The database generated department ID")
    private int id;
    @ApiModelProperty(notes = "The department name (full name)")
    private String name;
    @ApiModelProperty(notes = "The department abbreviation")
    private String abbreviation;
    @ApiModelProperty(notes = "The department description (additional info)")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
