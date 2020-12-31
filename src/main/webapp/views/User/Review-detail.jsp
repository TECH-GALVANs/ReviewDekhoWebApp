<%@page import="com.reviewdekho.comment.model.Comment"%>
<%@page import="com.reviewdekho.comment.service.CommentService"%>
<%@page import="java.util.List"%>
<%@page import="com.reviewdekho.review.model.Review"%>
<%@page import="com.reviewdekho.like.service.LikeService"%>
<%@page import="com.reviewdekho.like.model.Like"%>
<%@page import="com.reviewdekho.review.service.ReviewService"%>
<%@ include file="header.jsp"%>
<%
	Integer reviewId = Integer.parseInt( request.getParameter( "reviewId" ) );
	
	LikeService likeService = new LikeService();	
	ReviewService service = new ReviewService();
	CommentService commentService = new CommentService();
	
	Review review = service.get(reviewId);
	
	List<Comment> comments = commentService.getCommentByReview( review.getReview_id() );

%>
<section class="container-fluid">
	<section class="row">
		<section class="col-lg-4 col-md-4 col-sm-4">
			<section class="my-card">
				<section>
					<img src="data:image/<%=review.getProduct().getImageType() %>;base64,<%=review.getProduct().getImage() %>" class="card-img-top" alt="images/mbp.jpg">
					<section class="card-body">
						<h5 class="card-title"><%=review.getProduct().getProduct_name() %></h5>
						<strong class="card-title">Description : </strong>
						<p class="card-text">
							<%=review.getProduct().getProduct_desc() %>
						</p>
						<strong class="">Price : </strong>
						<p class="card-text"><%=review.getProduct().getProduct_price() %></p>
						<hr>
					</section>
				</section>
			</section>
		</section>
		<section class="col-lg-8 col-md-12 col-sm-12">
			<section class="my-card">
				<section class="container reviewer">
					<section class="row">
						<section class="col-4 col-lg-3 col-md-3">
							<img src="data:image/<%=review.getUser().getImageType() %>;base64,<%=review.getUser().getProfileImage() %>"" class="card-img-left rounded-circle"
								alt="images/mbp.jpg">
						</section>
						<section class="col-8 col-lg-9 col-md-9 username">
							<a href="">@<%=review.getUser().getUser_name() %></a>
						</section>
					</section>
					<hr>
				</section>
				<section>
					<section class="card-body">
						<h5 class="card-title"><%=review.getProduct().getProduct_name() %></h5>
						<p class="card-text">
							<%=review.getReview_desc() %>
						</p>
						<hr>
					</section>
				</section>
				<section class="container-fluid reviewer-action">
					<section class="row">
						<!-- style="background-color: red;" -->
						<section class="col-6 like">
							<%
								List<Like> likes = likeService.getByReviewId(review.getReview_id());
								int count = likes.size();
							%>
							<a href="<%=request.getContextPath() %>/like?user=<%=user.getUser_id() %>&reviewId=<%=review.getReview_id() %>" class=""><i class="far fa-thumbs-up"></i> Like <%=count%>
							</a>
						</section>
						<section class="col-6 report">
							<a href=""><i class="far fa-flag"></i> Report</a>
						</section>
					</section>
				</section>
			</section>


		</section>
		<br><br><br><br><br><br><br><br>
		<!-- comment--------------- -->
		<section class="col-lg-12 col-md-12 col-sm-12">
			<section class="my-card">
				<section class="container reviewer">
					<section class="row">
						<section class="col-12 col-lg-12 col-md-12">
							<label>Comments</label>
							<hr>
						</section>
						<% if( user != null){ %>
						<section class="col-12 col-lg-12 col-md-12">
							<label>Add Comments</label>
							<form action="<%=request.getContextPath() %>/comment" method="post"> 
							<input type="text"
								border-radius="25px" name="comment" class="form-control-lg form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp">
							<input type="text" name="user" value="<%=user.getUser_id() %>" hidden="true">
							
							<input type="text" name="review" value="<%=review.getReview_id() %>" hidden="true">
							<button type="submit" class="btn btn-success btn-lg"
								value="Submit">Add Comment</button>
								</form>
							<hr>
						</section>
						<% } %>
						<% for( Comment comment : comments ){ %>
						<section class="col-12 col-lg-12 col-md-12">
							<a href="">@<%=comment.getUser().getUser_name() %></a>
							<p><%=comment.getComment_desc() %></p>
							<hr>
						</section>
						<% } %>
					</section>
				</section>
			</section>
		</section>
	</section>
</section>
</section>
<%@ include file="footer.jsp"%>