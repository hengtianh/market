package com.hengtian.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hengtian.po.CountCondition;
import com.hengtian.po.Product;
import com.hengtian.service.CategoryService;
import com.hengtian.utils.PageResult;

@Controller
@RequestMapping("/page")
public class PageHandler {
	
	@Autowired
	private CategoryService cService;
	
	@RequestMapping("/getPage")
	public String getPage(int pageIndex, Integer type, Model model) throws Exception {
		//����pageIndex����ѯ��Ҫ��ʾ��ҳ��
		//��װ��ҳ��ѯ���������
		CountCondition condition = new CountCondition(null,type);
		int recordCount = cService.findProductCount(condition);
		PageResult pageResult = new PageResult(recordCount,pageIndex,type);
		//��ҳ��ѯ����
		List<Product> pageLimit = cService.findProductLimit(pageResult);
		model.addAttribute("products", pageLimit);
		//��ҳ�ĵ�������
		model.addAttribute("pageOrder", pageResult);
		return "jsp/index";
	}
}
