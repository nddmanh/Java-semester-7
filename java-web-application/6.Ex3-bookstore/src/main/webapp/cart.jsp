<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cart</title>
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
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Quay lai trang chu</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Gio hang cua ban</h3>
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
				

			</table>
		</div>
	</div>
</body>
</html>