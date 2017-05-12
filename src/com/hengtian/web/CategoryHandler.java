package com.hengtian.web;

import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.hengtian.po.CateItem;
import com.hengtian.po.CateItemVo;
import com.hengtian.po.CountCondition;
import com.hengtian.po.Product;
import com.hengtian.service.CategoryService;
import com.hengtian.utils.IDGenerater;
import com.hengtian.utils.PageResult;

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
	 * @author tianheng
	 * @description �����Ʒ���
	 * @version 1.0
	 * @time 2017��3��25�� ����11:13:58
	 * @return TODO
	 */
	@RequestMapping("/addCategory")
	public String addCategory(CateItem c) throws Exception {
		cService.insertCategory(c);
		return "jsp/manager/addCategory";
	}
	/**
	 * ת�������Ʒҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/product/toAddProduct")
	public String toAddProduct(Model model) throws Exception {
		// ���������Ϣ
		List<CateItem> lists = cService.findAllItems();
		model.addAttribute("items", lists);
		return "jsp/sel/addProduct";
	}
	/**
	 * �����Ʒ��Ϣ
	 * @param product
	 * @param proImg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/product/addProduct")
	public String addProduct(Product product, MultipartFile proImg, HttpSession session) throws Exception {
		// �����Ʒ
		// �����ϴ���ͼƬ
		// �ļ��ı���·��
		String filePath = "E:\\workspace\\develop\\temp\\";
		System.out.println(filePath);
		// �ļ�������
		String fileName = proImg.getOriginalFilename();
		// �µ�ͼƬ����
		String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf('.'));
		System.out.println(newFileName);
		// ���ڴ��ϵ��ļ����浽������
		File file = new File(filePath + newFileName);
		proImg.transferTo(file);
		// ���ļ�·�����浽���ݿ�
		product.setImg(newFileName);
		product.setPro_id(IDGenerater.generatProId());
		cService.insertProduct(product);
		return "redirect:/category/toIndex.action";
	}
	/**
	 * ������ҳ���ݣ���ת����ҳ
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toIndex")
	public String toIndex(Model model, Integer type, HttpServletRequest request) throws Exception {
		// ��װ��ҳ��ѯ���������
		CountCondition condition = new CountCondition(null,type);
		int recordCount = cService.findProductCount(condition);
		PageResult pageResult = new PageResult(recordCount, 1, type);
		List<Product> pageLimit = cService.findProductLimit(pageResult);
		model.addAttribute("products", pageLimit);
		// ��ҳ�ĵ�������
		request.setAttribute("pageOrder", pageResult);
		return "jsp/index";
	}
	@RequestMapping("/search")
	public String search(Model model, String label, HttpServletRequest request) throws Exception {
		// ��װ��ҳ��ѯ���������
		CountCondition condition = new CountCondition(label,null);
		int recordCount = cService.findProductCount(condition);
		PageResult pageResult = new PageResult(recordCount, 1, null);
		List<Product> pageLimit = cService.findProductLikeLabel(label);
		model.addAttribute("products", pageLimit);
		// ��ҳ�ĵ�������
		request.setAttribute("pageOrder", pageResult);
		return "jsp/index";
	}
	/**
	 * ��ѯ��Ʒ����ϸ��Ϣ
	 * 
	 * @param pro_id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String pro_id, Model model) throws Exception {
		// ������Ʒ��ϸ��Ϣ��ת����ϸҳ
		Product p = cService.findProductById(pro_id);
		model.addAttribute("pd", p);
		return "jsp/p_detail";
	}
	@RequestMapping("/showMyProducts")
	public String showMyProducts(Integer userid, Model model) throws Exception {
		// ������Ʒ��ϸ��Ϣ��ת����ϸҳ
		List<Product> lists = cService.findProductByUserId(userid);
		model.addAttribute("pl", lists);
		return "jsp/sel/onSells";
	}
}
