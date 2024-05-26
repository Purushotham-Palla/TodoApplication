package com.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.daoImp.ToDoBoImp;
import com.todo.model.ToDo;

@WebServlet("/editingTodoList")
public class EditingTodoList extends HttpServlet {
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int todoId = Integer.parseInt(request.getParameter("todoId"));
		
		ToDoBoImp ob = new ToDoBoImp(); 
		
		ToDo tdo1 = ob.getOneTodo(todoId);
		
		ToDo tdo2=ob.getOneProject(tdo1.getProjectId());
		
		request.setAttribute("tdo1", tdo1);

		request.setAttribute("tdo2", tdo2);
		
		RequestDispatcher rd = request.getRequestDispatcher("editingTodo.jsp");

		rd.forward(request, response);
	}

}
