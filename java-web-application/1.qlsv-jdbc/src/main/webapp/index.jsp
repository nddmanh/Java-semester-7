<%@page import="controller.StudentDAO"%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Thông tin sinh viên</h1>
	
	<table border="1" style="border-collapse: collapse;" width="80%" align="center">
	
		<tr>
			<th>STT</th>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Phone</th>
			<th>AVG</th>
			<th colspan="2"> <a href="add.jsp">Add new</a> </th>
		</tr>
		
		<%
			ArrayList<Student> list = new StudentDAO().getList();
			int i = 1;
			for (Student s: list) {
				String urle = "edit.jsp?id=" + s.getId();
				String urlr = "remove.jsp?id=" + s.getId();
		%> 
		
		<tr>
			<th><%= i++ %></th>
			<th><%= s.getId() %></th>
			<th><%= s.getName() %></th>
			<th><%= s.getAddress() %></th>
			<th><%= s.getEmail() %></th>
			<th><%= s.getPhone() %></th>
			<th><%= s.getAvg() %></th>

			<td>
				<a href="<%= urle %>">Edit</a>
			</td>
			<td>
				<a href="<%= urlr %>">Remove</a>
			</td>
		</tr>
		
		<% 
			}
		%>
		
	</table>
</body>
</html>