<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.todo.controller.LoginChecking" %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login | Todo List</title>
		<link rel="icon" type="image/png" href="boy.png">
    	<link rel="stylesheet" href="login.css ">
	</head>
	<body>
		<div class="login-details">
            <div class="details">
                <p id="login">Login</p>
                <br>
                <form action="loginChecking" method ="post">                
                   
                    <input type="text" name=username id="text-box" required placeholder="User Name" ><br><br>
                    <input type="password" name="password" id="text-box" required placeholder="Password"><br><br>
                    <input type="submit" id="submit" >
                  </form>
                 
                
            </div>
            
        </div>
	</div>
	</body>
</html>