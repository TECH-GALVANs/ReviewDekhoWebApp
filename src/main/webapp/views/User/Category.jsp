<%@page import="com.reviewdekho.like.service.LikeService"%>
<%@page import="com.reviewdekho.review.model.Review"%>
<%@page import="com.reviewdekho.like.model.Like"%>
<%@page import="com.reviewdekho.review.service.ReviewService"%>
<%@page import="com.reviewdekho.category.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.reviewdekho.category.service.CategoryService"%>
<%@ include file="header.jsp"%>
<%
	CategoryService categoryService = new CategoryService();
List<Category> categories = categoryService.get();

ReviewService reviewService = new ReviewService();
LikeService likeService = new LikeService();

List<Review> reviews = reviewService.get();
%>
<section class="container-fluid">
	<section class="dropdown">
		<button class="btn btn-success dropdown-toggle" type="button"
			id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false">Select Category</button>
		<section class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<%
				for (Category category : categories) {
			%>
			<a class="dropdown-item" href="#"><%=category.getCategory_name()%></a>
			<%
				}
			%>
		</section>
	</section>
</section>
<section class="container-fluid">
	<section class="row">
		<section class="col-lg-6 col-md-12 col-sm-12">
			<section class="my-card">
				<section class="container reviewer">
					<section class="row">
						<%
							for (Review review : reviews) {
						%>
						<section class="col-4 col-lg-3 col-md-3">
							<img src="images/person.png" class="card-img-left rounded-circle"
								alt="images/mbp.jpg">
						</section>
						<section class="col-8 col-lg-9 col-md-9 username">
							<a href="">@<%=review.getUser().getUser_name()%></a>
						</section>
					</section>
					<hr>
				</section>
				<section>
					<img src="images/mbp.jpg" class="card-img-top" alt="images/mbp.jpg">
					<section class="card-body">
						<h5 class="card-title"><%=review.getProduct().getProduct_name()%></h5>
						<p class="card-text">
							<%=review.getReview_desc()%>
							<a href="" class="read-more">Read more...</a>
						</p>
						<hr>
					</section>
				</section>
				<section class="container-fluid reviewer-action">
					<section class="row">
						<!-- style="background-color: red;" -->
						<section class="col-3 like">
							<%
								List<Like> likes = likeService.getByReviewId(review.getReview_id());
							%>
							<a href="" class=""><i class="far fa-thumbs-up"></i> Like <%=likes.size()%>
							</a>
						</section>
						<section class="col-5 comment">
							<a href="" class="comment"><i class="far fa-comments"></i>
								Comment</a>
						</section>
						<section class="col-4 report">
							<a href=""><i class="far fa-flag"></i> Report</a>
						</section>
					</section>
				</section>
			</section>
		</section>
		<%
			}
		%>
	</section>
</section>
<%@ include file="footer.jsp"%>