package com.hengtian.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengtian.po.Product;
import com.hengtian.service.CategoryService;
import com.hengtian.utils.PageResult;

@Controller
@RequestMapping("/page")
public class PageHandler {
	
	@Autowired
	private CategoryService cService;
	
	@RequestMapping("/getPage")
	public String getPage(PageResult pr, Model model) throws Exception {
		
		//根据pageIndex来查询需要显示的页面
		
		//封装分页查询所需的数据
		int recordCount = cService.findProductCount(pr);
		PageResult pageResult = new PageResult(recordCount,pr.getPageIndex());
		
		//分页查询数据
		List<Product> pageLimit = cService.findProductLimit(pageResult);
		model.addAttribute("products", pageLimit);
		//分页的导航数据
		model.addAttribute("pageOrder", pageResult);
		return "jsp/index";
	}
}
