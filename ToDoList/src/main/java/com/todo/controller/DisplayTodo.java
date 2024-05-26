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

		ToDoBoImp toDoBoImp = new ToDoBoImp();
		
		List<ToDo> allDetails = toDoBoImp.getAll(projectId);
		
		request.setAttribute("todo-list", allDetails);
		
		RequestDispatcher rd = request.getRequestDispatcher("allTodoList.jsp");
		
		rd.forward(request, response);
	
	}


}
