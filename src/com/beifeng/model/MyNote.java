package com.beifeng.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MyNote {
	private Integer noteId;//��ǩid
	private String noteTitle;//��ǩ����
	private String noteContent;//��ǩ����
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;//����ʱ��
	private UserInfo userInfo;//������
	
	public MyNote(){}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "MyNote [noteId=" + noteId + ", noteTitle=" + noteTitle
				+ ", noteContent=" + noteContent + ", createTime=" + createTime
				+ ", userInfo=" + userInfo + "]";
	}
	
	
	
}	
