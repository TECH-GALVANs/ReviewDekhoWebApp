<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<section class="container login-form-box-shadow">
	<section class="row">
		<section class="col-lg-12 login-form">
			<form method="POST" action="<%=request.getContextPath() %>/user" enctype="multipart/form-data">
				<section class="form-group">
					<label for="exampleInputEmail1">User name </label> <input
						type="text" name="userName" class="form-control-lg form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp">
						<input type="text" name="signup" value="true" hidden="true" > 
				</section>
				<section class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="email" name="emailId" class="form-control-lg form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp">
				</section>
				<section class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" name="password" class="form-control-lg form-control"
						id="exampleInputPassword1">
				</section>
				<section class="form-group">
					<label for="exampleFormControlFile1">Add Profile Picture</label> <input
						type="file" name="profilePicture" class="form-control-file" id="exampleFormControlFile1">
				</section>
				<button type="submit" class="btn btn-success btn-lg">Sign
					up</button>
			</form>
		</section>
	</section>
</section>
<%@ include file="footer.jsp"%>