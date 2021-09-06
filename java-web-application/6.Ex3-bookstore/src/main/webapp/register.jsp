<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register account</title>
	</head>
	<body>
		<div align ="center">
			<h1>Dang ky tai khoan</h1>
			<form action="register" method="post">
				<table>
					<tr><td>Name: </td><td><input type="text" name="name"></td></tr>
					<tr><td>User Name: </td><td><input type="text" name="username"></td></tr>
					<tr><td>Password: </td><td><input type="password" name="password"></td></tr>
					<tr><td>City: </td><td><input type="text" name="city"></td></tr>
					
					<tr><td></td><td><input type="submit" value="register"></td></tr>
					
				</table>
			</form>
	
			<span>Ban da co tai khoan? <a href="<%=request.getContextPath()%>/login"> Dang nhap ngay</a> </span>
		</div>
		
	</body>
</html>