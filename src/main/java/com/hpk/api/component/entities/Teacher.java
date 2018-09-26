package com.hpk.api.component.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher {
	private int id;
	private int departmentId;
	private String surname;
	private String name;
	private String middleName;
	private String description;
	private boolean status;
}
