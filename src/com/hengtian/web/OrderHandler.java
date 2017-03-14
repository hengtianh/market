package com.hengtian.web;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengtian.po.Cart;
import com.hengtian.po.CartItem;
import com.hengtian.po.OrderDetail;
import com.hengtian.po.User;
import com.hengtian.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderHandler {
	
	@Autowired
	private OrderService oService;
	/**
	 * 添加购物车
	 * @param id 商品id
	 * @param info 商品名称
	 * @param price 商品价格
	 * @throws Exception
	 */
	@RequestMapping("/addCart")
	public String addCart(HttpSession session, String id, String info, double price) throws Exception {
		//判断session是否有购物车
		Cart cart = (Cart) session.getAttribute("cart");
		//创建购物项
		CartItem item = new CartItem(id, info, price);
		if(cart==null) {
			//没有购物车，先创建
			cart = new Cart();
			//将购物项加入到购物车
			cart.getCartItems().add(item);
			item.getNum();
		}else {
			//购物车存在，判断是否重复添加
			if(cart.getCartItems().contains(item)) {
				Iterator<CartItem> it = cart.getCartItems().iterator();
				CartItem i = null;
				while(it.hasNext()){
					i = it.next();
					if(i.equals(item))
						break;
				}
				item.setNum(i.getNum()+1);
				//重复添加,增加购物项的数量，再添加到购物车
				cart.getCartItems().remove(item);
				cart.getCartItems().add(item);
			}else {
				cart.getCartItems().add(item);
			}
		}
		//将购物车加入到session
		session.setAttribute("cart", cart);
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * 移除购物项
	 * @param session
	 * @param item 要移除的购物项
	 * @throws Exception
	 */
	@RequestMapping("/removeItem")
	public String removeItem(HttpSession session, CartItem item) throws Exception {
		//获得购物车
		Cart cart = (Cart) session.getAttribute("cart");
		cart.getCartItems().remove(item);
		session.setAttribute("cart", cart);			
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * 清空购物车
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/removeCart")
	public String removeCart(HttpSession session) throws Exception {
		Cart cart = (Cart) session.getAttribute("cart");		
		cart.getCartItems().clear();
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * 结算，生成订单
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createOrder")
	public String createOrder(HttpSession session) throws Exception {
		//获得session中的购物车，迭代购物项，生成表记录
		Cart cart = (Cart) session.getAttribute("cart");
		User u = (User) session.getAttribute("user");
		if (cart.getCartItems().size()>0){
			oService.insertOrder(cart,u);
		}
		//要修改为转向支付页面
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * @author tianheng
	 * @description 查询要发货的订单
	 * @version 1.0
	 * @time 2017年3月12日 下午12:01:19
	 * @return TODO
	 */
	@RequestMapping("/findOrderDetailSell")
	public String findOrderDetailSell(HttpSession session, Model model) throws Exception {
		User u = (User) session.getAttribute("user");
		int uid = u.getId();
		List<OrderDetail> ods = oService.findOrderDetailSell(uid);
		model.addAttribute("ods", ods);
		return "jsp/sel/unfinishOrder";
	}
	
	@RequestMapping("/finishOrderDetail")
	public String finishOrderDetail(int id) throws Exception {
		//修改订单状态为已发货
		oService.updateOrder(id);
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * @author tianheng
	 * @description 我的宝贝列表
	 * @version 1.0
	 * @time 2017年3月12日 下午12:44:14
	 * @return TODO
	 */
	@RequestMapping("/findMyOrderDetail")
	public String findMyOrderDetail(HttpSession session, Model model) throws Exception {
		User u = (User) session.getAttribute("user");
		String uname = u.getRealName();
		List<OrderDetail> ods = oService.findMyOrderDetail(uname);
		model.addAttribute("mods", ods);
		return "jsp/sel/mythings";
	}
	
	/**
	 * @author tianheng
	 * @description 修改订单状态为已完成
	 * @version 1.0
	 * @time 2017年3月12日 下午8:35:34
	 * @return TODO
	 */
	@RequestMapping("/successOrder")
	public String successOrder(int oid) throws Exception {
		oService.updateOrderStatus(oid);
		return "redirect:/category/toIndex.action";
	}
	/**
	 * @author tianheng
	 * @description 查询历史已发货订单
	 * @version 1.0
	 * @time 2017年3月12日 下午8:16:14
	 * @return TODO
	 */
	@RequestMapping("/successOrderList")
	public String successOrderList(HttpSession session, Model model) throws Exception {
		User u = (User) session.getAttribute("user");
		int uid = u.getId();
		List<OrderDetail> ods = oService.successOrderList(uid);
		model.addAttribute("sodl", ods);
		return "jsp/sel/successOrderList";
	}
	
	/**
	 * @author tianheng
	 * @description 修改状态为已收货
	 * @version 1.0
	 * @time 2017年3月12日 下午8:33:20
	 * @return TODO
	 */
	@RequestMapping("/endOrderDetail")
	public String endOrderDetail(int id) throws Exception {
		oService.endOrderDetail(id);
		return "redirect:/category/toIndex.action";
	}
	
	
}
