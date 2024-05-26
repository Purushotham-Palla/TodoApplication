<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ToDo List | Project Add</title>
    	<link rel="stylesheet" type="text/css" href="addTodo.css">
    	
    	<link rel="icon" type="image" href="man.png">
	</head>
	<body>
		<p>Project Add</p>
		
	    <div class="details">
	        <div class="form">
	        
	            <form action="addProject" method="get">
	            	

	                <input type="text" name="projectTitle" placeholder="Project Name" id="text-box" required><br>     
	                <input type="submit" name="submit" id="submit">
	            </form>
	        </div>
	    </div>
	</body>
</html>
