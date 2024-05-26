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


@WebServlet("/loginChecking")
public class LoginChecking extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginBoImp loginBoImp = new LoginBoImp();
		Login login = loginBoImp.getLogin(username, password);
		
		if(login != null)
		{
			response.sendRedirect("home");
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("Login Fail.......Please Try again");
		}
		
		
		
		
	
	}


}
