<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page autoFlush="true" buffer="1094kb"%> 
 <%@ page import="com.reviewdekho.category.model.Category" %>
<%@ include file = "../header.jsp" %>
	<% Category category = (Category) session.getAttribute( "category" ); %>
	<div class="container">
		<div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="form-example-wrap mg-t-30">
                        <div class="cmp-tb-hd cmp-int-hd">
                            <h2>Edit Category</h2>
                        </div>
                        <form class="form-example-wrap" action="<%=request.getContextPath() %>/category" method="POST">
                        <div class="form-example-int form-horizental">
                            <div class="form-group">
                                <div class="row">                                	
                                    <div class="col-lg-2 col-md-3 col-sm-3 col-xs-12">
                                        <label class="hrzn-fm">Category Name </label>
                                    </div>
                                    <div class="col-lg-8 col-md-7 col-sm-7 col-xs-12">
                                        <div class="nk-int-st">
                                        	<input type="hidden" class="form-control input-sm" name="categoryId" value="<%=category.getCategory_id() %>" placeholder="Enter Category Name...">
                                            <input type="text" class="form-control input-sm" name="categoryName" value="<%=category.getCategory_name() %>" placeholder="Enter Category Name...">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-example-int mg-t-15">
                            <div class="row">
                                <div class="col-lg-2 col-md-3 col-sm-3 col-xs-12">
                                </div>
                                <div class="col-lg-8 col-md-7 col-sm-7 col-xs-12">
                                    <button class="btn btn-success btn-lg notika-btn-success waves-effect">Submit</button>
                                </div>
                            </div>
                        </div>
                    	</form>
                    </div>
                </div>
        </div>
    </div>
<%@ include file = "../footer.jsp" %>