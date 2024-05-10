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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	

</head>
<body>

	<div class="todolist">
		<h1>Stay on Track: Your Personal <span style="color:#CD5825">Todo List</span> </h1>
			<div class="addtodo">
			
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
		
		ToDoBoImp toImp = new ToDoBoImp();
		int projectId=Integer.parseInt(request.getParameter("projectId"));
		
		List<ToDo> toDoList = toImp.getAll(projectId);
		
    					/**System.out.println("allTodo projectId"+toDoList.geprojectId);**/
                        //int projectId=td.getProjectId();
        //request.setAttribute("project-Id",projectId);
        
        
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
                        
                        <!-- http://localhost:9092/ToDoList/addToDo?project_id=2&description=TaskEmpty%0D%0A&submit=Submit -->
                        <!-- <td style="background-color:aquamarine ; width: 60px;"><a href="editingTodoList?todoId=< td.getTodoId()%>&projectId=//< td.getProjectId() %>"><i class="fa-regular fa-pen-to-square"></i>EDit</i></a></td>-->
                        <td style="background-color:aquamarine ; width: 60px;"><a href="editingTodoList?todoId=<%= td.getTodoId()%>"><i class="fa-regular fa-pen-to-square"></i>EDit</i></a></td>
                        <td style="background-color:aquamarine ; width: 60px;"><a href="deletingTodo?todoId=<%= td.getTodoId() %>"><i class="fa-solid fa-xmark"></i>Delete</a></td>
                    </tr>
                    
                    <%System.out.println("all Todo Page TodoId :"+td.getTodoId());
                    System.out.println("all Todo Page projectId :"+td.getProjectId());
                    %>
                    
                    <%	}
			System.out.println("-------------------------");
		}
		%>
        

                    </tbody>
            </table>
    
        </div>

	</div>
</body>
</html>