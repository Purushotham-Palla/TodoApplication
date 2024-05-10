package com.todo.model;

public class Login {

	private String id;
	private String password;
	private String userName;
	
	
	public Login() {
	}


	public Login(String id, String password, String userName) {
		super();
		this.id = id;
		this.password = password;
		this.userName = userName;
	}
	
	//bcz of id is auto increment
	public Login(String userName,String password) {
		super();
		this.userName = userName;
		this.password = password;
	}





	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
