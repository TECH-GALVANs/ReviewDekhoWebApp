<%@page import="com.reviewdekho.like.service.LikeService"%>
<%@page import="com.reviewdekho.review.model.Review"%>
<%@page import="com.reviewdekho.like.model.Like"%>
<%@page import="com.reviewdekho.review.service.ReviewService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ReviewService reviewService = new ReviewService();
LikeService likeService = new LikeService();

List<Review> reviews = reviewService.get();
%>
<%@ include file="header.jsp"%>
<section class="header-area row">
	<section class="col-lg-6 col-md-12 col-sm-12">
		<section id="heading-title">
			<h2>Find the best review of of the product which you looking
				for...</h2>
			<button type="button" class="btn btn-outline-light btn-lg">
				<i class="fab fa-google-play"></i> Download App
			</button>
		</section>
	</section>
	<section class="col-lg-6 col-md-12 col-sm-12">
		<section id="heading-image">
			<img src="images/review.png" alt="">
		</section>
	</section>
</section>
<section class="container-fluid">
	<section class="row">
	<%
		for (Review review : reviews) {
	%>
		<section class="col-lg-6 col-md-12 col-sm-12">
			<section class="my-card">
				<section class="container reviewer">
					<section class="row">
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
							<a href="Review-detail.jsp?reviewId=<%=review.getReview_id() %>" class="read-more">Read more...</a>
						</p>
						<hr>
					</section>
				</section>
				<section class="container-fluid reviewer-action">
					<section class="row">
						<!-- style="background-color: red;" -->
						<% if ( user != null ){ %>
						<section class="col-3 like">
							<%
								List<Like> likes = likeService.getByReviewId(review.getReview_id());
								int count = likes.size();
							%>
							<a href="<%=request.getContextPath() %>/like?user=<%=user.getUser_id() %>&review=<%=review.getReview_id() %>" class=""><i class="far fa-thumbs-up"></i> Like <%=count%>
								</a>
						</section>
						<section class="col-5 comment">
							<a href="" class="comment"><i class="far fa-comments"></i>
								Comment</a>
						</section>
						<section class="col-4 report">
							<a href=""><i class="far fa-flag"></i> Report</a>
						</section>
						<% } %>
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