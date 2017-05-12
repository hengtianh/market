package com.hengtian.service;

import java.util.List;
import com.hengtian.po.CateItem;
import com.hengtian.po.CateItemVo;
import com.hengtian.po.Category;
import com.hengtian.po.CountCondition;
import com.hengtian.po.Product;
import com.hengtian.utils.PageResult;

public interface CategoryService {
	
	public List<CateItemVo> findAllCategory() throws Exception; 
	
	public List<Category> findAllCategoryid() throws Exception; 
	
	public List<CateItem> findAllItems() throws Exception;
	
	public void insertCategory(CateItem c) throws Exception;
	
	public void insertProduct(Product product) throws Exception;
	
	public List<Product> findAllProduct() throws Exception;
	
	public List<Product> findProductLikeLabel(String label) throws Exception;
	
	public Product findProductById(String pro_id) throws Exception;
	
	public List<Product> findProductByUserId(Integer userid) throws Exception;
	
	public List<Product> findProductLimit(PageResult pageResult) throws Exception;
	
	public int findProductCount(CountCondition condition) throws Exception;
}
