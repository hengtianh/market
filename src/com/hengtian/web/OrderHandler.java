package com.hengtian.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengtian.po.Cart;
import com.hengtian.po.CartItem;
import com.hengtian.po.Order;
import com.hengtian.po.OrderDetail;
import com.hengtian.po.OrderItemVO;
import com.hengtian.po.PayVO;
import com.hengtian.po.User;
import com.hengtian.service.OrderService;
import com.hengtian.utils.PaymentUtil;

@Controller
@RequestMapping("/order")
public class OrderHandler {
	private static String p1_MerId;
	private static String keyValue;
	private static String responseURL;
	static {
		Properties prop = new Properties();
		try {
			InputStream in = OrderHandler.class.getClassLoader().getResourceAsStream("merchantInfo.properties");
			prop.load(in);
			p1_MerId = prop.getProperty("p1_MerId");
			keyValue = prop.getProperty("keyValue");
			responseURL = prop.getProperty("responseURL");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
		String orderid = null;
		if (cart.getCartItems().size()>0){
			orderid = oService.insertOrder(cart,u);
		}
		//要修改为转向支付页面
		return "redirect:/order/toPay.action?orderid=" + orderid;
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
	public String successOrder(String oid) throws Exception {
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
	
	@RequestMapping("/toPay")
	public String toPay(String orderid, Model model) throws Exception{
		OrderItemVO list = oService.findAllOrderItems(orderid);
		model.addAttribute("ods", list);
		return "jsp/sel/toPay";
	}
	
	
	@RequestMapping("/pay")
	public String pay(HttpServletRequest request, String ordersnum, String price, String pd_FrpId) throws Exception{
		
		PayVO pay = new PayVO(ordersnum, price,p1_MerId,responseURL);
		String hmac = PaymentUtil.buildHmac(pay.getP0_Cmd(), 
				pay.getP1_MerId(), pay.getP2_Order(), pay.getP3_Amt(), pay.getP4_Cur(), pay.getP5_Pid(),
				pay.getP6_Pcat(), pay.getP7_Pdesc(), pay.getP8_Url(), pay.getP9_SAF(), pay.getPa_MP(), 
				pd_FrpId, pay.getPr_NeedResponse(), keyValue);
		
		pay.setHmac(hmac);
		fillData(request,pay,pd_FrpId);
		return "jsp/sel/sure";
	}
	
	public void fillData(HttpServletRequest request, PayVO pay, String pd_FrpId){
		request.setAttribute("p0_Cmd",pay.getP0_Cmd());
		request.setAttribute("p1_MerId",pay.getP1_MerId() );
		request.setAttribute("p2_Order",pay.getP2_Order());
		request.setAttribute("p3_Amt",pay.getP3_Amt());
		request.setAttribute("p4_Cur",pay.getP4_Cur());
		request.setAttribute("p5_Pid",pay.getP5_Pid());
		request.setAttribute("p6_Pcat",pay.getP6_Pcat());
		request.setAttribute("p7_Pdesc",pay.getP7_Pdesc());
		request.setAttribute("p8_Url",pay.getP8_Url());
		request.setAttribute("p9_SAF",pay.getP9_SAF());
		request.setAttribute("pa_MP",pay.getPa_MP());
		request.setAttribute("pr_NeedResponse",pay.getPr_NeedResponse());
		request.setAttribute("pd_FrpId",pd_FrpId);
		request.setAttribute("hmac",pay.getHmac());
	}
	
	@RequestMapping("/payResponse")
	public void payResponse(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String p1_MerId = request.getParameter("p1_MerId");
			String r0_Cmd= request.getParameter("r0_Cmd");
			String r1_Code= request.getParameter("r1_Code");//1代表成功
			String r2_TrxId= request.getParameter("r2_TrxId");
			String r3_Amt= request.getParameter("r3_Amt");
			String r4_Cur= request.getParameter("r4_Cur");
			String r5_Pid= request.getParameter("r5_Pid");
			String r6_Order= request.getParameter("r6_Order");//订单号
			String r7_Uid= request.getParameter("r7_Uid");
			String r8_MP= request.getParameter("r8_MP");
			String r9_BType= request.getParameter("r9_BType");//为“1”: 浏览器重定向;为“2”: 服务器点对点通讯.
			String hmac= request.getParameter("hmac");
			//验证信息的正确性
			boolean b = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");
			if(b){
				if("1".equals(r1_Code)){
					//支付成功
					if("2".equals(r9_BType)){
						response.getWriter().write("success");
					}
					//更改订单的状态
					Order o = oService.findOrder(r6_Order);
					if(o==null){
						response.getWriter().write("没有该订单");
						return;
					}
					oService.updateOrderStatus(r6_Order);
					response.getWriter().write("<script type='text/javascript'>alert('支付成功')</script>");
					response.setHeader("Refresh", "0;URL="+request.getContextPath());
				}else{
					response.getWriter().write("支付失败！请与网站联系");
				}
			}else{
				response.getWriter().write("返回的信息有误,请与网站联系");
			}
	}
	
}
