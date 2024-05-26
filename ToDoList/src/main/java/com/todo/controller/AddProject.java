package com.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.daoImp.ProjectsBoImp;
import com.todo.model.Projects;


@WebServlet("/addProject")
public class AddProject extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("projectTitle");
		
		Projects project = new Projects(title);
		
		ProjectsBoImp proboImp = new ProjectsBoImp();
		
		int save = proboImp.save(project);
		
		PrintWriter out = response.getWriter();
		
		if(save==1)
		{
//			out.println("Project is successfully done");
			response.sendRedirect("home");
		}
		else
		{
			out.println("Project is Unsuccessfully done");
//			response.sendRedirect("addProject.jsp?save="+save);
		}
	}
	
}

