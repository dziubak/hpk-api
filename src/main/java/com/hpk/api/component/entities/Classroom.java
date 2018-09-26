package com.hpk.api.component.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Classroom {
	private int id;
	private String number;
	private String description;
	private boolean status;
}
