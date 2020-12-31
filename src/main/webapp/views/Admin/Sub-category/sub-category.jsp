<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ page autoFlush="true" buffer="1094kb"%> 
 	<%@ page import="com.reviewdekho.subcategory.model.*" %>
    <%@ page import="java.util.List" %>  
    
    <% List<SubCategory> subCategory = (List<SubCategory>)session.getAttribute("subCategories");
    %>

<%@ include file = "../header.jsp" %>
	<div class="data-table-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <strong style="font-size: 25px">Sub-Categories  </strong>
                            <a href="<%=request.getContextPath() %>/sub-category?add"><span class="glyphicon glyphicon-plus"></span></a>
                            <!-- <p>It's just that simple. Turn your simple table into a sophisticated data table and offer your users a nice experience and great features without any effort.</p> -->
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Sub-Category</th>
                                        <th>Category</th>
                                        <th>Action</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% int count = 0; for( SubCategory subCat : subCategory ){ %>
                                	<tr>
                                		<td><%=++count %></td>
                                		<td><%=subCat.getSub_category_name() %></td>
                                		<td><%=subCat.getCategory().getCategory_name()%></td>
                                		<td><a href="<%=request.getContextPath() %>/sub-category?update=<%=subCat.getSub_category_id() %>">Edit</a></td>
                                		<td><a href="<%=request.getContextPath() %>/sub-category?delete=<%=subCat.getSub_category_id() %>">Delete</a></td>
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
                                        <th>Sub-Category</th>
                                        <th>Category Name</th>
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