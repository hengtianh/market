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
	 * ��ӹ��ﳵ
	 * @param id ��Ʒid
	 * @param info ��Ʒ����
	 * @param price ��Ʒ�۸�
	 * @throws Exception
	 */
	@RequestMapping("/addCart")
	public String addCart(HttpSession session, String id, String info, double price) throws Exception {
		//�ж�session�Ƿ��й��ﳵ
		Cart cart = (Cart) session.getAttribute("cart");
		//����������
		CartItem item = new CartItem(id, info, price);
		if(cart==null) {
			//û�й��ﳵ���ȴ���
			cart = new Cart();
			//����������뵽���ﳵ
			cart.getCartItems().add(item);
			item.getNum();
		}else {
			//���ﳵ���ڣ��ж��Ƿ��ظ����
			if(cart.getCartItems().contains(item)) {
				Iterator<CartItem> it = cart.getCartItems().iterator();
				CartItem i = null;
				while(it.hasNext()){
					i = it.next();
					if(i.equals(item))
						break;
				}
				item.setNum(i.getNum()+1);
				//�ظ����,���ӹ����������������ӵ����ﳵ
				cart.getCartItems().remove(item);
				cart.getCartItems().add(item);
			}else {
				cart.getCartItems().add(item);
			}
		}
		//�����ﳵ���뵽session
		session.setAttribute("cart", cart);
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * �Ƴ�������
	 * @param session
	 * @param item Ҫ�Ƴ��Ĺ�����
	 * @throws Exception
	 */
	@RequestMapping("/removeItem")
	public String removeItem(HttpSession session, CartItem item) throws Exception {
		//��ù��ﳵ
		Cart cart = (Cart) session.getAttribute("cart");
		cart.getCartItems().remove(item);
		session.setAttribute("cart", cart);			
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * ��չ��ﳵ
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
	 * ���㣬���ɶ���
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createOrder")
	public String createOrder(HttpSession session) throws Exception {
		//���session�еĹ��ﳵ��������������ɱ��¼
		Cart cart = (Cart) session.getAttribute("cart");
		User u = (User) session.getAttribute("user");
		String orderid = null;
		if (cart.getCartItems().size()>0){
			orderid = oService.insertOrder(cart,u);
		}
		//Ҫ�޸�Ϊת��֧��ҳ��
		return "redirect:/order/toPay.action?orderid=" + orderid;
	}
	
	/**
	 * @author tianheng
	 * @description ��ѯҪ�����Ķ���
	 * @version 1.0
	 * @time 2017��3��12�� ����12:01:19
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
		//�޸Ķ���״̬Ϊ�ѷ���
		oService.updateOrder(id);
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * @author tianheng
	 * @description �ҵı����б�
	 * @version 1.0
	 * @time 2017��3��12�� ����12:44:14
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
	 * @description �޸Ķ���״̬Ϊ�����
	 * @version 1.0
	 * @time 2017��3��12�� ����8:35:34
	 * @return TODO
	 */
	@RequestMapping("/successOrder")
	public String successOrder(String oid) throws Exception {
		oService.updateOrderStatus(oid);
		return "redirect:/category/toIndex.action";
	}
	/**
	 * @author tianheng
	 * @description ��ѯ��ʷ�ѷ�������
	 * @version 1.0
	 * @time 2017��3��12�� ����8:16:14
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
	 * @description �޸�״̬Ϊ���ջ�
	 * @version 1.0
	 * @time 2017��3��12�� ����8:33:20
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
			String r1_Code= request.getParameter("r1_Code");//1����ɹ�
			String r2_TrxId= request.getParameter("r2_TrxId");
			String r3_Amt= request.getParameter("r3_Amt");
			String r4_Cur= request.getParameter("r4_Cur");
			String r5_Pid= request.getParameter("r5_Pid");
			String r6_Order= request.getParameter("r6_Order");//������
			String r7_Uid= request.getParameter("r7_Uid");
			String r8_MP= request.getParameter("r8_MP");
			String r9_BType= request.getParameter("r9_BType");//Ϊ��1��: ������ض���;Ϊ��2��: ��������Ե�ͨѶ.
			String hmac= request.getParameter("hmac");
			//��֤��Ϣ����ȷ��
			boolean b = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");
			if(b){
				if("1".equals(r1_Code)){
					//֧���ɹ�
					if("2".equals(r9_BType)){
						response.getWriter().write("success");
					}
					//���Ķ�����״̬
					Order o = oService.findOrder(r6_Order);
					if(o==null){
						response.getWriter().write("û�иö���");
						return;
					}
					oService.updateOrderStatus(r6_Order);
					response.getWriter().write("<script type='text/javascript'>alert('֧���ɹ�')</script>");
					response.setHeader("Refresh", "0;URL="+request.getContextPath());
				}else{
					response.getWriter().write("֧��ʧ�ܣ�������վ��ϵ");
				}
			}else{
				response.getWriter().write("���ص���Ϣ����,������վ��ϵ");
			}
	}
	
}
