<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.todo.model.ToDo,com.todo.daoImp.ToDoBoImp,java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ToDo List | List of ToDo</title>
		<link rel="icon" type="image" href="man.png">
		<link rel="stylesheet" href="allToDoList.css">
	</head>
	<body>
	
		<div class="todolist">
			
			<h1>Stay on Track: Your Personal <span style="color:#CD5825">Todo List</span> </h1>
			
				<div class="addtodo">
				
				  <button id="create-button">
					
					<a href="home">Home</a>
					
				</button>
				
				<button id="create-button">
			
					<a href="addTodo.jsp">Add ToDo</a>
				
				</button>	
			  </div>
			
			<div class="details">
	        
	            <table style="border: 1px solid  #3a4553;"  >
	        
	                <thead>
	        
	                    <tr style="background-color: #7EAECD">
	                        <th>ToDo Id</th>
	                        <th>Project Id</th>
	                        <th>Description</th>
	                        <th>Status</th>
	                        <th>Created Date</th>
	                        <th>Updated Date</th>
	                        <th>Edit</th>
	                        <th>Delete</th>
	
	                    </tr>
	
	                </thead>
	                <tbody>
			
			<%
			
			
	        List<ToDo> toDoList =(List<ToDo>) request.getAttribute("todo-list");
	        
			if(toDoList !=null)
			{
				for(ToDo td : toDoList)
				{	
			%>
			
	                    <tr> 
	                        <td><%= td.getTodoId()%></td>
	
	                        <td style="color:#CD5825"><%= td.getProjectId()%></td>
	
	                        <td><%= td.getDescription()%></td>
	
	                        <td style="color:#CD5825"><%= td.isStatus()%></td>
	
	                        <td ><%= td.getCreatedDate()%></td>
	
	                        <td style="color:#CD5825"><%= td.getUpdatedDate()%></td>
	                        
	                        <td style="background-color:aquamarine ; width: 60px;"><a href="editingTodoList?todoId=<%= td.getTodoId()%>"><i class="fa-regular fa-pen-to-square"></i>Edit</i></a></td>
	
	                        <td style="background-color:aquamarine ; width: 60px;"><a href="deletingTodo?todoId=<%= td.getTodoId()%>&projectId=<%=td.getProjectId() %>"><i class="fa-solid fa-xmark"></i>Delete</a></td>
	                        <!-- note: while we dealing with url don't even given small space it treats differently; -->
	                    
	                    </tr>
	                    
	                    <%	}
			}
			%>
	                    </tbody>
	            </table>
	    
	        </div>
	
		</div>
	</body>
</html>
