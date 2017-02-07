package com.beifeng.model;

public class Page {
	private int currentPage;//当前页码  
	private int pageRecords=6;//每页记录数   
	private int beginPage;	//从第几条开始查询
	private int totalRecords;//总记录数  
	private int totalPages;//总页数  
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
	public int getBeginPage() {
		beginPage = (currentPage-1)*pageRecords;
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
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
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
