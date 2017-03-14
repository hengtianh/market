package com.hengtian.service;

import java.util.List;

import com.hengtian.po.Cart;
import com.hengtian.po.Order;
import com.hengtian.po.OrderDetail;
import com.hengtian.po.User;

public interface OrderService {
	void insertOrder(Cart c, User u) throws Exception;
	
	void insertOrderDetail(OrderDetail od) throws Exception;
	
	Order findOrder(String oid) throws Exception;
	
	List<OrderDetail> findAllOrderItems(String oid) throws Exception;
	
	List<OrderDetail> findMyOrderDetail(String customName) throws Exception;
	
	List<OrderDetail> findOrderDetailSell(int userid) throws Exception;
	
	void updateOrder(int id) throws Exception;
	
	void endOrderDetail(int id) throws Exception;
	
	List<OrderDetail> successOrderList(int userid) throws Exception;
	
	void updateOrderStatus(int oid) throws Exception;
	
	
}
