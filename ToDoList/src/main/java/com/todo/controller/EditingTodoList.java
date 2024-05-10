package com.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editingTodoList")
public class EditingTodoList extends HttpServlet {
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int todoId = Integer.parseInt(request.getParameter("todoId"));
//		int projectId = Integer.parseInt(request.getParameter("projectId"));
		//covert into integer
//		int id = (Integer)request.getAttribute("project-id");
		
		System.out.println("EditingTodoList.java todoId: "+todoId);
		
		response.sendRedirect("editingTodo.jsp?todoId="+todoId);
//		response.sendRedirect("editingTodo.jsp?todoId="+todoId+"&projectId="+projectId);
		
	}

}
