package com.clomagno.inmobiliarias.jasper.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestModel{
	private String field;

	@JsonCreator
	public TestModel(@JsonProperty("field") String field) {
		super();
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
