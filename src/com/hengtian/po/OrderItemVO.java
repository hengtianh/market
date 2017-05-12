package com.hengtian.po;

import java.util.List;

public class OrderItemVO {
	private String oid;
	private List<OrderDetail> od;
	private double total;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<OrderDetail> getOd() {
		return od;
	}
	public void setOd(List<OrderDetail> od) {
		this.od = od;
	}
}
