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

@WebServlet("/addToDo")
public class AddToDo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int projectId = Integer.parseInt(request.getParameter("project_id"));
		String description = request.getParameter("description");
		
		
		ToDo toDo = new ToDo(projectId ,description);
		
		ToDoBoImp toDoBoImp = new ToDoBoImp();
		int i = toDoBoImp.save(toDo);
		
		PrintWriter out = response.getWriter();
		
		if(i==1)
		{
			out.println("Sucessfully Adding Todo is Done....");
//			response.sendRedirect("");
		}
		else {
			out.println("UnSucessfully Adding Todo is Done....");
			
		}
		
		
		
		
		
	}


}
