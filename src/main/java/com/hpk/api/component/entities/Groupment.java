package com.hpk.api.component.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Groupment {
	private int id;
	private int departmentId;
	private int teacherId;
	private String name;
	private int course;
	private String description;
	private boolean status;
}
