<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page autoFlush="true" buffer="1094kb"%>
<%@ page import="com.reviewdekho.subcategory.model.*"%>
<%@ page import="com.reviewdekho.category.model.*"%>
<%@ page import="java.util.List"%>
<%@ include file="../header.jsp"%>
<%
	SubCategory subCategory = (SubCategory) session.getAttribute("sub-category");
List<Category> categories = (List<Category>) session.getAttribute("categories");
%>
<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="form-example-wrap">
				<form action="<%=request.getContextPath()%>/sub-category"
					method="POST">
					<div class="cmp-tb-hd">
						<h2>Add Sub-category</h2>
					</div>
					<div class="form-example-int">
						<div class="form-group">
							<label>Sub-category name : </label> <br>
							<div class="nk-int-st">
								<input type="text" hidden="true" name="subCategoryId" value="<%=subCategory.getSub_category_id() %>"
									placeholder="Enter Sub-category name....">
								<input type="text" name="subCategoryName" value="<%=subCategory.getSub_category_name() %>"
									class="form-control input-sm"
									placeholder="Enter Sub-category name....">
							</div>
						</div>
					</div>
					<br>
					<div class="form-example-int form-horizental mg-t-15">
						<div class="col-lg-12 col-md-3 col-sm-3 col-xs-12">
							<div class="nk-int-mk sl-dp-mn">
								<h2>Category</h2>
							</div>
							<div class="bootstrap-select fm-cmp-mg">
								<select name="category" class="selectpicker">
									<%
										for (Category cat : categories) {
									%>
									<option value="<%=cat.getCategory_id()%>"><%=cat.getCategory_name()%></option>
									<%
										}
									%>
								</select>
							</div>
						</div>
					</div>
					<br>
					<br>
					<div class="row">
						<div class="col-lg-12 col-md-3 col-sm-3 col-xs-12">
							<div class="form-example-int mg-t-15">
								<center>
									<button class="btn btn-lg btn-success notika-btn-success">Submit</button>
								</center>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp"%>