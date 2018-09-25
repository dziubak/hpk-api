package com.hpk.api.component.entities;

import lombok.Data;

@Data
public class Subject {
	private int id;
	private int teacherId;
	private String name;
	private String abbreviation;
	private String description;
}
