package com.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.daoImp.LoginBoImp;
import com.todo.model.Login;

@WebServlet("/registering")
public class Registering extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
	
		Login log = new Login(username,password);
		 
		
		LoginBoImp loginBoImp = new LoginBoImp();
		int i = loginBoImp.save(log);
		PrintWriter out = response.getWriter();
		if(i==1)
		{
			out.println("Register Successfull");
//			response.sendRedirect("registersucess.jsp");
			
		}
		else {
			out.println("Not Registered... Please Try again");
//			response.sendRedirect("registerunsucess.jsp");
		}
		
		
	}
}
