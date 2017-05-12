package com.hengtian.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PageResult implements Serializable {
	private int pageIndex = 1; // ��ǰҳ
	private int pageSize = 4;  //ÿҳ��¼��
	private int recordCount;   //�ܼ�¼��
	private int pageCount = (recordCount-1)/pageSize+1;  //��ҳ��
	private int start;  //��ѯ����ʼ��¼��
	private int size = 4;  //ÿҳ��ʾ��ҳ����
	private int endPage;  //βҳ��
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
		if (recordCount >= size * pageSize){//�ܼ�¼������Լ����ʾҳ��
			pages = new int[size];
			if (pageIndex == 1){
				//��ǰҳΪ��һҳ
				for (int i=0; i < pages.length; i++){
					pages[i] = pageIndex + i;
				}
			} else if (pageIndex == pageCount){
				//��ǰҳΪ���һҳ
				for (int i=0; i < pages.length; i++){
					pages[i] = pageIndex - (pages.length - 1 - i);
				}
			} else {
				//��ǰҳ���м�
				for (int i=0; i < pages.length; i++){
					int center = pages.length / 2;
					pages[i] = pageIndex - (center - i);
				}
			}
		}else{//�ܼ�¼��С��Լ����ʾҳ������ȫ��ʾ
			pages = new int[pageCount];
			if (pageIndex == 1){
				//��ǰҳΪ��һҳ
				for (int i=0; i < pages.length; i++){
					pages[i] = pageIndex + i;
				}
				
			} else if (pageIndex == pageCount){
				//��ǰҳΪ���һҳ
				for (int i=0; i < pages.length; i++){
					 pages[i] = pageIndex - (pages.length - 1 - i);
				}
			} else {
				//��ǰҳ���м�
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
