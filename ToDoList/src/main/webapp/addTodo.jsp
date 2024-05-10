<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="ISO-8859-1">
		<title>Todo List | Todo Add</title>
    	<link rel="stylesheet" type="text/css" href="addTodo.css">
    	
    	<link rel="icon" type="image" href="man.png">
	</head>
	<body>
		<p>ToDo Add</p>
		
	    <div class="details">
	        <div class="form">
	        
	            <form action="addToDo" method="get">

	                <input type="text" name="project_id" placeholder="Project Id" id="text-box" required><br>
					<textarea name="description" placeholder="Description" id="text-box" required ></textarea><br>
	                <!-- <input type="" name="lastname" > -->
					
	                <!-- <input type="checkbox" name="status" id="text-box" required><br> -->
	                <!-- <input type="text" name="address" placeholder="Address" id="text-box" required><br> -->     
	                <input type="submit" name="submit" id="submit">
	            </form>
	        </div>
	    </div>
	</body>
</html>