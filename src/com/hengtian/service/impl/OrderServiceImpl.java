package com.hengtian.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import com.hengtian.mapper.OrderMapper;
import com.hengtian.po.Cart;
import com.hengtian.po.CartItem;
import com.hengtian.po.Order;
import com.hengtian.po.OrderDetail;
import com.hengtian.po.OrderItemVO;
import com.hengtian.po.User;
import com.hengtian.service.OrderService;
import com.hengtian.utils.IDGenerater;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public String insertOrder(Cart c, User u) throws Exception {
		//根据购物车创建订单
		String orderid = IDGenerater.generatProId();
		Date date = new Date();
		Order o = new Order(orderid,c.getPrice(),u.getRealName(),u.getAddress(),u.getPhone(),date,0);
		orderMapper.insertOrder(o);
		
		//根据购物项创建订单明细
		Set<CartItem> cis = c.getCartItems();
		OrderDetail od = null;
		for(CartItem ci : cis){
			od = new OrderDetail(orderid, ci.getInfo(), ci.getId(), ci.getPrice(), ci.getNum());
			insertOrderDetail(od);
		}
		return orderid;
	}
	@Override
	public void insertOrderDetail(OrderDetail od) throws Exception {
		orderMapper.insertOrderDetail(od);
	}
	@Override
	public List<OrderDetail> findMyOrderDetail(String customName) throws Exception {
		return orderMapper.findMyOrderDetail(customName);
	}
	/**
	 * 待发货订单项
	 */
	@Override
	public List<OrderDetail> findOrderDetailSell(int userid) throws Exception {
		return orderMapper.findOrderDetailSell(userid);
	}
	@Override
	public Order findOrder(String oid) throws Exception {
		return orderMapper.findOrder(oid);
	}
	@Override
	public OrderItemVO findAllOrderItems(String oid) throws Exception {
		return orderMapper.findAllOrderItems(oid);
	}
	@Override
	public void updateOrder(int id, int num, String pid) throws Exception {
		// 商家发货后更新订单项状态
		orderMapper.updateOrder(id);
		OrderDetail od = new OrderDetail(null, null, pid, 0, num);
		orderMapper.updateProNum(od);
	}
	/**
	 * 已完成的订单列表
	 */
	@Override
	public List<OrderDetail> successOrderList(int userid) throws Exception {
		return orderMapper.successOrderList(userid);
	}
	@Override
	public void updateOrderStatus(String oid) throws Exception {
		int i = orderMapper.checkStatus(oid);
		if (i == 0) {
			orderMapper.updateOrderStatus(oid);
		}
	}
	@Override
	public void endOrderDetail(int id, String oid) throws Exception {
		orderMapper.endOrderDetail(id);
		updateOrderStatus(oid);
	}
	@Override
	public void afterPay(String oid) throws Exception {
		orderMapper.afterPay(oid);
	}
	
	
}
