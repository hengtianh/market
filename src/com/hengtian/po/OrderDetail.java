package com.hengtian.po;

public class OrderDetail {
	private Integer id;
	private String oid;
	private String pName;
	private String pId;
	private double price;
	private int num;
	private int success;
	
	public OrderDetail() {
		super();
	}
	public OrderDetail(String oid, String pName, String pId, double price, int num) {
		this.oid = oid;
		this.pName = pName;
		this.pId = pId;
		this.price = price;
		this.num = num;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
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
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
}
