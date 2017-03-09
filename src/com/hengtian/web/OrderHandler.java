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
		if (cart.getCartItems().size()>0){
			oService.insertOrder(cart,u);
		}
		
		return "redirect:/category/toIndex.action";
	}
	
	@RequestMapping("/findMyOrderDetail")
	public String findMyOrderDetail(HttpSession session, Model model) throws Exception {
		//��ѯҪ�����Ķ���
		User u = (User) session.getAttribute("user");
		String cuName = u.getRealName();
		List<OrderDetail> ods = oService.findMyOrderDetail(cuName);
		model.addAttribute("ods", ods);
		return "jsp/sel/addProduct";
	}
	
}
