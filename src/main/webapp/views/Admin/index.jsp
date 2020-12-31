<%@page import="com.reviewdekho.user.model.User"%>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>ReviewDekho.com</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- icons -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<!-- favicon
		============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Google Fonts
		============================================ -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
	rel="stylesheet">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- font awesome CSS
		============================================ -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- owl.carousel CSS
		============================================ -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/owl.transitions.css">
<!-- meanmenu CSS
		============================================ -->
<link rel="stylesheet" href="css/meanmenu/meanmenu.min.css">
<!-- animate CSS
		============================================ -->
<link rel="stylesheet" href="css/animate.css">
<!-- summernote CSS
		============================================ -->
<link rel="stylesheet" href="css/summernote/summernote.css">
<!-- Range Slider CSS
		============================================ -->
<link rel="stylesheet" href="css/themesaller-forms.css">
<!-- normalize CSS
		============================================ -->
<link rel="stylesheet" href="css/normalize.css">
<!-- mCustomScrollbar CSS
		============================================ -->
<link rel="stylesheet"
	href="css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- Notika icon CSS
		============================================ -->
<link rel="stylesheet" href="css/notika-custom-icon.css">
<!-- bootstrap select CSS
		============================================ -->
<link rel="stylesheet" href="css/bootstrap-select/bootstrap-select.css">
<!-- datapicker CSS
		============================================ -->
<link rel="stylesheet" href="css/datapicker/datepicker3.css">
<!-- Color Picker CSS
		============================================ -->
<link rel="stylesheet" href="css/color-picker/farbtastic.css">
<!-- main CSS
		============================================ -->
<link rel="stylesheet" href="css/chosen/chosen.css">
<!-- notification CSS
		============================================ -->
<link rel="stylesheet" href="css/notification/notification.css">
<!-- dropzone CSS
		============================================ -->
<link rel="stylesheet" href="css/dropzone/dropzone.css">
<!-- wave CSS
		============================================ -->
<link rel="stylesheet" href="css/wave/waves.min.css">
<!-- main CSS
		============================================ -->
<link rel="stylesheet" href="css/main.css">
<!-- style CSS
		============================================ -->
<link rel="stylesheet" href="style.css">
<!-- responsive CSS
		============================================ -->
<link rel="stylesheet" href="css/responsive.css">
<!-- modernizr JS
		============================================ -->
<script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
	<div class="header-top-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="logo-area" style="color: white;">
						<a class="logo-style" href="Admin/index.jsp"
							style="color: white; font-size: 25px; font-weight: bold;"><i
							class="fas fa-eye"></i> ReviewDekho</a>
					</div>
				</div>
				<%
					User user = (User) session.getAttribute( "user" );
				%>
				<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
					<div class="header-top-menu">
						<ul class="nav navbar-nav notika-top-nav">
							<li class="nav-item dropdown">
								<a href="../User/index.jsp" class="nav-link">User-side</a>
							</li>
							<li class="nav-item dropdown">
								<a href="" class="nav-link"><%=user.getUser_name() %></a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="main-menu-area mg-tb-40">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
						<li class="active"><a href="index.jsp"><i
								class="notika-icon notika-house"></i> Home</a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/category"><i
								class="notika-icon notika-mail"></i> Category</a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/sub-category"><i
								class="notika-icon notika-edit"></i> Sub-category</a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/product"><i
								class="notika-icon notika-bar-chart"></i> Products</a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/review"><i
								class="notika-icon notika-windows"></i> Reviews</a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/user"><i
								class="notika-icon notika-form"></i> Users</a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/report"><i class="notika-icon notika-app"></i> Report </a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/like"><i class="notika-icon notika-support"></i> Like</a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/comment"><i class="notika-icon notika-support"></i> Comment</a></li>
						<li class="active"><a href="<%=request.getContextPath() %>/reviewer"><i class="notika-icon notika-support"></i> Being Reviewer</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- header ends -->
	<!-- footer  started -->
	<div class="footer-copyright-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="footer-copy-right">
						<p>Copyright &#169; 2020 . All rights reserved by ReviewDekho.com</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Footer area-->
	<!-- jquery
    ============================================ -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script src="js/bootstrap.min.js"></script>
	<!-- wow JS
		============================================ -->
	<script src="js/wow.min.js"></script>
	<!-- price-slider JS
		============================================ -->
	<script src="js/jquery-price-slider.js"></script>
	<!-- owl.carousel JS
		============================================ -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script src="js/jquery.scrollUp.min.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script src="js/meanmenu/jquery.meanmenu.js"></script>
	<!-- counterup JS
		============================================ -->
	<script src="js/counterup/jquery.counterup.min.js"></script>
	<script src="js/counterup/waypoints.min.js"></script>
	<script src="js/counterup/counterup-active.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- sparkline JS
		============================================ -->
	<script src="js/sparkline/jquery.sparkline.min.js"></script>
	<script src="js/sparkline/sparkline-active.js"></script>
	<!-- flot JS
		============================================ -->
	<script src="js/flot/jquery.flot.js"></script>
	<script src="js/flot/jquery.flot.resize.js"></script>
	<script src="js/flot/flot-active.js"></script>
	<!-- knob JS
		============================================ -->
	<script src="js/knob/jquery.knob.js"></script>
	<script src="js/knob/jquery.appear.js"></script>
	<script src="js/knob/knob-active.js"></script>
	<!-- Input Mask JS
		============================================ -->
	<script src="js/jasny-bootstrap.min.js"></script>
	<!-- icheck JS
		============================================ -->
	<script src="js/icheck/icheck.min.js"></script>
	<script src="js/icheck/icheck-active.js"></script>
	<!-- rangle-slider JS
		============================================ -->
	<script src="js/rangle-slider/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="js/rangle-slider/jquery-ui-touch-punch.min.js"></script>
	<script src="js/rangle-slider/rangle-active.js"></script>
	<!-- datapicker JS
		============================================ -->
	<script src="js/datapicker/bootstrap-datepicker.js"></script>
	<script src="js/datapicker/datepicker-active.js"></script>
	<!-- bootstrap select JS
		============================================ -->
	<script src="js/bootstrap-select/bootstrap-select.js"></script>
	<!--  color-picker JS
		============================================ -->
	<script src="js/color-picker/farbtastic.min.js"></script>
	<script src="js/color-picker/color-picker.js"></script>
	<!--  notification JS
		============================================ -->
	<script src="js/notification/bootstrap-growl.min.js"></script>
	<script src="js/notification/notification-active.js"></script>
	<!--  summernote JS
		============================================ -->
	<script src="js/summernote/summernote-updated.min.js"></script>
	<script src="js/summernote/summernote-active.js"></script>
	<!-- dropzone JS
		============================================ -->
	<script src="js/dropzone/dropzone.js"></script>
	<!--  wave JS
		============================================ -->
	<script src="js/wave/waves.min.js"></script>
	<script src="js/wave/wave-active.js"></script>
	<!--  chosen JS
		============================================ -->
	<script src="js/chosen/chosen.jquery.js"></script>
	<!--  Chat JS
		============================================ -->
	<script src="js/chat/jquery.chat.js"></script>
	<!--  todo JS
		============================================ -->
	<script src="js/todo/jquery.todo.js"></script>
	<!-- plugins JS
		============================================ -->
	<script src="js/plugins.js"></script>
	<!-- main JS
		============================================ -->
	<script src="js/main.js"></script>
	<!-- tawk chat JS
		============================================ -->
	<!-- <script src="js/tawk-chat.js"></script> -->
</body>

</html>
