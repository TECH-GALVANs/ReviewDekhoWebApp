<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ page autoFlush="true" buffer="1094kb"%> 
 	<%@ page import="com.reviewdekho.review.model.*" %>
    <%@ page import="java.util.List" %>  
    
    <% 
    	List< Review > reviews = ( List< Review > ) session.getAttribute( "reviews" );
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
                                        <th>Review</th>
                                        <th>Product Name</th>
                                        <th>User Name</th>
                                        <th>Action</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% int count = 0; for( Review review : reviews ){ %>
                                	<tr>
                                		<td><%=++count %></td>
                                		<td><%=review.getReview_desc() %></td>
                                		<td><%=review.getProduct().getProduct_name() %></td>
                                		<td><%=review.getUser().getUser_name() %></td>
                                		<td><a href="<%=request.getContextPath() %>/user?update=<%=review.getReview_id() %>">Edit</a></td>
                                		<td><a href="<%=request.getContextPath() %>/user?delete=<%=review.getReview_id() %>">Delete</a></td>
                                	</tr>
                                <% } %>                                	
    							</tbody>
                                <tfoot>
                                    <tr>
                                        <th>No.</th>
                                        <th>Review</th>
                                        <th>Product Name</th>
                                        <th>User Name</th>
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