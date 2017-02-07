package com.beifeng.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Message {
	private Integer messageId;
	private String title;
	private String allContent;
	private String content;
	private MessageType messageType;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	private Integer ifPublish;  //是否已发布，1发布0未发布
	private Date recordTime;
	private UserInfo userInfo;   //关联发布者
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAllContent() {
		return allContent;
	}
	public void setAllContent(String allContent) {
		this.allContent = allContent;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
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
	public Integer getIfPublish() {
		return ifPublish;
	}
	public void setIfPublish(Integer ifPublish) {
		this.ifPublish = ifPublish;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
