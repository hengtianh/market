package com.hengtian.service;

import java.util.List;
import com.hengtian.po.Cart;
import com.hengtian.po.Order;
import com.hengtian.po.OrderDetail;
import com.hengtian.po.OrderItemVO;
import com.hengtian.po.User;

public interface OrderService {
	String insertOrder(Cart c, User u) throws Exception;
	
	void insertOrderDetail(OrderDetail od) throws Exception;
	
	Order findOrder(String oid) throws Exception;
	
	OrderItemVO findAllOrderItems(String oid) throws Exception;
	
	List<OrderDetail> findMyOrderDetail(String customName) throws Exception;
	
	List<OrderDetail> findOrderDetailSell(int userid) throws Exception;
	
	void updateOrder(int id, int num, String pid) throws Exception;
	
	void endOrderDetail(int id, String oid) throws Exception;
	
	List<OrderDetail> successOrderList(int userid) throws Exception;
	
	void updateOrderStatus(String oid) throws Exception;

	void afterPay(String oid) throws Exception;
	
	
	
	
}
