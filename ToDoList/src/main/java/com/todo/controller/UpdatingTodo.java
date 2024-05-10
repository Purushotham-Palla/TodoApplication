package com.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.daoImp.ToDoBoImp;
import com.todo.model.ToDo;

@WebServlet("/updatingTodoList")
public class UpdatingTodo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int todoId = Integer.parseInt(request.getParameter("todoId"));
		String projectTitle = request.getParameter("projectTitle");
		String description = request.getParameter("description");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		boolean status =false;
		String stat=request.getParameter("status");
		if(stat.equals("on"))
		{			
			status=true;
		}
		
		
		
		ToDo toDo = new ToDo(todoId,projectId,description,status,projectTitle);
		
		ToDoBoImp todoBoImp = new ToDoBoImp();
		
		 int effectedRows = todoBoImp.update(toDo);
		
		
		 PrintWriter out = response.getWriter();
		 System.out.println("project Id ;"+todoId);
		 System.out.println("status : ;"+status);
		 
//		if(effectedRows==1)
			if(effectedRows==2)
		{
			out.println("Records Updated.....");
//			response.sendRedirect("allTodoList.jsp?projectId="+todoId);
//			response.sendRedirect("allTodoList.jsp");
		} 	
		else {
			
			out.println("Records Not Updated.....");
		}
		
		
		
	}

}
