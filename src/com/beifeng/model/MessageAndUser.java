package com.beifeng.model;

public class MessageAndUser {
	private Message message;
	private String toUser;
	private String ifRead;
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getIfRead() {
		return ifRead;
	}
	public void setIfRead(String ifRead) {
		this.ifRead = ifRead;
	}
	
	
	
}
