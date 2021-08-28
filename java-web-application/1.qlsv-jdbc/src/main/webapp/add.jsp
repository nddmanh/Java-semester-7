<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add student</title>
</head>
<body>
	<h1 >Them sinh vien</h1>
	
	<form method="POST" action="doAdd.jsp">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" placeholder="id sv" /> </td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" placeholder="ten sv" /> </td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" placeholder="dia chi sv" /> </td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" placeholder="email sv" /> </td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" placeholder="sdt sv" /> </td>
			</tr>
			<tr>
				<td>Avg:</td>
				<td><input type="text" name="avg"  placeholder="diem sv" /> </td>
			</tr>
		</table>
		
		<input type="submit" value="Submit" />
		<input type="reset" value="Reset" />
	</form>
</body>
</html>