<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page autoFlush="true" buffer="1094kb"%>
<%@ page import="com.reviewdekho.subcategory.model.*"%>
<%@ page import="com.reviewdekho.product.model.*"%>
<%@ page import="java.util.List"%>
<%@ include file="../header.jsp"%>
<%
	List<SubCategory> subCategories = (List<SubCategory>) session.getAttribute("subCategories");
%>
<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="form-example-wrap">
				<form action="<%=request.getContextPath()%>/product"
					method="POST" enctype="multipart/form-data">
					<div class="cmp-tb-hd">
						<h2>Add Product</h2>
					</div>
					<div class="form-example-int">
						<div class="form-group">
							<label>Product name : </label> <br>
							<div class="nk-int-st">
								<input type="text" name="productName"
									class="form-control input-sm"
									placeholder="Enter Product name....">
							</div>
						</div>
					</div>
					<br>
					<div class="form-example-int">
						<div class="form-group">
							<label>Product description : </label> <br>
							<div class="nk-int-st">
								<input type="text" name="productDescription"
									class="form-control input-sm"
									placeholder="Enter Product description....">
							</div>
						</div>
					</div>
					<br>
					<div class="form-example-int form-horizental mg-t-15">
						<div class="col-lg-12 col-md-3 col-sm-3 col-xs-12">
							<div class="nk-int-mk sl-dp-mn">
								<h2>Sub-category</h2>
							</div>
							<div class="bootstrap-select fm-cmp-mg">
								<select name="subCategory" class="selectpicker">
									<%
										for ( SubCategory subCat : subCategories ) {
									%>
									<option value="<%=subCat.getSub_category_id() %>"><%=subCat.getSub_category_name()%></option>
									<%
										}
									%>
								</select>
							</div>
						</div>
					</div>
					<br>
					<br>
					<div class="form-example-int">
						<div class="form-group">
							<label>Product price : </label> <br>
							<div class="nk-int-st">
								<input type="text" name="productPrice"
									class="form-control input-sm"
									placeholder="Enter Product price....">
							</div>
						</div>
					</div>
					<br>
					<div class="form-example-int">
						<div class="form-group">
							<label>Add Product Image : </label> <br>
							<div class="nk-int-st">
								<input type="file" name="productImage"
									class="form-control input-sm">
							</div>
						</div>
					</div>
					<br><br>
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