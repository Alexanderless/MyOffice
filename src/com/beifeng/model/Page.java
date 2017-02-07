package com.beifeng.model;

public class Page {
	private int currentPage;//��ǰҳ��  
	private int pageRecords=6;//ÿҳ��¼��   
	private int beginPage;	//�ӵڼ�����ʼ��ѯ
	private int totalRecords;//�ܼ�¼��  
	private int totalPages;//��ҳ��  
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
