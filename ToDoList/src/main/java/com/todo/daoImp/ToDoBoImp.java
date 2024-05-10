package com.todo.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.todo.dao.ToDoBo;
import com.todo.model.ToDo;

public class ToDoBoImp  implements ToDoBo{
	private static Connection connection=null;
	private static PreparedStatement prepareStatement;
	private static Statement statement;
	private static ResultSet res;
	
	private final static String INSERT_QUERY = "INSERT into `todo`(`project_id`,`description`) values(?,?)";
	
	private final static String UPDATE_QUERY1 = "UPDATE `todo` SET `description`= ? ,`status`=? WHERE todo_id = ?";
	
	private final static String UPDATE_QUERY2 = "UPDATE `projects` SET `title`= ? WHERE project_id = ?";

//	private final static String UPDATE_QUERY3 = "UPDATE `projects` SET `title`= ? WHERE projects_id = ?";

	private final static String GET_ONE_QUERY = "SELECT  * FROM  `todo` INNER JOIN `projects`  WHERE `todo_id` = ?"; //	correct one
	private final static String GET_Todo_QUERY = "SELECT  * FROM  `todo` WHERE `todo_id` = ?"; //editied new
	
	private final static String GET_Project_QUERY = "SELECT  title FROM  `projects` WHERE `project_id` = ?"; //editied new
	
	private final static String GET_ONE1_QUERY = "SELECT  * FROM  `todo` INNER JOIN `projects` ON `todo.project_id`=`projects.project_id` WHERE `todo_id` = ? AND `projects.project_id`=?";
	
//	private final static String GET_ONE_QUERY = "SELECT  `todo_Id`, `p.title`,`t.description`, `t.status` FROM  `todo` t INNER JOIN `projects` p ON `t.project_id` = `p.project_id`  WHERE `todo_id` = ?";
//	private final static String GET_ONE_QUERY = "SELECT  *, `p.title` FROM  `todo` t INNER JOIN `projects` p ON `t.project_id` = `p.project_id`  WHERE `todo_id` = ?";
	
//	private final static String GET_ONE_QUERY = "SELECT `p.title`,`t.description`, `t.created_date`, `t.status` FROM  `todo` t INNER JOIN `projects` p ON `t.project_id` = `p.project_id`  WHERE `todo_id` = ?";
	
	private final static String DELETE_QUERY = "DELETE FROM `todo` WHERE `todo_id` = ?";
	
	private final static String GET_ALL_QUERY = "SELECT * FROM  `todo` where `project_id`= ?";
	
