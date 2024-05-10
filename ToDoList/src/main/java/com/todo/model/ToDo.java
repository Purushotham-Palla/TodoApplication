package com.todo.model;

public class ToDo {
	private int todoId;
	private int projectId;
	private String description;
	private boolean status;
	private String createdDate;
	private String updatedDate;
	
	private String projectTitle;
	

	public ToDo() {
		super();
	}
	
	
	public ToDo(String projectTitle){
		this.projectTitle = projectTitle;
	}


	//main Construction
	public ToDo(int todoId, int projectId, String description, boolean status, String createdDate, String updatedDate,
			String project_title) {
		super();
		this.todoId = todoId;
		this.projectId = projectId;
		this.description = description;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.projectTitle = project_title;
	}
	
	public ToDo(int todoId, int projectId, String description, boolean status,
			String projectTitle) {
		super();
		this.todoId = todoId;
		this.projectId = projectId;
		this.description = description;
		this.status = status;
		this.projectTitle = projectTitle;
	}

//						todoId,description,status,projectTitle);

//	ToDo toDo = new ToDo(todoId,description,status,projectTitle,projectId);
	public ToDo(int todoId,String description, boolean status,String projectTitle ) {
		super();
		this.todoId = todoId;
		this.description = description;
		this.status = status;
		this.projectTitle = projectTitle;
	}
	
	
	
	

	//for getOneTodo()
//	(todo_id,project_id,description,status);
	public ToDo(int todoId, int projectId, String description, boolean status) {
		super();
		this.todoId = todoId;
		this.projectId = projectId;
		this.description = description;
		this.status = status;
	}
	
	//for getOneProject()
	
	
	public ToDo(int todoId, int projectId, String description, boolean status, String createdDate, String updatedDate) {
		super();
		this.todoId = todoId;
		this.projectId = projectId;
		this.description = description;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	
	
	
	public ToDo(String description, boolean status, String createdDate, String updatedDate) {
		super();
		this.description = description;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	
	//for to editTodo
	public ToDo(String description, boolean status) {
		this.description = description;
		this.status = status;
	}
	
	
	//for addtTodo
	public ToDo(int projectId , String description) {
		this.projectId = projectId;
		this.description = description;
	}
	
	public ToDo(String description, boolean status,String projectTitle) {
		this.description = description;
		this.status = status;
	}
	
	

	public int getTodoId() {
		return todoId;
	}


	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public String getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}


	public String getProjectTitle() {
		return projectTitle;	
	}
	
	
	
	

}
