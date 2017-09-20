<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width.initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet" href="lib/bootstrap-3.3.6-dist/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="lib/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>  -->

<title>My Portal</title>

</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="Index">MY PAGE</a>
		</div>
		<ul class="nav navbar-nav">

			<li class="active"><a href="mainpage">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Brands<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">DELL</a></li>
					<li><a href="#">APPLE</a></li>
					<li><a href="#">LENOVO</a></li>


				</ul></li>

			
			<li><a href="#"></a></li>
			<li><a href="Contactus">Contact Us</a></li>

		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${empty loggedInUser }">
					<li><a href="Register"><span
							class="glyphicon glyphicon-user"></span>Signup</a></li>
					<li><a href="Login"><span
							class="glyphicon glyphicon-log-in"></span>Login</a></li>
				</c:when>
				<c:when test="${not empty loggedInUser }">
					<li><a href="AddtoCart">Cart</a></li>
					<li><a href="#">View Profile</a></li>
					<li><a href="#">Sign out</a></li>

					<form class="navbar-form navbar-right">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search">
							<div class="input-group-btn">
								<button class="btn btn-info" type="submit">
									<i class="glyphicon glyphicon-search"> </i>
								</button>
							</div>
						</div>
					</form>


				</c:when>
			</c:choose>
		</ul>
	</div>
	<div></div>
	</nav>