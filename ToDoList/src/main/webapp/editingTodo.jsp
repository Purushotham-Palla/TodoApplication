<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.todo.daoImp.ToDoBoImp, com.todo.model.ToDo,java.util.List  " %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ToDo List | Edit </title>
    	<link rel="stylesheet" type="text/css" href="editing.css">
    	
    	<link rel="icon" type="image" href="man.png">
	</head>
	<body>
	
	<% ToDoBoImp ob = new ToDoBoImp(); 
		 int todoId = Integer.parseInt(request.getParameter("todoId"));
		 //int projectId = Integer.parseInt(request.getParameter("projectId"));
		 //int projectId = Integer.parseInt(request.getParameter("projectId"));
		 
		 //int projectId = (Integer)request.getAttribute("project-id");
		 
		 //List<ToDo> todoList= (List<ToDo>)request.getAttribute("todo-list");
		 //ToDo t =todoList.get(1);
		 
		// int projectId= t.getProjectId();
		 //
		 //
		 //at first check where projectId is getting are not??
		 //System.out.println("EditingTodo page ProjectId: "+projectId);
	
		 ToDo tdo1 = ob.getOneTodo(todoId);
		 	
		 ToDo tdo2=ob.getOneProject(tdo1.getProjectId());
		 
		 
		 //write here two things of one for getOneTodo and getOneProject
		 
		 //int projectId= 2;
		 //ToDo tdo = ob.get_One(todoId,projectId);
		 
		 //System.out.println("TodoId"+tdo.getTodoId());
	%>
		<p>ToDo Edit</p>
		
	    <div class="details">
	        <div class="form">
	        
	            <form action="updatingTodoList" method="get">

	                <!---->
	                
	                <input  style="display:none;" type="text" name="todoId" value="<%= tdo1.getTodoId()%>">
	                <input  style="display:none;" type="text" name="projectId" value="<%= tdo1.getProjectId()%>">
	                <input type="text" name="projectTitle" placeholder="Project Title" id="text-box" required value="<%= tdo2.getProjectTitle()%>"><br>
	                <!-- add correct it td.getDescription()%> -->
					<!--   <textarea type="text" name="description" placeholder="Description" id="text-box" required value="" ></textarea><br>-->
	                <input type="text"name="description" placeholder="Description" id="text-box" required value="<%=tdo1.getDescription()%>" ><br>
	                <!-- 	
	                <input type=" name="createdDate"><br> -->
					
	                <input type="checkbox" name="status" id="checkb" >
					<label for="status" id="status">Have you completed Task</label><br>
	                <!-- <input type="text" name="address" placeholder="Address" id="text-box" required><br> -->     
	                <input type="submit" name="submit" id="submit">
	            </form>
	        </div>
	    </div>
	</body>
</html>