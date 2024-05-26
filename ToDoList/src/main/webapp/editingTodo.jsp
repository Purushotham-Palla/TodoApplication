<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.todo.model.ToDo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ToDo List | Edit </title>
    	<link rel="stylesheet" type="text/css" href="editing.css">
    	<link rel="icon" type="image" href="man.png">
	</head>
	<body>
	
	<%
		//Attributes are placed on EditingTodoList.java
		
		 ToDo tdo1  =(ToDo)request.getAttribute("tdo1");
		 
		 ToDo tdo2 =(ToDo)request.getAttribute("tdo2");
		 
	%>
		<p>ToDo Edit</p>
		
	    <div class="details">
	        <div class="form">
	        
	            <form action="updatingTodoList" method="get">

	                <input  style="display:none;" type="text" name="todoId" value="<%= tdo1.getTodoId()%>">

	                <input  style="display:none;" type="text" name="projectId" value="<%= tdo1.getProjectId()%>">

	                <input type="text" name="projectTitle" placeholder="Project Title" id="text-box" required value="<%= tdo2.getProjectTitle()%>"><br>

	                <input type="text"name="description" placeholder="Description" id="text-box" required value="<%=tdo1.getDescription()%>" ><br>
					
	                <input type="checkbox" name="status" id="checkb" >

					<label for="status" id="status">Have you completed Task</label><br>

	                <input type="submit" name="submit" id="submit">
	            </form>
	        </div>
	    </div>
	</body>
</html>
