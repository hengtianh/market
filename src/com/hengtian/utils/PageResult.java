package com.hengtian.utils;

import java.io.Serializable;

public class PageResult implements Serializable {
	private int pageIndex = 1; // ��ǰҳ
	private int pageSize = 4;  //ÿҳ��¼��
	private int recordCount;   //�ܼ�¼��
	private int pageCount = (recordCount-1)/pageSize+1;  //��ҳ��
	private int start;  //��ѯ����ʼ��¼��
	private int size = 3;  //ÿҳ��ʾ��ҳ����
	private int startPage;  //��ʼҳ��
	private int endPage;  //βҳ��
	private int[] pages;
	private Integer type;
	
	public PageResult() {
		super();
	}

	public PageResult(int recordCount, int pageIndex) {
		this.recordCount = recordCount;
		this.pageIndex = pageIndex;
		this.start = (pageIndex-1)*pageSize;
		this.pageCount = (recordCount-1)/pageSize+1;
		if(recordCount>=size*pageSize){
			pages = new int[size];
			if(pageIndex==1){
				//��ǰҳΪ��һҳ
				for(int i=1; i<=pages.length; i++){
					pages[i-1] = pageIndex + i-1;
				}
				
			}else if(pageIndex==pageCount){
				//��ǰҳΪ���һҳ
				for(int i=1; i<=pages.length; i++){
					pages[i-1] = pageIndex-size + i;//3,4,5  5-3+1 5-3+2
				}
			}else{
				//��ǰҳ���м�
				for(int i=1; i<=pages.length; i++){
					pages[i-1] = pageIndex-size/2-1+i;//3,4,5  4-2+i 4-2+i 4-2+i
				}
			}
		}else{
			pages = new int[pageCount];
			for(int i=1; i<=pages.length; i++){
				pages[i-1] = i;   //
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
