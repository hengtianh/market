package com.hengtian.po;

import java.io.Serializable;
import java.util.List;

public class CateItemVo implements Serializable{

	private String cate_name;
	private List<CateItem> cateItems;
	
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public List<CateItem> getCateItems() {
		return cateItems;
	}
	public void setCateItems(List<CateItem> cateItems) {
		this.cateItems = cateItems;
	}
	
	
}
