<%@page import="model.Student"%>
<%@page import="controller.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 >Sua sinh vien</h1>
	<% 
		String id = request.getParameter("id");
		Student s = new StudentDAO().getStudentById(id);
	%>
	
	<form method="POST" action="doEdit.jsp">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" value="<%= s.getId() %>" readonly="readonly" /> </td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%= s.getName() %>" /> </td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value="<%= s.getAddress() %>" /> </td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%= s.getEmail() %>" /> </td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="<%= s.getPhone() %>" /> </td>
			</tr>
			<tr>
				<td>Avg:</td>
				<td><input type="text" name="avg" value="<%= s.getAvg() %>" /> </td>
			</tr>
		</table>
		
		<input type="submit" value="Submit" />
		<input type="reset" value="Reset" />
	</form>
</body>
</html>