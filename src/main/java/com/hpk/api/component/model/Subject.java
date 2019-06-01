package com.hpk.api.component.model;

import lombok.Data;

@Data
public class Subject {
	private int id;
	private int teacherId;
	private String name;
	private String abbreviation;
	private String description;
}
