<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.oocl.mnlbc.group3.listener.*" %>
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
var loggedInUserId = '';
$(document)
			.ready(
					function() {

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
						
						$.ajax({
							url : 'user',
							data : {
								method : 'checkIfHasSession'
							},
							method : 'POST',
							complete : function(responseText) {
								//displayResults(responseText);
								var data = JSON.parse(responseText.responseText);
								if(data.userid == 'nouser'){
									$('#logout-link-href').hide();
									$('#userTransaction').hide();
								}else{
									$('#login-link-href').hide();
									$('#signup-link-href').hide();
									loggedInUserId = data.userid;
									
								}
								
							}

						});
						$(document)
						.on(
								"click",
								"#logout-link-href",
								function() {
									$.ajax({
										url : 'user',
										data : {
											method : 'logoutUser'
										},
										method : 'POST',
										complete : function(responseText) {
											//displayResults(responseText);
											var data = JSON.parse(responseText.responseText);
											if(data.success == true){
												/* $('#logout-link-href').hide();
												$('#login-link-href').show();
												$('#signup-link-href').show(); */
												window.location.reload();
											}
											
										}

									});
									
								}
							);
						
						$(document)
								.on(
										"click",
										".hidden-sm",
										function() {

											var productId = this.id;
											var prodPrice = this.productPrice;
											var productDescription = this.productDescription;
											var productName = this.productName;
											var productImagePath = this.imagePath;
											$
													.ajax({
														url : 'product',
														data : {
															method : 'addProductToCart',
															productId : productId,
															productName : productName,
															productDescription : productDescription,
															imagePath : productImagePath,
															productPrice : prodPrice
														},
														method : 'POST',
														complete : function(
																responseText) {
															var isProductAdded = JSON
																	.parse(responseText.responseText).success;
															if (isProductAdded == true) {
																alert('Product added to cart.');
															} else {
																alert('Item quantity increased.');
															}
														}

													});

										});

						$(document)
						.on(
								"click",
								"#btnCheckout",
								function() {
									//fnOpenNormalDialog();
									//alert('test checkout');
									if(loggedInUserId == ''){
										alert('Please login first.');
										return;
									}
									if(confirm('Are you sure you want to proceed to checkout?')){
										$.ajax({
											url : 'product',
											data : {
												method : 'checkoutCart'
											},
											method : 'POST',
											complete : function(responseText) {
												//displayResults(responseText);
												alert('Order successfully created');
												window.location.reload();
											}

										});
									}else{
										
									}
								}
						);
						
						$(document)
						.on(
								"click",
								".btn-btn-link-btn-xs",
								function() {
									 var productId = this.productId;
									$.ajax({
										url : 'product',
										data : {
											method : 'deleteProduct',
											productId : productId
										},
										method : 'POST',
										complete : function(responseText) {
											//displayResults(responseText);
											
										}

									});
									 
									 
									 var modalClosingBtn = document.getElementById('modal-closing');
									 modalClosingBtn.click();
										
									 //document.getElementById('viewCart').click(); 
									
								}
						);
						
						$(document)
						.on(
								"click",
								"#cart_update_btn",
								function() {
									var productQtyTxts = $('input');
									var productsToUpdateStr = '';
									
									for(var i=0; i< productQtyTxts.length; i++){
										productsToUpdateStr += 'prodId:'+ productQtyTxts[i].id+',';
										productsToUpdateStr += 'qty:' + productQtyTxts[i].value + '~';
									}
									productsToUpdateStr = productsToUpdateStr.substr(0,productsToUpdateStr.length-1);
									$.ajax({
										url : 'product',
										data : {
											method : 'updateProductQty',
											productsToUpdate : productsToUpdateStr
										},
										method : 'POST',
										complete : function(responseText) {
											//displayResults(responseText);
											//console.log(responseText);
										}

									});
									
									var modalClosingBtn = document.getElementById('modal-closing');
									modalClosingBtn.click();
									
								});
						$(document)
								.on(
										"click",
										"#viewCart",
										function() {

											var divBodyCartModal = document
													.getElementById('divBodyCartModal');
											if (divBodyCartModal != null) {
												$('#divBodyCartModal').empty();
											}

											$
													.ajax({
														url : 'product',
														data : {
															method : 'getItemsinCart'
														},
														method : 'POST',
														complete : function(
																responseText) {
															//	displayResults(responseText);
															var myvar;
															displayResults(responseText);
														}

													});
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

			for (var j = productStartCounter; j < productEndCounter; j++) {

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
				image.src = productListArray[j].imagePath;
				imgContentDiv.appendChild(image);

				var imageSpan = document.createElement('span');
				imageSpan.className = 'post-title';
				imgContentDiv.appendChild(imageSpan);

				var infoDiv = document.createElement('div');
				infoDiv.className = 'info';
				colItemDiv.appendChild(infoDiv);

				var productRowDiv = document.createElement('div');
				productRowDiv.className = 'row';
				infoDiv.appendChild(productRowDiv);

				var priceDiv = document.createElement('div');
				priceDiv.className = 'price col-md-6';
				productRowDiv.appendChild(priceDiv);

				var productNameText = document.createElement('h5');
				productNameText.textContent = productListArray[j].productName;
				priceDiv.appendChild(productNameText);

				var priceText = document.createElement('h5');
				priceText.textContent = '$' + productListArray[j].productPrice;
				priceText.className = 'price-text-color';
				priceDiv.appendChild(priceText);
				
				//<div class="rating hidden-sm col-md-6"></div>
				var ratingHiddenDiv = document.createElement('div');
				ratingHiddenDiv.className = 'rating hidden-sm col-md-6';
				productRowDiv.appendChild(ratingHiddenDiv);
				
				var separatorDiv = document.createElement('div');
				separatorDiv.className = 'separator clear-left';
				infoDiv.appendChild(separatorDiv);

				var addToCartP = document.createElement('p');
				addToCartP.className = 'btn-add';
				

				var iFaShoppingCart = document.createElement('i');
				iFaShoppingCart.className = 'fa fa-shopping-cart';
				addToCartP.appendChild(iFaShoppingCart);

				var addToCartLink = document.createElement('a');
				addToCartLink.id = productListArray[j].productId;
				addToCartLink.productName = productListArray[j].productName;
				addToCartLink.productDescription = productListArray[j].productDescription;
				addToCartLink.productPrice = productListArray[j].productPrice;
				addToCartLink.imagePath = productListArray[j].imagePath;

				//addToCartLink.href = 'product?method=addProductToCart&productId=' +  productListArray[j].productId;
				addToCartLink.className = 'hidden-sm';
				addToCartLink.textContent = 'Add to cart';
				addToCartP.appendChild(addToCartLink);

				separatorDiv.appendChild(addToCartP)
				
				var detailsP = document.createElement('p');
				detailsP.className = 'btn-details';
				
				var faList = document.createElement('i');
				faList.className = 'fa fa-list';
				detailsP.appendChild(faList);

				var moreDetailsLink = document.createElement('a');
				moreDetailsLink.href = 'product?method=viewProductDetails&productId='
						+ productListArray[j].productId;
				moreDetailsLink.className = 'hidden-sm';
				moreDetailsLink.textContent = 'MoreDetails';
				detailsP.appendChild(moreDetailsLink);
				
				separatorDiv.appendChild(detailsP)

				//<div class="clearfix"></div>
				
				
				

			}

			productStartCounter += 4;
			productEndCounter += 4;

		}

		return;
	};
</script>


</head>
<body id="body">

	<header class="header-login-signup">


	<div class="header-limiter">
	
		<nav> <a href="UserTransaction.jsp" id="userTransaction">My Transaction</a> <!-- Aica JayBee Merge--> <a
			href="Cart_ModalDynamic.jsp" class="selected" data-toggle="modal"
			data-target="#cartModal" id="viewCart">View Cart</a> <!-- Aica JayBee Merge-->
		</nav>

		<ul>
			<!-- Aica JayBee Merge-->
			<a href="Login_Modal.jsp" id="login-link-href" class="logout-button" class="selected"
				data-toggle="modal" data-target="#loginModal">Login</a>
				
			<a href="Register_Modal.jsp" id="signup-link-href" class="logout-button" class="selected"
				data-toggle="modal" data-target="#registerModal" onclick="clearFields">Sign up</a>
				
			<a href="" id="logout-link-href" class="logout-button" class="selected">Logout</a>
					
			<!-- Aica <3 JayBee Merge-->
			<!--  	<a href="#" class="logout-button">Logout</a>-->

	<%
OnlineCounterListener counter = (OnlineCounterListener) session
.getAttribute(OnlineCounterListener.session_cnt);
%>
</br> 
		</br>
		<br><br><br><br>

	Number of Online Users:
<%=counter.getOnlineUsers()%> 
 
			
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

	<!-- Aica JayBee Merge-->
	<div class="modal fade" id="cartModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content"></div>
		</div>
	</div>

	<div class="modal fade" id="loginModal" role="dialog">
		<div class="modal-login">
			<div class="modal-content"></div>
		</div>
	</div>

	<div class="modal fade" id="registerModal" role="dialog">
		<div class="modal-registration">
			<div class="modal-content"></div>
		</div>
	</div>
	<!-- Aica JayBee Merge-->

</body>
</html>