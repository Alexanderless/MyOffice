package com.beifeng.model;

public class WorkTime {
	
	private Integer workTimeId; //����ʱ��Id
	private String onDutyTime; //�ϰ�ʱ��
	private String offDutyTime; //�°�ʱ��
	
	public WorkTime(){}

	public Integer getWorkTimeId() {
		return workTimeId;
	}

	public void setWorkTimeId(Integer workTimeId) {
		this.workTimeId = workTimeId;
	}

	public String getOnDutyTime() {
		return onDutyTime;
	}

	public void setOnDutyTime(String onDutyTime) {
		this.onDutyTime = onDutyTime;
	}

	public String getOffDutyTime() {
		return offDutyTime;
	}

	public void setOffDutyTime(String offDutyTime) {
		this.offDutyTime = offDutyTime;
	}

	@Override
	public String toString() {
		return "WorkTime [workTimeId=" + workTimeId + ", onDutyTime="
				+ onDutyTime + ", offDutyTime=" + offDutyTime + "]";
	}
	
	
}
