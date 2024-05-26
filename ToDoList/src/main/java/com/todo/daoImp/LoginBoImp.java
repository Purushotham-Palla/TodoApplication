package com.todo.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.todo.dao.LoginBo;
import com.todo.model.Login;

public class LoginBoImp implements LoginBo{

	private static Connection connection=null;
	private static PreparedStatement prepareStatement;
	private static Statement statement;
	private static ResultSet res;
	
	private final static String IN_REGISTER_QUERY = "INSERT INTO `login` (`username`,`password`) VALUES(?,?)";
	
	private final static  String GET_LOGIN_QUERY = "SELECT * FROM `login` where `username`=? and `password`=?";
	
	public LoginBoImp() {
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","root");			
				
			} catch (ClassNotFoundException |SQLException e1) {
				e1.printStackTrace();
			} 
	 }

	
	public Login getLogin( String userName,String password)
	{
		Login log=null;
		
		try {
			
			prepareStatement=connection.prepareStatement(GET_LOGIN_QUERY);
			prepareStatement.setString(1, userName);
			prepareStatement.setString(2, password);
			
			ResultSet res = prepareStatement.executeQuery();
			
			if(res.next())
			{
				userName = res.getString("username");
				password = res.getString("password");
				log=new Login(userName,password);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return log;
	}
	
	
	 public int save(Login log)
	{
		try{
			prepareStatement = connection.prepareStatement(IN_REGISTER_QUERY);
			
			prepareStatement.setString(1, log.getUserName());
			prepareStatement.setString(2, log.getPassword());
			int i = prepareStatement.executeUpdate();
			return i;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
}

