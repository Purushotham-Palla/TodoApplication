package com.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.daoImp.ToDoBoImp;


@WebServlet("/deletingTodo")
public class DeletingTodo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ToDoBoImp toDoBoImp = new ToDoBoImp();
		int todoId = Integer.parseInt(request.getParameter("todoId"));
		int i = toDoBoImp.delete(todoId);
		PrintWriter out = response.getWriter();
		if(i==1)
		{
			out.println("Deleted Successfully done......");
			System.out.println("Deleted todoId :"+todoId);
//			response.sendRedirect("allTodoList.jsp");
			
			
		}
		else {
			out.println("Deleted Failed......"
					+ "Please Try again");
			
		}
		
		
	
	}


}
