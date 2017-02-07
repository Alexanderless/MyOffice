package com.beifeng.model;

public class PageUtil {

	private Integer pageSize=1;//页码
	private Integer pageCount=10;//每页条数
	private Integer total;//总数
	
	private Integer beforeSize;
	
	
	public Integer getBeforeSize() {
		return (pageSize-1)*pageCount;
	}
	public void setBeforeSize(Integer beforeSize) {
		this.beforeSize = beforeSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCount() {
		
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PageUtil [pageSize=" + pageSize + ", pageCount=" + pageCount
				+ ", total=" + total + ", beforeSize=" + beforeSize + "]";
	}


}
