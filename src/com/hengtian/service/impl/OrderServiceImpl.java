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
import com.hengtian.po.User;
import com.hengtian.service.OrderService;
import com.hengtian.utils.IDGenerater;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public void insertOrder(Cart c, User u) throws Exception {
		//���ݹ��ﳵ��������
		String orderid = IDGenerater.generatProId();
		Date date = new Date();
		Order o = new Order(orderid,c.getPrice(),u.getRealName(),u.getAddress(),u.getPhone(),date,0);
		orderMapper.insertOrder(o);
		
		//���ݹ������������ϸ
		Set<CartItem> cis = c.getCartItems();
		OrderDetail od = null;
		for(CartItem ci : cis){
			od = new OrderDetail(orderid, ci.getInfo(), ci.getId(), ci.getPrice(), ci.getNum());
			insertOrderDetail(od);
		}
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
	 * ������������
	 */
	@Override
	public List<OrderDetail> findOrderDetailSell(int userid) throws Exception {
		return orderMapper.findOrderDetailSell(userid);
	}

	@Override
	public Order findOrder(String oid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> findAllOrderItems(String oid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(int id) throws Exception {
		// �̼ҷ�������¶�����״̬
		orderMapper.updateOrder(id);
	}

	/**
	 * ����ɵĶ����б�
	 */
	@Override
	public List<OrderDetail> successOrderList(int userid) throws Exception {
		return orderMapper.successOrderList(userid);
	}

	@Override
	public void updateOrderStatus(int oid) throws Exception {
		orderMapper.updateOrderStatus(oid);
	}

	@Override
	public void endOrderDetail(int id) throws Exception {
		orderMapper.endOrderDetail(id);
	}



}
