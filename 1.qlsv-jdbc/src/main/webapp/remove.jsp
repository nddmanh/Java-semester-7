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
	<%
		String id = request.getParameter("id");
		if (new StudentDAO().remove(id)) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	%>
</body>
</html>