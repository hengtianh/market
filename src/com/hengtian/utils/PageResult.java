package com.hengtian.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PageResult implements Serializable {
	private int pageIndex = 1; // 当前页
	private int pageSize = 4;  //每页记录数
	private int recordCount;   //总记录数
	private int pageCount = (recordCount-1)/pageSize+1;  //总页数
	private int start;  //查询的起始记录号
	private int size = 4;  //每页显示的页码数
	private int endPage;  //尾页码
	private int[] pages;
	private Integer type;
	
	public PageResult() {
		super();
	}

	public PageResult(int recordCount, int pageIndex, Integer type) {
		this.recordCount = recordCount;
		this.pageIndex = pageIndex;
		this.type = type;
		this.start = (pageIndex-1) * pageSize;
		this.pageCount = (recordCount-1) / pageSize+1;
		if ((recordCount-start) < pageSize){
			pageSize = recordCount-start;
		}
		if (recordCount >= size * pageSize){//总记录数大于约定显示页数
			pages = new int[size];
			if (pageIndex == 1){
				//当前页为第一页
				for (int i=0; i < pages.length; i++){
					pages[i] = pageIndex + i;
				}
			} else if (pageIndex == pageCount){
				//当前页为最后一页
				for (int i=0; i < pages.length; i++){
					pages[i] = pageIndex - (pages.length - 1 - i);
				}
			} else {
				//当前页在中间
				for (int i=0; i < pages.length; i++){
					int center = pages.length / 2;
					pages[i] = pageIndex - (center - i);
				}
			}
		}else{//总记录数小于约定显示页数，则全显示
			pages = new int[pageCount];
			if (pageIndex == 1){
				//当前页为第一页
				for (int i=0; i < pages.length; i++){
					pages[i] = pageIndex + i;
				}
				
			} else if (pageIndex == pageCount){
				//当前页为最后一页
				for (int i=0; i < pages.length; i++){
					 pages[i] = pageIndex - (pages.length - 1 - i);
				}
			} else {
				//当前页在中间
				for (int i=0; i < pages.length; i++){
					int center = pages.length / 2;
					pages[i] = pageIndex - (center - i);
				}
			}
		}
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public int[] getPages() {
		return this.pages;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return endPage;
	}
	public void setEnd(int endPage) {
		this.endPage = endPage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
