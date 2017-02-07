package com.beifeng.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class PageMessage {
	private int currentPage;//当前页码  
	private int pageRecords=3;//每页记录数   
	private int beginPage;	//从第几条开始查询
	private int totalRecords;//总记录数  
	private int totalPages;//总页数  
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	private List<MessageAndUser> list;
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
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public List<MessageAndUser> getList() {
		return list;
	}
	public void setList(List<MessageAndUser> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageMessage [currentPage=" + currentPage + ", pageRecords="
				+ pageRecords + ", beginPage=" + beginPage + ", totalRecords="
				+ totalRecords + ", totalPages=" + totalPages + ", beginTime="
				+ beginTime + ", endTime=" + endTime + ", list=" + list + "]";
	}
	
}
