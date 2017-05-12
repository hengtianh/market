package com.hengtian.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.hengtian.mapper.CategoryMapper;
import com.hengtian.po.CateItem;
import com.hengtian.po.CateItemVo;
import com.hengtian.po.Category;
import com.hengtian.po.CountCondition;
import com.hengtian.po.Product;
import com.hengtian.service.CategoryService;
import com.hengtian.utils.PageResult;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<CateItemVo> findAllCategory() throws Exception {
		List<CateItemVo> lists = categoryMapper.findAllCategory();
		return lists;
	}
	@Override
	public List<CateItem> findAllItems() throws Exception {
		List<CateItem> lists = categoryMapper.findAllItems();
		return lists;
	}
	@Override
	public void insertProduct(Product product) throws Exception {
		categoryMapper.insertProduct(product);
	}
	@Override
	public List<Product> findAllProduct() throws Exception {
		//查询所有的商品的信息
		List<Product> lists = categoryMapper.findAllProduct();
		return lists;
	}
	@Override
	public Product findProductById(String pro_id) throws Exception {
		//查询商品的详细信息
		Product p = categoryMapper.findProductById(pro_id);
		return p;
	}
	@Override
	public List<Product> findProductByUserId(Integer userid) throws Exception {
		//根据用户id查询其所有的商品
		List<Product> lists = categoryMapper.findProductByUserId(userid);
		return lists;
	}
	/**
	 * 查询分页信息
	 */
	@Override
	public List<Product> findProductLimit(PageResult pageResult) throws Exception {
		List<Product> lists = categoryMapper.findProductLimit(pageResult);
		return lists;
	}
	/**
	 * 查询总记录数
	 */
	@Override
	public int findProductCount(CountCondition condition) throws Exception {
		int pageCount = categoryMapper.findProductCount(condition);
		return pageCount;
	}
	@Override
	public void insertCategory(CateItem c) throws Exception {
		categoryMapper.insertCategory(c);
	}
	@Override
	public List<Product> findProductLikeLabel(String label) throws Exception {
		List<Product> lists = categoryMapper.findProductLikeLabel(label);
		return lists;
	}
	@Override
	public List<Category> findAllCategoryid() throws Exception {
		return categoryMapper.findAllCategoryid();
	}
}
