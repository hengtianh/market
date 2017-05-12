package com.hengtian.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CateItem implements Serializable {
	private Integer id;
	private String itemName;
	private String category;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
