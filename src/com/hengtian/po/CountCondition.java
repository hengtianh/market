package com.hengtian.po;

import java.io.Serializable;

public class CountCondition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private Integer type;
	
	public CountCondition(String label, Integer type) {
		super();
		this.label = label;
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
