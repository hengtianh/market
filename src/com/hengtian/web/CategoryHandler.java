package com.hengtian.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import com.hengtian.utils.PageResult;

@Controller
@RequestMapping("/category")
public class CategoryHandler {

	@Autowired
	private CategoryService cService;
	
	/**
	 * 主页面查询类别信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showCategory")
	public @ResponseBody List<CateItemVo> showCategory() throws Exception {
		List<CateItemVo> lists = cService.findAllCategory();
		return lists;
	}
	
	/**
	 * 转向添加商品页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/product/toAddProduct")
	public String toAddProduct(Model model) throws Exception {
		//加载类别信息
		List<CateItem> lists = cService.findAllItems();
		model.addAttribute("items", lists);
		return "jsp/sel/addProduct";
	}
	
	/**
	 * 添加商品信息
	 * @param product
	 * @param proImg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/product/addProduct")
	public String addProduct(Product product, MultipartFile proImg) throws Exception {
		//添加商品
		//处理上传的图片
		//文件的保存路径
		String filePath = "E:\\workspace\\develop\\upload\\"; 
		//文件的名称
		String fileName = proImg.getOriginalFilename();
		//新的图片名称
		String newFileName = UUID.randomUUID().toString()+fileName.lastIndexOf('.');
		System.out.println(newFileName);
		//将内存上的文件保存到磁盘上
		File file = new File(filePath+newFileName);
		proImg.transferTo(file);
		//将文件路径保存到数据库
		product.setImg(newFileName);
		product.setPro_id(IDGenerater.generatProId());
		cService.insertProduct(product);
		return "redirect:/category/toIndex.action";
	}
	
	/**
	 * 加载首页内容，跳转到首页
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toIndex")
	public String toIndex(Model model, HttpServletRequest request, PageResult pr) throws Exception {
		//封装分页查询所需的数据
		PageResult pageResult = null;
		int recordCount = cService.findProductCount(pr);
		pageResult = new PageResult(recordCount,1);
		pageResult.setType(pr.getType());
		List<Product> pageLimit = cService.findProductLimit(pageResult);
		model.addAttribute("products", pageLimit);
		//分页的导航数据
		request.setAttribute("pageOrder", pageResult);
		return "jsp/index";
	}
	
	/**
	 * 查询商品的详细信息
	 * @param pro_id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String pro_id, Model model) throws Exception {
		//加载商品详细信息，转向详细页
		Product p = cService.findProductById(pro_id);
		model.addAttribute("pd", p);
		return "jsp/p_detail";
	}
	
	@RequestMapping("/showMyProducts")
	public String showMyProducts(Integer userid, Model model) throws Exception {
		//加载商品详细信息，转向详细页
		List<Product> lists = cService.findProductByUserId(userid);
		model.addAttribute("pl", lists);
		return "jsp/sel/onSells";
	}
	
	
}
 