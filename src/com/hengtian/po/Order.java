package com.hengtian.po;

import java.util.Date;

public class Order {
	private Integer id;//���
	private String orderid;//�������
	private double price;//�����ܼ�
	private String customName;//�ͻ�����
	private String address;//��ַ
	private String phone;//�绰
	private Date cuDate;//��������
	private int success;//�Ƿ���� 0δ��ɣ�1���
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
