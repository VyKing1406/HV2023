<%@page import="com.HV2023.dao.DAO"%>
<%@page import="java.util.List"%>
<%@page import="com.HV2023.entity.Product"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>Eflyer</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- bootstrap css -->
<link rel="stylesheet" type="text/css"
	href="/HV2023/views/home/css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" type="text/css"
	href="/HV2023/views/home/css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="/HV2023/views/home/css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="/HV2023/views/home/images/fevicon.png"
	type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet"
	href="/HV2023/views/home/css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<!-- fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap"
	rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!--  -->
<!-- owl stylesheets -->
<link
	href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext"
	rel="stylesheet">
<link rel="stylesheet"
	href="/HV2023/views/home/css/owl.carousel.min.css">
<link rel="stylesoeet"
	href="/HV2023/views/home/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
</head>
<body>
	<jsp:include page="/views/home/header.jsp"></jsp:include>
	<!-- fashion section start -->
	<div class="fashion_section">
		<div id="main_slider" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="container">
						<h1 class="fashion_taital">Man & Woman Fashion</h1>
						<div class="fashion_section_2">
							<div class="row">
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Man T -shirt</h4>
										<p class="price_text">
											Price <span style="color: #262626;">$ 30</span>
										</p>
										<div class="tshirt_img">
											<img
												src="data:image/jpeg;base64,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">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Man -shirt</h4>
										<p class="price_text">
											Price <span style="color: #262626;">$ 30</span>
										</p>
										<div class="tshirt_img">
											<img src="images/dress-shirt-img.png">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Woman Scart</h4>
										<p class="price_text">
											Price <span style="color: #262626;">$ 30</span>
										</p>
										<div class="tshirt_img">
											<img src="images/women-clothes-img.png">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<% 
					List<Product> list1 = (List<Product>) request.getAttribute("list1");
					int i1=0;
					int length1 = list1.size(); 
					for(i1=0; i1<length1; i1++){ 
						Product item = list1.get(i1); 
						if(i1%3==0){
					%>
				<div class="carousel-item">
					<div class="container">
						<h1 class="fashion_taital">Man & Woman Fashion</h1>
						<div class="fashion_section_2">
							<div class="row">
								<%}%>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text"><%= item.getName() %></h4>
										<h3 class="shirt_text"><%= item.getDescription() %></h3>
										<p class="price_text">
											Price <span style="color: #262626"><%= item.getPrice() %></span>
										</p>
										<div class="tshirt_img">
											<img src="<%= item.getImage() %>" />
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="addToCart?pID=<%= item.getId() %>">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="productDetail?pid=<%= item.getId() %>">See More</a>
											</div>
										</div>
									</div>
								</div>
								<% if((i1-2)%3 == 0 || i1 == length1-1) { %>
							</div>
						</div>
					</div>
				</div>
				<%}%>
				<%}%>
			</div>
			<a class="carousel-control-prev" href="#main_slider" role="button"
				data-slide="prev"> <i class="fa fa-angle-left"></i>
			</a> <a class="carousel-control-next" href="#main_slider" role="button"
				data-slide="next"> <i class="fa fa-angle-right"></i>
			</a>
		</div>
		
	</div>
	<!-- fashion section end -->
	<!-- electronic section start -->
	<div class="fashion_section">
		<div id="electronic_main_slider" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="container">
						<h1 class="fashion_taital">Electronic</h1>
						<div class="fashion_section_2">
							<div class="row">
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Laptop</h4>
										<p class="price_text">
											Start Price <span style="color: #262626;">$ 100</span>
										</p>
										<div class="electronic_img">
											<img src="images/laptop-img.png">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Mobile</h4>
										<p class="price_text">
											Start Price <span style="color: #262626;">$ 100</span>
										</p>
										<div class="electronic_img">
											<img src="images/mobile-img.png">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Computers</h4>
										<p class="price_text">
											Start Price <span style="color: #262626;">$ 100</span>
										</p>
										<div class="electronic_img">
											<img src="images/computer-img.png">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<% 
					List<Product> list2 = (List<Product>) request.getAttribute("list2");
					int i2;
					int length2 = list2.size(); 
					for(i2=0; i2<length2; i2++){ 
						Product item = list2.get(i2); 
						if(i2%3==0){
					%>
				<div class="carousel-item">
					<div class="container">
						<h1 class="fashion_taital">Electronic</h1>
						<div class="fashion_section_2">
							<div class="row">
								<%}%>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text"><%= item.getName() %></h4>
										<h3 class="shirt_text"><%= item.getDescription() %></h3>
										<p class="price_text">
											Price <span style="color: #262626"><%= item.getPrice() %></span>
										</p>
										<div class="tshirt_img">
											<img src="<%= item.getImage() %>" />
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="addToCart?pID=<%= item.getId() %>">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="productDetail?pid=<%= item.getId() %>">See More</a>
											</div>
										</div>
									</div>
								</div>
								<% if((i2-2)%3 == 0 || i2 == length2-1) { %>
							</div>
						</div>
					</div>
				</div>
				<%}%>
				<%}%>
				
			</div>
			<a class="carousel-control-prev" href="#electronic_main_slider"
				role="button" data-slide="prev"> <i class="fa fa-angle-left"></i>
			</a> <a class="carousel-control-next" href="#electronic_main_slider"
				role="button" data-slide="next"> <i class="fa fa-angle-right"></i>
			</a>
		</div>
	</div>
	<!-- electronic section end -->
	<!-- jewellery  section start -->
	<div class="jewellery_section">
		<div id="jewellery_main_slider" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="container">
						<h1 class="fashion_taital">Jewellery Accessories</h1>
						<div class="fashion_section_2">
							<div class="row">
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Jumkas</h4>
										<p class="price_text">
											Start Price <span style="color: #262626;">$ 100</span>
										</p>
										<div class="jewellery_img">
											<img src="images/jhumka-img.png">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Necklaces</h4>
										<p class="price_text">
											Start Price <span style="color: #262626;">$ 100</span>
										</p>
										<div class="jewellery_img">
											<img src="images/neklesh-img.png">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text">Kangans</h4>
										<p class="price_text">
											Start Price <span style="color: #262626;">$ 100</span>
										</p>
										<div class="jewellery_img">
											<img src="images/kangan-img.png">
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="#">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="#">See More</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%  

					List<Product> list3 = (List<Product>) request.getAttribute("list3");
					int i3;
					int length3 = list3.size(); 
					for(i3=0; i3<length3; i3++){ 
						Product item = list3.get(i3); 
						if(i3%3==0){
					%>
				<div class="carousel-item">
					<div class="container">
						<h1 class="fashion_taital">Jewellery Accessories</h1>
						<div class="fashion_section_2">
							<div class="row">
								<%}%>
								<div class="col-lg-4 col-sm-4">
									<div class="box_main">
										<h4 class="shirt_text"><%= item.getName() %></h4>
										<h3 class="shirt_text"><%= item.getDescription() %></h3>
										<p class="price_text">
											Price <span style="color: #262626"><%= item.getPrice() %></span>
										</p>
										<div class="tshirt_img">
											<img src="<%= item.getImage() %>" />
										</div>
										<div class="btn_main">
											<div class="buy_bt">
												<a href="addToCart?pID=<%= item.getId() %>">Add to cart</a>
											</div>
											<div class="seemore_bt">
												<a href="productDetail?pid=<%= item.getId() %>">See More</a>
											</div>
										</div>
									</div>
								</div>
								<% if((i3-2)%3 == 0 || i3 == length3-1) { %>
							</div>
						</div>
					</div>
				</div>
				<%}%>
				<%}%>			</div>
			<a class="carousel-control-prev" href="#jewellery_main_slider"
				role="button" data-slide="prev"> <i class="fa fa-angle-left"></i>
			</a> <a class="carousel-control-next" href="#jewellery_main_slider"
				role="button" data-slide="next"> <i class="fa fa-angle-right"></i>
			</a>
			<div class="loader_main">
				<div class="loader"></div>
			</div>
		</div>
	</div>
	<!-- jewellery  section end -->
	<!-- footer section start -->
	<div class="footer_section layout_padding">
		<div class="container">
			<div class="footer_logo">
				<a href="index.html"><img src="images/footer-logo.png"></a>
			</div>
			<div class="input_bt">
				<input type="text" class="mail_bt" placeholder="Your Email"
					name="Your Email"> <span class="subscribe_bt"
					id="basic-addon2"><a href="#">Subscribe</a></span>
			</div>
			<div class="footer_menu">
				<ul>
					<li><a href="#">Best Sellers</a></li>
					<li><a href="#">Gift Ideas</a></li>
					<li><a href="#">New Releases</a></li>
					<li><a href="#">Today's Deals</a></li>
					<li><a href="#">Customer Service</a></li>
				</ul>
			</div>
			<div class="location_main">
				Help Line Number : <a href="#">+1 1800 1200 1200</a>
			</div>
		</div>
	</div>
	<!-- footer section end -->
	<!-- copyright section start -->
	<div class="copyright_section">
		<div class="container">
			<p class="copyright_text">
				© 2020 All Rights Reserved. Design by <a href="https://html.design">Free
					html Templates</a>
			</p>
		</div>
	</div>
	<!-- copyright section end -->
	<!-- Javascript files-->
	<script src="/HV2023/views/home/js/jquery.min.js"></script>
	<script src="/HV2023/views/home/js/popper.min.js"></script>
	<script src="/HV2023/views/home/js/bootstrap.bundle.min.js"></script>
	<script src="/HV2023/views/home/js/jquery-3.0.0.min.js"></script>
	<script src="/HV2023/views/home/js/plugin.js"></script>
	<!-- sidebar -->
	<script
		src="/HV2023/views/home/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="/HV2023/views/home/js/custom.js"></script>
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>
</body>
</html>