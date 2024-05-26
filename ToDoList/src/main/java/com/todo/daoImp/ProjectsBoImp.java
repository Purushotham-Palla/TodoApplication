package com.todo.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.todo.dao.ProjectsBo;
import com.todo.model.Projects;

public class ProjectsBoImp implements ProjectsBo {
	private static Connection connection=null;
	private static PreparedStatement prepareStatement;
	private static Statement statement;
	private static ResultSet res;
	
	private final static String GET_ALL_QUERY = "SELECT * FROM  `projects`";
	
	private final static String INSERT_QUERY = "INSERT into `projects`(`title`) values(?)";

	private final static String UPDATE_QUERY = "UPDATE `projects` SET `title`=? WHERE project_id = ?";
	
	private final static String DELETE_QUERY = "DELETE FROM `projects` WHERE `project_id` = ?";
	
	
	public ProjectsBoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","root");			
			
		} catch (ClassNotFoundException |SQLException e1) {
			e1.printStackTrace();
		} 
	
	}

	@Override
	public int save(Projects pro) {
		try{
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setString(1, pro.getTitle());
			
			int i = prepareStatement.executeUpdate();
			
			return i;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int update(Projects pro) {

		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setString(1, pro.getTitle());
			
			int i = prepareStatement.executeUpdate();
			
			return i;
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return 0;	

	}

	@Override
	public int delete(int projectId) {

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			
			prepareStatement.setInt(1, projectId);
			
			int i = prepareStatement.executeUpdate();
			return i;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	
	}

	
	@Override
	public List<Projects> getAll() {
		
ArrayList<Projects> list = new ArrayList<Projects>();
		
		try {
			statement = connection.createStatement();
			res= statement.executeQuery(GET_ALL_QUERY);
			
			while(res.next())
			{
				
				int projectId = res.getInt("project_id");
				String title = res.getString("title");
				String createdTime = res.getString("created_date");
				
				Projects p = new Projects(projectId, title, createdTime);
				
				list.add(p);
				
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}
