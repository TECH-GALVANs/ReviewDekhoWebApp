<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- login form -->
    <section class="container login-form-box-shadow">
        <section class="row">
            <section class="col-lg-12 login-form">
                <form method="POST" action="<%=request.getContextPath() %>/user">
                    <section class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" name="emailId" class="form-control-lg form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </section>
                    <section class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="password" class="form-control-lg form-control" id="exampleInputPassword1">
                        <input type="text" hidden="true" name="signin" value="true" class="form-control-lg form-control" id="exampleInputPassword1">
                    </section>
                    <!-- <section class="form-group form-check">
                        <input type="checkbox" class="form-control-sm form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </section>  -->
                    <button type="submit" class="btn btn-success btn-lg">Sign in</button>
                    <section class="register-link">
                        <a href="Sign-up.jsp">Sign up here....</a>
                        <% String message = (String) session.getAttribute( "message" );
                        		session.removeAttribute( "message" );
                        		%>
                        <% if( message != null ){ %>
                        	<p style="color:red"><%=message %></p>
                        <% } %>
                    </section>
                </form>
            </section>
        </section>
	</section>
<%@ include file="footer.jsp"%>
