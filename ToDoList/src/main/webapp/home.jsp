<%@page import="com.todo.daoImp.ProjectsBoImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.todo.model.Projects,java.util.List, com.todo.daoImp.ProjectsBoImp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>ToDO List | Home</title>
	<link rel="icon" type="image" href="man.png">
	<link rel="stylesheet" href="home.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />


</head>
<body>


	<div class="todolist">
		<h1>Stay on Track: Your Personal <span style="color:#CD5825">Poject List</span> </h1>
			<div class="addtodo">
			
			<button id="create-button">
				<a href="addProject.jsp">Create Project</a>
			
			</button>	
		  </div>
		
		<div class="details">
            <table >
                <thead>
                    <tr style="background-color: #7EAECD">
                        <th>Project Id</th>
                        <th>Title Name</th>
                        <th>Created Date</th>
                        <th>View</th>
                    </tr>

                </thead>
                <tbody>
		<%
		
		ProjectsBoImp projectsBoImp = new ProjectsBoImp();
		
		
		//after deleting the employee details it works
		//note it hit database every one operation of deleting
		
		List<Projects> projectsList = projectsBoImp.getAll();
		//if(projectsList.isEmpty())
		//{
			//after login this line is excutes
		//	projectsList = (List<Projects>)request.getAttribute("projects-list");
		//}
		
		
		if(projectsList !=null)
		{
			for(Projects projects : projectsList)
			{	
		%>
         <tr>
               <td ><%= projects.getProjectId()%></td>
               <td style="color:#CD5825"><%= projects.getTitle()%></td>
               <td ><%= projects.getCreatedTime()%></td>
               <%System.out.println("projectId"+projects.getProjectId()); %>
               <td style="background-color:aquamarine ;"><a href="displayTodo?projectId=<%= projects.getProjectId() %>">><i class="fa-solid fa-angle-right"></i></a></td>
              <!--  <td style="background-color:aquamarine ;"><a href="allTodoList.jsp?projectId=<%= projects.getProjectId() %>">><i class="fa-solid fa-angle-right"></i></a></td>--> 
          </tr>
				
		<%	}
			System.out.println("-----------------"); 
		}
		%>

                </tbody>
            </table>
            

        </div>
		


	</div>
</body>
</html>