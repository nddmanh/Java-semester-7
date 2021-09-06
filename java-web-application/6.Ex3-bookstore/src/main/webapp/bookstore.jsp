<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Book store</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: orange">
			<div>
				<a href="/User-manager-jdbc/list" class="navbar-brand">Book Store </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/cart"
					class="nav-link">Xem gio hang</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">danh sach san pham</a></li>
			</ul>
			<%
		      	String name = (String) session.getAttribute("user");
				if (name != null) {
		  	%>
		  			<span style="float: right;"> Xin chao <%=name %> </span>
		  	<% } %>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Cua hang sach</h3>
			<hr>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Publisher</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="book" items="${listBook}">
		                <tr>
		                    <td><c:out value="${book.name}" /></td>
		                    <td><c:out value="${book.quantity}" /></td>
		                    <td><c:out value="${book.price}" /></td>
		                    <td><c:out value="${book.publisher}" /></td>
		                    <td>
								<a href="#">Add to cart</a>
							</td>
		                </tr>
		            </c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>