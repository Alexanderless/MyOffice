package com.beifeng.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Schedule {
	private Integer scheduleId;//日程id
	private String title;//日程标题
	private String address;//会议地址
	private  MeetingInfo meetingInfo;//会议类型
	@DateTimeFormat  (pattern="yyyy-MM-dd")
	private Date beginTime;//日程开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;//日程结束时间
	private String schContent;//日程内容
	private UserInfo userInfo;//创建者
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;//创建时间
	private Integer ifPrivate;//是否私有
	private DepartInfo departInfo;
	private BranchInfo branchInfo;
	public Schedule(){}
	
	public Integer getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public MeetingInfo getMeetingInfo() {
		return meetingInfo;
	}

	public void setMeetingInfo(MeetingInfo meetingInfo) {
		this.meetingInfo = meetingInfo;
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
	public String getSchContent() {
		return schContent;
	}
	public void setSchContent(String schContent) {
		this.schContent = schContent;
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIfPrivate() {
		return ifPrivate;
	}
	public void setIfPrivate(Integer ifPrivate) {
		this.ifPrivate = ifPrivate;
	}
	

	public DepartInfo getDepartInfo() {
		return departInfo;
	}

	public void setDepartInfo(DepartInfo departInfo) {
		this.departInfo = departInfo;
	}

	public BranchInfo getBranchInfo() {
		return branchInfo;
	}

	public void setBranchInfo(BranchInfo branchInfo) {
		this.branchInfo = branchInfo;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", title=" + title
				+ ", address=" + address + ", meetingInfo=" + meetingInfo
				+ ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", schContent=" + schContent + ", userInfo=" + userInfo
				+ ", createTime=" + createTime + ", ifPrivate=" + ifPrivate
				+ ", departInfo=" + departInfo + ", branchInfo=" + branchInfo
				+ "]";
	}

	
	
}
