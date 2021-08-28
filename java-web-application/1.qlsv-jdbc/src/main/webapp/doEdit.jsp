<%@page import="controller.StudentDAO"%>
<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%	request.setCharacterEncoding("UTF-8");
		Student s = new Student();
		s.setId(request.getParameter("id"));
		s.setName(request.getParameter("name"));
		s.setAddress(request.getParameter("address"));
		s.setEmail(request.getParameter("email"));
		s.setPhone(request.getParameter("phone"));
		s.setAvg(Float.parseFloat(request.getParameter("avg")) );
		
		if (new StudentDAO().edit(s)) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	%>
</body>
</html>