package com.hpk.api.component.entities;

import lombok.Data;

@Data
public class Teacher {
	private int id;
	private int departmentId;
	private String surname;
	private String name;
	private String middleName;
	private String description;
}
