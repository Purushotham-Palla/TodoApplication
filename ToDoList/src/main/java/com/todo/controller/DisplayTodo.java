package com.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.daoImp.ToDoBoImp;
import com.todo.model.ToDo;


@WebServlet("/displayTodo")
public class DisplayTodo extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int projectId = Integer.parseInt(request.getParameter("projectId"));
		System.out.println("DisplayTodo.java projectId: "+projectId);
		
		ToDoBoImp toDoBoImp = new ToDoBoImp();
		List<ToDo> all_details = toDoBoImp.getAll(projectId);
		for(ToDo td:all_details)
		{
			System.out.println("Added sucessfully to List ProjectId : "+td.getProjectId());
		}
		System.out.println("-----------------------");
		request.setAttribute("todo-list", all_details);
		
		RequestDispatcher rd = request.getRequestDispatcher("allTodoList.jsp");
		rd.include(request, response);
		

	
	}


}
