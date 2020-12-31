<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ page autoFlush="true" buffer="1094kb"%> 
 	<%@ page import="com.reviewdekho.comment.model.Comment" %>
    <%@ page import="java.util.List" %>  
    
    <% 
    List< Comment > comments = (List< Comment >)session.getAttribute("comments");
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
                            <strong style="font-size: 25px">Comments  </strong>
                            <a href="<%=request.getContextPath() %>/product?add"><span class="glyphicon glyphicon-plus"></span></a>
                            <!-- <p>It's just that simple. Turn your simple table into a sophisticated data table and offer your users a nice experience and great features without any effort.</p> -->
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Comment Description</th>
                                        <th>Review-Id</th>
                                        <th>Username</th>
                                        <th>Action</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% int count = 0; for( Comment comment : comments ){ %>
                                	<tr>
                                		<td><%=++count %></td>
                                		<td><%=comment.getComment_desc() %></td>
                                		<td><%=comment.getReview().getReview_id() %></td>
                                		<td><%=comment.getUser().getUser_name() %></td>
                                		<td><a href="<%=request.getContextPath() %>/like?update=">Edit</a></td>
                                		<td><a href="<%=request.getContextPath() %>/like?delete= %>">Delete</a></td>
                                	</tr>
                                <% } %>
                                	<%-- <c:forEach items="${category}" var="cat" begin="0" end="<%=category.size() %>" varStatus="catNo">
                                	<tr>
                                		<td>${catNo.count}</td>
                                		<td>${cat.getCategoryName()}</td>
                                		<td><a href="">Edit</a></td>
                                		<td><a href="">Delete</a></td>
                                	</tr>
                                	</c:forEach> --%>
    							</tbody>
                                <tfoot>
                                    <tr>
                                        <th>No.</th>
                                        <th>Comment Description</th>
                                        <th>Review-Id</th>
                                        <th>Username</th>
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