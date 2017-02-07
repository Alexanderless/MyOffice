package com.beifeng.model;

import java.util.List;

public class PageBranchInfo {
	private int currentPage;//当前页码  
	private int pageRecords;//每页记录数   
	private int beginPage;	//从第几条开始查询
	private int totalRecords;//总记录数  
	private int totalPages;//总页数  
	private List<BranchInfo> list;
	
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
	public List<BranchInfo> getList() {
		return list;
	}
	public void setList(List<BranchInfo> list) {
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
	
	
	
}
