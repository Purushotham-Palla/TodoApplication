package com.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.daoImp.ProjectsBoImp;
import com.todo.model.Projects;


@WebServlet("/displayProjects")
public class DisplayProjects extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProjectsBoImp projectsBoImp = new ProjectsBoImp();

		List<Projects> all_details = projectsBoImp.getAll();
		
		request.setAttribute("projects-list", all_details);
		
//		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
//		rd.include(request, response);
		
	
		response.sendRedirect("home.jsp");
	}

	

}
