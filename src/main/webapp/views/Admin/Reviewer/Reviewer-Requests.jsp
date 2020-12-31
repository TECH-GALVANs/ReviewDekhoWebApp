<%@page import="com.reviewdekho.reviewer.model.Reviewer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ page autoFlush="true" buffer="1094kb"%> 
 	<%@ page import="com.reviewdekho.review.model.*" %>
    <%@ page import="java.util.List" %>  
    
    <% 
    	List< Reviewer > reviewers = ( List< Reviewer > ) session.getAttribute( "reviewers" );
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
                            <strong style="font-size: 25px">Reviews  </strong>
                            <a href="add-category.jsp"><span class="glyphicon glyphicon-plus"></span></a>
                            <!-- <p>It's just that simple. Turn your simple table into a sophisticated data table and offer your users a nice experience and great features without any effort.</p> -->
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>User name</th>
                                        <th>Description</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                        <th>Action</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% int count = 0; for( Reviewer reviewer : reviewers ){ %>
                                	<tr>
                                		<td><%=++count %></td>
                                		<td><%=reviewer.getUser().getUser_name() %></td>
                                		<td><%=reviewer.getReviewer_description() %></td>
                                		<% if( reviewer.getReviewer_status() == 0 ){ %>
                                        	<td>Revoked</td>
                                        <% } else if( reviewer.getReviewer_status() == 1 ){ %>
                                        	<td>Rejected</td>
                                        <% } else if( reviewer.getReviewer_status() == 2 ){ %>
                                        	<td>Pending</td>
                                        <% } else if( reviewer.getReviewer_status() == 3 ){ %>
                                        	<td>Accepted</td>
                                        <% } %>
                                		<td><a href="<%=request.getContextPath() %>/reviewer?reviewerId=<%=reviewer.getReviewer_id() %>&status=0">Revoke</a></td>
                                		<td><a href="<%=request.getContextPath() %>/reviewer?reviewerId=<%=reviewer.getReviewer_id() %>&status=1">Reject</a></td>
                                		<td><a href="<%=request.getContextPath() %>/reviewer?reviewerId=<%=reviewer.getReviewer_id() %>&status=3">Accept</a></td>
                                	</tr>
                                <% } %>                                	
    							</tbody>
                                <tfoot>
                                    <tr>
                                        <th>No.</th>
                                        <th>User name</th>
                                        <th>Description</th>
                                        <th>Status</th>
                                        <th>Action</th>
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