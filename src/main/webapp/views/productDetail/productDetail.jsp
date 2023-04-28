<%@page import="com.HV2023.entity.Product"%>
<%@page import="com.HV2023.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tutorial</title>
<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500"
	rel="stylesheet">
<!-- CSS -->
<link href="/HV2023/views/productDetail/css/productDetail.css"
	rel="stylesheet">
<meta name="robots" content="noindex,follow" />

</head>

<body> 
				<%
				Product list = (Product) request.getAttribute("product");
				%>
	<main class="container">

		<!-- Left Column / Headphones Image -->
		<div class="left-column">
			<img data-image="black" src="<%=list.getImage() %>" alt=""> <img
				data-image="blue" src="<%=list.getImage() %>" alt=""> <img
				data-image="red" class="active" src="<%=list.getImage() %>" alt="">
		</div>


		<!-- Right Column -->
		<div class="right-column">

			<!-- Product Description -->
			<div class="product-description">
				<h1><%=list.getName() %></h1>
				<p><%=list.getDescription() %></p>
			</div>

			<!-- Product Configuration -->
			<div class="product-configuration">

				<!-- Product Color -->
				<div class="product-color">
					<span>Color</span>

					<div class="color-choose">
						<div>
							<input data-image="red" type="radio" id="red" name="color"
								value="red" checked> <label for="red"><span></span></label>
						</div>
						<div>
							<input data-image="blue" type="radio" id="blue" name="color"
								value="blue"> <label for="blue"><span></span></label>
						</div>
						<div>
							<input data-image="black" type="radio" id="black" name="color"
								value="black"> <label for="black"><span></span></label>
						</div>
					</div>

				</div>

				<!-- Cable Configuration -->
				<div class="cable-config">
					<span>Cable configuration</span>

					<div class="cable-choose">
						<button>Straight</button>
						<button>Coiled</button>
						<button>Long-coiled</button>
					</div>

					<a href="#">How to configurate your headphones</a>
				</div>
			</div>

			<!-- Product Pricing -->
			<div class="product-price">
				<span><%= list.getPrice() %></span> <a href="#" class="cart-btn">Add to cart</a>
				<a href="/HV2023/home" class="cart-btn">Back to home</a>
			</div>
		</div>
	</main>

	<!-- Scripts -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"
		charset="utf-8"></script>
	<script src="/HV2023/views/productDetail/js/productDetail.js"
		charset="utf-8"></script>
</body>
</html>
