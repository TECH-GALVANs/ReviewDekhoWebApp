<%@page import="com.reviewdekho.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute( "user" );
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- bootstrap-css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <!-- our own stylesheet -->
    <link rel="stylesheet" href="css/main.css">
    <!-- bootstrap-javascript  -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Ubuntu+Mono&display=swap" rel="stylesheet">
		<script src="https://use.fontawesome.com/d5e76274d0.js"></script>
    <!-- icons -->
    <script src="https://kit.fontawesome.com/d141d9a25f.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Merriweather:400,900,900i" rel="stylesheet">

	<!-- Title -->
    <title>ReviewDekho</title>
</head>
<body>
	<header>
		<nav class="navbar sticky-top navbar-expand-lg navbar-dark">
			<a class="navbar-brand" href="#"><i class="far fa-eye"></i> ReviewDekho.com<sup>&trade;</sup></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="navbar-toggler-icon"></span>
			</button>
		  
			<section class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active">
						  <a class="nav-link" href="index.html">Home</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link active" href="Category.jsp">Category</a>
					</li>
					<% if( user.getUser_role() == 2 ){ %>
					<li class="nav-item">
						<a class="nav-link active" href="../Admin/index.jsp">Admin-side</a>
					</li>
					<% } %>
					<!-- <li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="category.html" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Category
						</a>
						<section class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="category.html">Electronics</a>
							<a class="dropdown-item" href="category.html">Food</a>
						</section>
					</li> -->
					<!-- <form style="margin-left: 20px;" class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
					  </form> -->
					<!-- <li class="nav-item active">
						<a class="nav-link" href="#">Login</a>
					</li> -->
				</ul>
			</section>
			<section>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active dropdown">
						<% if( user != null ){ %>
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<%=user.getUser_name() %>
						</a>
							<section class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="edit-profile.html">Edit Profile</a>
								<a class="dropdown-item" href="view-profile.html">View Profile</a>
								<a class="dropdown-item" href="requestForBeingReviewer.html">Request for Being Reviewer</a>
								<a class="dropdown-item" href="<%=request.getContextPath() %>/user?signout=<%=user.getUser_id() %>">Sign out</a>
							</section>
						<% } else { %>
						<li class="nav-item active">
							<a class="nav-link" href="Sign-in.jsp">Signin</a>
						</li>
						<% } %>
					</li>
				</ul>			
			</section>
		</nav>
		</header>