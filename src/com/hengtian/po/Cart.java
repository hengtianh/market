package com.hengtian.po;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Cart {
	private Set<CartItem> cartItems = new HashSet<CartItem>(0);
	private double price;
	public Set<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<CartItem> cartItems) {
		cartItems = cartItems;
	}
	public double getPrice() {
		//�����ܽ��,ÿ�λ��ʱ���Ƚ��ܽ������
		price = 0;
		Iterator<CartItem> it = cartItems.iterator();
		CartItem i = null;
		while(it.hasNext()){
			i = it.next();
			price += i.getPrice() * i.getNum();
		}
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
