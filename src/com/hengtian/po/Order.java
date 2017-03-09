package com.hengtian.po;

import java.util.Date;

public class Order {
	private Integer id;//编号
	private String orderid;//订单编号
	private double price;//订单总价
	private String customName;//客户名称
	private String address;//地址
	private String phone;//电话
	private Date cuDate;//创建日期
	private int success;//是否完成 0未完成，1完成
	public Order() {
		super();
	}
	
	public Order(String orderid, double price, String customName, String address, String phone, Date cuDate,
			int success) {
		super();
		this.orderid = orderid;
		this.price = price;
		this.customName = customName;
		this.address = address;
		this.phone = phone;
		this.cuDate = cuDate;
		this.success = success;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCuDate() {
		return cuDate;
	}
	public void setCuDate(Date cuDate) {
		this.cuDate = cuDate;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
}
