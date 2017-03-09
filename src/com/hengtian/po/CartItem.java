package com.hengtian.po;

public class CartItem {
	private String id;
	private String info;
	private double price;
	private int num;
	
	public CartItem() {
		super();
	}
	public CartItem(String id, String info, double price) {
		this.id = id;
		this.info = info;
		this.price = price;
		this.num =1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void addNum(int num) {
		this.num = this.num + num;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof CartItem))
			return false;
		CartItem ci = (CartItem) obj;
		if(ci.id.equals(this.id) && ci.price==this.price)
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
