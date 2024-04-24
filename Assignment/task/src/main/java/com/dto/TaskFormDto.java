package com.dto;

public class TaskFormDto {
	
	private String taskName;
	private String assignee;
	private String discription;
	private String date;
	private String city;
	private String priority;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public TaskFormDto(String taskName, String assignee, String discription, String date, String city,
			String priority) {
		super();
		this.taskName = taskName;
		this.assignee = assignee;
		this.discription = discription;
		this.date = date;
		this.city = city;
		this.priority = priority;
	}
	public TaskFormDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
