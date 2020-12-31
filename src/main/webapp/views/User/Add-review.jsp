<%@page import="com.reviewdekho.product.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.reviewdekho.product.service.ProductService"%>
<%@ include file="header.jsp"%>
<%
	ProductService productService = new ProductService();
	List< Product > products = productService.get();
%>
<h1 align="center">Add A Review</h1>
<section class="container login-form-box-shadow">
	<section class="row">
		<section class="col-lg-12 login-form">
			<form method="POST" action="<%=request.getContextPath() %>/review">
				<!-- <section class="form-group">
					<label for="exampleInputUserName1">User Name</label> <input
						type="email" class="form-control-lg form-control"
						id="exampleInputUserName1" aria-describedby="emailHelp" required>
				</section>
				<section class="form-group">
					<label for="exampleInputEmail1">Email</label> <input type="email"
						class="form-control-lg form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" required>
				</section> -->
				<input type="text" hidden="true" name="user" value="<%=user.getUser_id() %>" > 
				<section class="form-group" name="product">
					<label for="exampleFormControlProductSelect1">Product</label> <select
						 name="product" class="form-control" id="exampleFormControlProductSelect1">
						<% for( Product product : products ){ %>
							<option value="<%=product.getProduct_id() %>" ><%=product.getProduct_name() %></option>
						<% } %>
					</select>
				</section>
				<section class="form-group">
					<label for="exampleFormReviewDescription1">Review
						Description</label>
					<textarea class="form-control" name="reviewDesc" id="exampleFormReviewDescription1"
						rows="3" required></textarea>
				</section>
				<button type="submit" class="btn-success" value="Submit">Yes</button>
				<button type="reset" class="btn-success" value="Reset">No</button>

			</form>
		</section>
	</section>
</section>
<%@ include file="footer.jsp"%>