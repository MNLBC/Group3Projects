<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-1-10-2-min.js"></script>
<script src="js/bootstrap-min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<title>Kanen Online Shopping</title>

<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link media="all" type="text/css" rel="stylesheet" href="css/style.css">
<script src="js/jquery-min.js"></script>
<script src="js/bootstrap-min.js"></script>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
<script>
	$(document).ready(function() {

		$.ajax({
			url : 'product',
			data : {
				method : 'getProducts'
			},
			method : 'POST',
			complete : function(responseText) {
				displayResults(responseText);

			}

		});
	});

	function displayResults(responseText) {

		//alert(responseText);
		var responseData = JSON.parse(responseText.responseText).data;
		var productListArray = responseData.products;
		var numerOfProductRows = Math.ceil(productListArray.length / 4);

		var containerDivCounter = 0;
		var rowDivCounter = 0;

		var productStartCounter = 0;
		var productEndCounter = 4;
		
		var documentBody = document.getElementById("body");
		
		for (var i = 0; i < numerOfProductRows; i++) {
			
			var containerDiv = document.createElement('div');
			containerDiv.id = 'containerdiv' + containerDivCounter;
			containerDiv.className = 'container';
			containerDiv.style = 'margin-top: 50px'
			documentBody.appendChild(containerDiv);
			containerDivCounter += 1;
			
			var rowDiv = document.createElement('div');
			rowDiv.id = 'rowdiv' + rowDivCounter;
			rowDiv.className = 'row';
			rowDivCounter += 1;

			containerDiv.appendChild(rowDiv);

		    for (var j = productStartCounter; j < productEndCounter; ) {
				var colxsDiv = document.createElement('div');
				colxsDiv.className = 'col-xs-12 col-sm-6 col-md-3';
				rowDiv.appendChild(colxsDiv);
				
			 	var colItemDiv = document.createElement('div');
			 	colItemDiv.className = 'col-item';
				colxsDiv.appendChild(colItemDiv);  
				
				var imgContentDiv = document.createElement('div');
				imgContentDiv.className = 'post-img-content';
				colItemDiv.appendChild(imgContentDiv);  
				
				var image = document.createElement('img');
				image.className = 'img-responsive';
				image.src = productListArray[0].imagePath;
				imgContentDiv.appendChild(image);
				
				var imageSpan = document.createElement('span');
				imageSpan.className = 'post-title';
				imgContentDiv.appendChild(imageSpan); 
				
			}
			
			/* productStartCounter +=4;
			productEndCounter +=4; */

		}
		/* for(var i=0; i< productListArray.length; i++){
			var product = productListArray[i];
			productsRowCounter += 1;
			
			
		}	 */
		return;
	};
</script>
</head>
<body id="body">

	<header class="header-login-signup">


	<div class="header-limiter">




		<nav> <a href="#">Products</a> <!-- Aica JayBee Merge--> <a
			href="Cart_Modal.jsp" class="selected" data-toggle="modal"
			data-target="#cartModal">View Cart</a> <!-- Aica JayBee Merge--> </nav>

		<ul>
			<!-- Aica JayBee Merge-->
			<a href="Login_Modal.jsp" class="logout-button" class="selected"
				data-toggle="modal" data-target="#loginModal">Login</a>
			<a href="Register_Modal.jsp" class="logout-button" class="selected"
				data-toggle="modal" data-target="#registerModal">Sign up</a>
			<!-- Aica <3 JayBee Merge-->
			<!--  	<a href="#" class="logout-button">Logout</a>-->
		</ul>


		<center>
			<h1>
				<img src="resources/cart.png" style="width: 58px; height: 47px;"><a
					href="#"> Kanen<span>Online Shopping</span>

				</a>
				<hr width="700" align="center" color="white" style="width: 778px;">
			</h1>

		</center>


	</div>


	</header>
	</br>

	<div class="slider">
		<div class="container">
			<div id="main-carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="item active">
						<img src="resources/image1.PNG" alt="Slider"
							class="img-responsive">
					</div>
					<div class="item">
						<img src="resources/image2.PNG" alt="Slider"
							class="img-responsive">
					</div>
					<div class="item">
						<img src="resources/image3.PNG" alt="Slider"
							class="img-responsive">
					</div>
					<div class="item">
						<img src="resources/image4.PNG" alt="Slider"
							class="img-responsive">
					</div>
					<div class="item">
						<img src="resources/image5.PNG" alt="Slider"
							class="img-responsive">
					</div>
				</div>
				<a class="left carousel-control" href="#main-carousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="right carousel-control" href="#main-carousel"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
		</div>
	</div>

	</br>



</body>
</html>