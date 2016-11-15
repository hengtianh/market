package com.hengtian.mapper;

import java.util.List;

import com.hengtian.po.CateItem;
import com.hengtian.po.CateItemVo;
import com.hengtian.po.Product;

public interface CategoryMapper {
	
	public List<CateItemVo> findAllCategory() throws Exception;
	
	public List<CateItem> findAllItems() throws Exception;
	
	public void insertProduct(Product product) throws Exception;
	
	public List<Product> findAllProduct() throws Exception;
	
	public Product findProductById(String pro_id) throws Exception;
	
	public List<Product> findProductByUserId(Integer userid) throws Exception;
}
