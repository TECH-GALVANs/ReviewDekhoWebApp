<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ page autoFlush="true" buffer="1094kb"%> 
 	<%@ page import="com.reviewdekho.user.model.*" %>
    <%@ page import="java.util.List" %>  
    
    <% 
    List<User> users = ( List<User> ) session.getAttribute( "users" );
    %>

<%@ include file = "../header.jsp" %>
	<!-- <div class="container">
		<a class=""><span class="glyphicon glyphicon-plus"></span></a>
	</div> -->
	<div class="data-table-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <strong style="font-size: 25px">Categories  </strong>
                            <a href="add-category.jsp"><span class="glyphicon glyphicon-plus"></span></a>
                            <!-- <p>It's just that simple. Turn your simple table into a sophisticated data table and offer your users a nice experience and great features without any effort.</p> -->
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>User Name</th>
                                        <th>Email Id</th>
                                        <th>User Role</th>
                                        <th>Action</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% int count = 0; for( User user : users ){ %>
                                	<tr>
                                		<td><%=++count %></td>
                                		<td><%=user.getUser_name() %></td>
                                		<td><%=user.getEmail_id() %></td>
                                		<% if( user.getUser_role() == 0){ %>
                                			<td>User</td>
                                		<% } else if( user.getUser_role() == 1){ %>
                                			<td>Reviewer</td>
                                		<% } else if( user.getUser_role() == 2){ %>
                                			<td>Admin</td>
                                		<% } %>
                                		<td><a href="<%=request.getContextPath() %>/user?update=<%=user.getUser_id() %>">Edit</a></td>
                                		<td><a href="<%=request.getContextPath() %>/user?delete=<%=user.getUser_id() %>">Delete</a></td>
                                	</tr>
                                <% } %>                                	
    							</tbody>
                                <tfoot>
                                    <tr>
                                        <th>No.</th>
                                        <th>User Name</th>
                                        <th>Email Id</th>
                                        <th>User Role</th>
                                        <th>Action</th>
                                        <th>Action</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@ include file = "../footer.jsp" %>