package com.hengtian.mapper;

import java.util.List;

import com.hengtian.po.Order;
import com.hengtian.po.OrderDetail;
import com.hengtian.po.OrderItemVO;

public interface OrderMapper {
	public void insertOrderDetail(OrderDetail od) throws Exception;
	
	public void insertOrder(Order order) throws Exception;
	
	public Order findOrder(String orderid) throws Exception;

	public OrderItemVO findAllOrderItems(String oid) throws Exception;
	
	public List<OrderDetail> findMyOrderDetail(String customName) throws Exception;
	
	public List<OrderDetail> findOrderDetailSell(int userid) throws Exception;
	
	public void endOrderDetail(int id) throws Exception;
	
	public void updateOrder(int id) throws Exception;
	
	public List<OrderDetail> successOrderList(int userid) throws Exception;

	public boolean updateOrderStatus(String oid);	
}
