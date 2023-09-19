<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" charset="ISO-8859-1" content="width=device-width, initial-scale=1.0">
<title>Home | WatchStore</title>
<link rel="stylesheet" type="text/css" href="styles/nav.css">
<link rel="stylesheet" type="text/css" href="styles/index.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	>
	<script src="scripts/slide.js"></script>
</head>

<body>

	<%@include file="includes/nav.jsp"%>



	<div class="slider-box">
		<div id="slider" class="slider">
			<img src="images\slides\slide1.jpg" alt=""> <img
				src="images\slides\slide2.webp" alt=""> <img
				src="images\slides\FastrackSlide2.webp" alt=""> <img
				src="images\slides\womenswatches.webp" alt="">
		</div>
		<div class="indicators">
			<span id="btn1" class="active"></span>
			 <span id="btn2"></span> 
			 <span id="btn3"></span> 
			 <span id="btn4"></span>
		</div>
	</div>

	<p class="headlines">Shop For</p>

	<div class="wrapper">
		<div class="image-list">
			<div class="image-box">
				<img src="images\products\kidswatches.webp" alt="">
				 <a
					href="kids.jsp">
					<p>kids Watches</p>
				</a>
			</div>

			<div class="image-box">
				<img src="images\products\menwatches.webp" alt=""> <a
					href="men.jsp">
					<p>Mens Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\TitanRagaCeramics.webp" alt=""> <a
					href="women.jsp">
					<p>Women Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\wallclocks.webp" alt=""> <a
					href="wallclocks.html">
					<p>wall Clocks</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\TitanTalk.webp" alt=""> <a
					href="smart.html">
					<p>Smart Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\kidswatches.webp" alt=""> <a
					href="kids.html">
					<p>kids Watches</p>
				</a>
			</div>

			<div class="image-box">
				<img src="images\products\menwatches.webp" alt=""> <a
					href="men.html">
					<p>Mens Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\TitanRagaCeramics.webp" alt=""> <a
					href="women.html">
					<p>Women Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\wallclocks.webp" alt=""> <a
					href="wallclocks.html">
					<p>wall Clocks</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\TitanTalk.webp" alt=""> <a
					href="smart.html">
					<p>Smart Watches</p>
				</a>

			</div>


		</div>
	</div>
	<p class="headlines">Our Top Products</p>

	<div class="wrapper">

		<div class="image-list">
			<div class="image-box">
				<img src="images\products\kidswatches.webp" alt=""> <a
					href="kids.html">
					<p>kids Watches</p>
				</a>
			</div>

			<div class="image-box">
				<img src="images\products\menwatches.webp" alt=""> <a
					href="men.html">
					<p>Mens Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\TitanRagaCeramics.webp" alt=""> <a
					href="women.html">
					<p>Women Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\wallclocks.webp" alt=""> <a
					href="wallclocks.html">
					<p>wall Clocks</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\TitanTalk.webp" alt=""> <a
					href="smart.html">
					<p>Smart Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\kidswatches.webp" alt=""> <a
					href="kids.html">
					<p>kids Watches</p>
				</a>
			</div>

			<div class="image-box">
				<img src="images\products\menwatches.webp" alt=""> <a
					href="men.html">
					<p>Mens Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\TitanRagaCeramics.webp" alt=""> <a
					href="women.html">
					<p>Women Watches</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\wallclocks.webp" alt=""> <a
					href="wallclocks.html">
					<p>wall Clocks</p>
				</a>

			</div>
			<div class="image-box">
				<img src="images\products\TitanTalk.webp" alt=""> <a
					href="smart.html">
					<p>Smart Watches</p>
				</a>

			</div>


		</div>
	</div>
	
	<script src="scripts/slide.js"></script>
</body>
</html>