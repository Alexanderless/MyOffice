package com.beifeng.model;

import java.util.List;

public class PageUserInfo {
	private int currentPage;//当前页码  
	private int pageRecords=5;//每页记录数   
	private int beginPage;	//从第几条开始查询
	private int totalRecords;//总记录数  
	private int totalPages;//总页数  
	private List<UserInfo> list;
	public PageUserInfo(){}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageRecords() {
		return pageRecords;
	}
	public void setPageRecords(int pageRecords) {
		this.pageRecords = pageRecords;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getTotalPages() {
		int tp=(int)Math.ceil(totalRecords*1.0/pageRecords);
		totalPages = Integer.valueOf(tp);
		return totalPages;
	}
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}

	public int getBeginPage() {	
		beginPage = (currentPage-1)*pageRecords;
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public PageUserInfo(int currentPage, int pageRecords, int beginPage,
			int totalRecords, int totalPages, List<UserInfo> list) {
		super();
		this.currentPage = currentPage;
		this.pageRecords = pageRecords;
		this.beginPage = beginPage;
		this.totalRecords = totalRecords;
		this.totalPages = totalPages;
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageUserInfo [currentPage=" + currentPage + ", pageRecords="
				+ pageRecords + ", beginPage=" + beginPage + ", totalRecords="
				+ totalRecords + ", totalPages=" + totalPages + ", list="
				+ list + "]";
	}
	
	
}
