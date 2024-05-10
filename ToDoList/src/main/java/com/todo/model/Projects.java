package com.todo.model;

public class Projects {
	private int projectId;
	private String title;
	private String createdTime;
	
	
	public Projects() {
		super();
	}
	
	public Projects(String title) {
		super();
		this.title = title;
		
	}

	

	

	public Projects(int projectId, String title, String createdTime) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.createdTime = createdTime;
	}
	
	public Projects(String title, String createdTime) {
		super();
		this.title = title;
		this.createdTime = createdTime;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	
	
	
	
	
	

}
