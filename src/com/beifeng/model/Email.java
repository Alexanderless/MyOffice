package com.beifeng.model;

public class Email {
	private Integer inboxCount;//�ռ����ļ�����
	private Integer unread;	//�Ѷ�
	private Integer send;    //�ѷ���
	
	public Integer getInboxCount() {
		return inboxCount;
	}
	public void setInboxCount(Integer inboxCount) {
		this.inboxCount = inboxCount;
	}
	public Integer getUnread() {
		return unread;
	}
	public void setUnread(Integer unread) {
		this.unread = unread;
	}
	public Integer getSend() {
		return send;
	}
	public void setSend(Integer send) {
		this.send = send;
	}
	
}
