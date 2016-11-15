package com.hengtian.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hengtian.po.CateItem;
import com.hengtian.po.CateItemVo;
import com.hengtian.po.Product;
import com.hengtian.service.CategoryService;
import com.hengtian.utils.IDGenerater;

@Controller
@RequestMapping("/category")
public class CategoryHandler {

	@Autowired
	private CategoryService cService;
	
	/**
	 * ��ҳ���ѯ�����Ϣ
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showCategory")
	public @ResponseBody List<CateItemVo> showCategory() throws Exception {
		List<CateItemVo> lists = cService.findAllCategory();
		return lists;
	}
	
	/**
	 * ת��������Ʒҳ��
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toAddProduct")
	public String toAddProduct(Model model) throws Exception {
		//���������Ϣ
		List<CateItem> lists = cService.findAllItems();
		model.addAttribute("items", lists);
		return "jsp/sel/addProduct";
	}
	
	/**
	 * ������Ʒ��Ϣ
	 * @param product
	 * @param proImg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addProduct")
	public String addProduct(Product product, MultipartFile proImg) throws Exception {
		//������Ʒ
		//�����ϴ���ͼƬ
		//�ļ��ı���·��
		String filePath = "F:\\workspace\\develop\\upload\\"; 
		//�ļ�������
		String fileName = proImg.getOriginalFilename();
		//�µ�ͼƬ����
		String newFileName = UUID.randomUUID().toString()+fileName.lastIndexOf('.');
		System.out.println(newFileName);
		//���ڴ��ϵ��ļ����浽������
		File file = new File(filePath+newFileName);
		proImg.transferTo(file);
		//���ļ�·�����浽���ݿ�
		product.setImg(newFileName);
		product.setPro_id(IDGenerater.generatProId());
		cService.insertProduct(product);
		return "redirect:category/toIndex.action";
	}
	
	/**
	 * ������ҳ���ݣ���ת����ҳ
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toIndex")
	public String toIndex(Model model) throws Exception {
		//�������е���Ʒ��Ϣ��ת����ҳ
		List<Product> lists = cService.findAllProduct();
		model.addAttribute("products",lists);
		return "redirect:category/toIndex.action";
	}
	
	/**
	 * ��ѯ��Ʒ����ϸ��Ϣ
	 * @param pro_id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String pro_id, Model model) throws Exception {
		//������Ʒ��ϸ��Ϣ��ת����ϸҳ
		Product p = cService.findProductById(pro_id);
		model.addAttribute("pd", p);
		return "jsp/p_detail";
	}
	
	@RequestMapping("/showMyProducts")
	public String showMyProducts(Integer userid, Model model) throws Exception {
		//������Ʒ��ϸ��Ϣ��ת����ϸҳ
		List<Product> lists = cService.findProductByUserId(userid);
		model.addAttribute("pl", lists);
		return "jsp/sel/addProduct";
	}
	
	
}
 