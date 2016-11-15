package com.hengtian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hengtian.mapper.CategoryMapper;
import com.hengtian.po.CateItem;
import com.hengtian.po.CateItemVo;
import com.hengtian.po.Product;
import com.hengtian.service.CategoryService;

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
		//��ѯ���е���Ʒ����Ϣ
		List<Product> lists = categoryMapper.findAllProduct();
		return lists;
	}

	@Override
	public Product findProductById(String pro_id) throws Exception {
		//��ѯ��Ʒ����ϸ��Ϣ
		Product p = categoryMapper.findProductById(pro_id);
		return p;
	}

	@Override
	public List<Product> findProductByUserId(Integer userid) throws Exception {
		//�����û�id��ѯ�����е���Ʒ
		List<Product> lists = categoryMapper.findProductByUserId(userid);
		return lists;
	}

}