	public ToDoBoImp() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","root");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		
	
	}

	@Override
	public int save(ToDo td) {
		
		
		try{
			prepareStatement = connection.prepareStatement(INSERT_QUERY);

			prepareStatement.setInt(1, td.getProjectId());
			prepareStatement.setString(2, td.getDescription());
			
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
	public int update(ToDo td) {
		
		try {
//			UPDATE_QUERY1 = "UPDATE `todo` SET `description`= ? ,`status`=? WHERE todo_id = ?";
			prepareStatement = connection.prepareStatement(UPDATE_QUERY1);
			//attaching to ??
//			prepareStatement.setString(1, td.getProject_title());
			
			prepareStatement.setString(1, td.getDescription());
			int status=0;
			if(td.isStatus()==true)
			{
				status=1;
			}
//			prepareStatement.setBoolean(2, td.isStatus());
			prepareStatement.setInt(2, status);
			prepareStatement.setInt(3, td.getTodoId());
			
			
			int i = prepareStatement.executeUpdate();
//			private final static String UPDATE_QUERY2 = "UPDATE `projects` SET `title`= ? WHERE project_id = ?";
			prepareStatement = connection.prepareStatement(UPDATE_QUERY2);
			prepareStatement.setString(1, td.getProjectTitle());
			prepareStatement.setInt(2, td.getProjectId());
			
			int j = prepareStatement.executeUpdate();
			
			
			return i+j;
//			return i;
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return 0;

		
	}


	@Override
	public int delete(int todoId) {

//		private final static String DELETE_QUERY = "DELETE FROM `todo` WHERE `todo_id` = ?";
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			
			prepareStatement.setInt(1, todoId);
			
			int i = prepareStatement.executeUpdate();
			return i;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}

	@Override
	public ToDo getOne(int todoId) {

		ToDo td=null;
		try { 
			
//			 String GET_ONE1_QUERY = "SELECT  `todo_Id`, `p.title`,`t.description`, `t.status` FROM  `todo` t INNER JOIN `projects` p ON `t.project_id` = `p.project_id`  WHERE `todo_id` = ?";
			prepareStatement = connection.prepareStatement(GET_ONE_QUERY);
			
			//supoose 2nd project using and todo id is 10 then why im getting project one name ?? 
			//does hard coded project id at anywhere
			
			prepareStatement.setInt(1, todoId);
			
			res  = prepareStatement.executeQuery();
			
			if(res.next()){
				
				int todo_id = res.getInt("todo_id");
				int project_id = res.getInt("project_id");
				String description = res.getString("description");
				boolean status = res.getBoolean("status");
//				--String created_date = res.getString("created_date");
//				--String updated_date = res.getString("updated_date");
				String projectTitle = res.getString("title");
				System.out.println("projectTitle: "+projectTitle);
				System.out.println("description: "+description);
				td = new ToDo(todo_id,project_id,description,status,projectTitle);
			}
			return td;
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return null;
		
	}
	public ToDo getOneTodo(int todoId) {

		ToDo td=null;
		try { 

//			private final static String GET_ONE_QUERY = "SELECT  * FROM  `todo` WHERE `todo_id` = ?"; //editied new
			prepareStatement = connection.prepareStatement(GET_Todo_QUERY);
			
			
			prepareStatement.setInt(1, todoId);
			
			res  = prepareStatement.executeQuery();
			
			if(res.next()){
				
				int todo_id = res.getInt("todo_id");
				int project_id = res.getInt("project_id");
				String description = res.getString("description");
				boolean status = res.getBoolean("status");
//				--String created_date = res.getString("created_date");
//				--String updated_date = res.getString("updated_date");
//				String projectTitle = res.getString("title");
//				System.out.println("projectTitle: "+projectTitle);
				System.out.println("description: "+description);
				System.out.println("project_id: "+project_id);
				
				td = new ToDo(todo_id,project_id,description,status);
			}
			return td;
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return null;
		
	}
	
	public ToDo getOneProject(int todoId) {

		ToDo td=null;
		try { 
			//private final static String GET_Project_QUERY = "SELECT  title FROM  `projects` WHERE `project_id` = ?"; //editied new
			prepareStatement = connection.prepareStatement(GET_Project_QUERY);
			
			
			prepareStatement.setInt(1, todoId);
			
			res  = prepareStatement.executeQuery();
			
			if(res.next()){
				
//				int project_id = res.getInt("project_id");
				String projectTitle = res.getString("title");
				System.out.println("project Title: "+projectTitle);
				
				td = new ToDo(projectTitle);
			}
			return td;
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public ToDo get_One(int todoId,int projectId) {

		ToDo td=null;
		try { 
//			private final static String GET_ONE1_QUERY = "SELECT  * FROM  `todo` INNER JOIN `projects` ON `todo.project_id`=`projects.project_id` WHERE `todo.todo_id` = ? AND `projects.project_id`=?";
			prepareStatement = connection.prepareStatement(GET_ONE1_QUERY);
			
			prepareStatement.setInt(1, todoId);
			prepareStatement.setInt(2, projectId);
			
			
			res  = prepareStatement.executeQuery();
			
			if(res.next()){
				
				int todo_id = res.getInt("todo_id");
				int project_id = res.getInt("project_id");
				String description = res.getString("description");
				boolean status = res.getBoolean("status");
				String projectTitle = res.getString("title");
				
				System.out.println("projectTitle "+projectTitle);
				System.out.println("description "+description);
				
				System.out.println("projectIdDataBase: "+projectId);
//				public ToDo(int todoId, int projectId, String description, boolean status,
//						String projectTitle) {
				
				td = new ToDo(todo_id,project_id,description,status,projectTitle);
				
			}
			return td;
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<ToDo> getAll(int projectId) {
		
ArrayList<ToDo> list = new ArrayList<ToDo>();
		
		try {
			prepareStatement = connection.prepareStatement(GET_ALL_QUERY);
			
			prepareStatement.setInt(1, projectId);
			res= prepareStatement.executeQuery();
			
			while(res.next())
			{
				int todo_id = res.getInt("todo_id");
				int project_id = res.getInt("project_id");
				String description = res.getString("description");
				boolean status = res.getBoolean("status");
				String created_date = res.getString("created_date");
				String updated_date = res.getString("updated_date");
				
				ToDo td = new ToDo(todo_id,project_id,description,status,created_date,updated_date);
				
				list.add(td);
				
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	

}
