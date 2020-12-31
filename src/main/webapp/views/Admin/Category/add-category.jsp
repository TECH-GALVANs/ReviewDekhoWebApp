<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page autoFlush="true" buffer="1094kb"%> 
<%@ include file = "../header.jsp" %>
	<div class="container">
		<div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="form-example-wrap mg-t-30">
                        <div class="cmp-tb-hd cmp-int-hd">
                            <h2>Add Category</h2>
                        </div>
                        <form action="<%=request.getContextPath() %>/category" method="POST">
                        <div class="form-example-int form-horizental">
                            <div class="form-group">
                                <div class="row">                                	
                                    <div class="col-lg-2 col-md-3 col-sm-3 col-xs-12">
                                        <label class="hrzn-fm">Category Name </label>
                                    </div>
                                    <div class="col-lg-8 col-md-7 col-sm-7 col-xs-12">
                                        <div class="nk-int-st">
                                            <input type="text" class="form-control input-sm" name="categoryName" placeholder="Enter Category Name...">
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
                                    <!-- <input type="submit" class="btn btn-success notika-btn-success waves-effect" value = "submit" > -->
                                </div>
                            </div>
                        </div>
                    	</form>
                    </div>
                </div>
        </div>
    </div>
<%@ include file = "../footer.jsp" %>