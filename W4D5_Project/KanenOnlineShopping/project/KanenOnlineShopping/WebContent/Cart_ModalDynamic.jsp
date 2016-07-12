<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Item Cart</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<script>
	$(document)
			.on(
					'change',
					'.form-control-input-sm',
					function() {
						var prodQuantityTextFields = $('.form-control-input-sm');
						console.log(prodQuantityTextFields[0].value);
						console.log(prodQuantityTextFields[0].productPrice);
						var totalCost = 0.00;
						for (var i = 0; i < prodQuantityTextFields.length; i++) {
							totalCost += (prodQuantityTextFields[i].value * prodQuantityTextFields[i].productPrice);
						}
						var totalInCart = $('#totalInCart')[0];
						totalInCart.textContent = '$' + totalCost;

					});

	function displayResults(responseText) {
		var responseData = JSON.parse(responseText.responseText).data;
		var itemsInCart = responseData.itemsInCart;
		var totalPrice = 0;
		for (var i = 0; i < itemsInCart.length; i++) {
			var rowDiv = document.createElement('div');
			rowDiv.id = 'itemRow' + itemsInCart[i].productId;

			var colxsDiv = document.createElement('div');
			colxsDiv.className = 'col-xs-2';

			var imgContentDiv = document.createElement('img');
			imgContentDiv.className = 'img-responsive';
			imgContentDiv.src = itemsInCart[i].imagePath;

			colxsDiv.appendChild(imgContentDiv);
			rowDiv.appendChild(colxsDiv);

			var colxsProductDiv = document.createElement('div');
			colxsProductDiv.className = 'col-xs-4';

			var productNameDiv = document.createElement('h4');
			productNameDiv.className = 'product-name';

			var strongProductName = document.createElement('strong');
			strongProductName.textContent = itemsInCart[i].productName;
			productNameDiv.appendChild(strongProductName);

			colxsProductDiv.appendChild(productNameDiv);

			var h4ProductDesc = document.createElement('h4');
			var smallProductDesc = document.createElement('small');
			smallProductDesc.textContent = itemsInCart[i].productDescription;
			h4ProductDesc.appendChild(smallProductDesc);
			colxsProductDiv.appendChild(h4ProductDesc);

			rowDiv.appendChild(colxsProductDiv);

			var colxsItemDiv = document.createElement('div');
			colxsItemDiv.className = 'col-xs-6';

			var colxsItemCartDiv = document.createElement('div');
			colxsItemCartDiv.className = 'col-xs-6 text-right';

			var h6ProductPrice = document.createElement('h6');
			var strongProductPrice = document.createElement('strong');

			var labelProductPrice = document.createElement('label');
			labelProductPrice.textContent = itemsInCart[i].productPrice;
			strongProductPrice.appendChild(labelProductPrice);

			var spanProductPrice = document.createElement('span');
			spanProductPrice.className = 'text-muted';
			strongProductPrice.appendChild(spanProductPrice);

			h6ProductPrice.appendChild(strongProductPrice);
			colxsItemCartDiv.appendChild(h6ProductPrice);
			colxsItemDiv.appendChild(colxsItemCartDiv);

			var colxsInputDiv = document.createElement('div');
			colxsInputDiv.className = 'col-xs-4';

			var productQuantity = document.createElement('input');
			productQuantity.type = 'text';
			productQuantity.className = 'form-control input-sm';
			productQuantity.productPrice = itemsInCart[i].productPrice;
			productQuantity.id = 'txtQty' + itemsInCart[i].productId;

			productQuantity.value = itemsInCart[i].quantity;
			colxsInputDiv.appendChild(productQuantity);

			var btnColXs2Div = document.createElement('div');
			btnColXs2Div.className = 'col-xs-2';

			var trashButton = document.createElement('button');
			trashButton.type = 'button';
			trashButton.productId = itemsInCart[i].productId;
			trashButton.className = 'btn-btn-link-btn-xs';

			var trashSpan = document.createElement('span');
			trashSpan.className = 'glyphicon glyphicon-trash';
			trashButton.appendChild(trashSpan);

			btnColXs2Div.appendChild(trashButton);
			colxsItemDiv.appendChild(colxsInputDiv);
			colxsItemDiv.appendChild(btnColXs2Div);

			rowDiv.appendChild(colxsItemDiv);

			var divBodyCartModal = document.getElementById('divBodyCartModal');
			divBodyCartModal.appendChild(rowDiv);

			var hrElement = document.createElement('hr');
			divBodyCartModal.appendChild(hrElement);

			totalPrice += (itemsInCart[i].productPrice * itemsInCart[i].quantity);
		}

		var totalInCart = document.getElementById('totalInCart');
		totalInCart.textContent = '$' + totalPrice;
	}
</script>


<body>

	<div class="modal-header">
		<button id="modal-closing" type="button" class="close"
			data-dismiss="modal">&times;</button>
		<h4 class="modal-title">Your Items</h4>
	</div>

	<div class="modal-body">

		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<div class="panel panel-info">

						<div class="panel-heading">
							<div class="panel-title">
								<div class="row">
									<div class="col-xs-6">
										<h5>
											<span class="glyphicon glyphicon-shopping-cart"></span>
											Shopping Cart
										</h5>
									</div>
									<div class="col-xs-6">
										<button type="button" class="btn btn-primary btn-sm btn-block">
											<span class="glyphicon glyphicon-share-alt"></span> Continue
											shopping
										</button>
									</div>
								</div>
							</div>
						</div>
						<!--  end of panel heading -->

						<div class="panel-body">

							<div id="divBodyCartModal"></div>
							<!-- end of div body cart modal,end of dynamic content  -->
							<div class="row">
								<div class="text-center">
									<div class="col-xs-9">
										<h6 class="text-right">Added items?</h6>
									</div>
									<div class="col-xs-3">
										<!-- <button id="cart_update_btn" type="button" class="btn btn-default btn-sm btn-block"
											onclick="myFunction()">Update cart</button> -->
										<button id="cart_update_btn" type="button"
											class="btn btn-default btn-sm btn-block"
											onclick="myFunction()">Update cart</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--  end of panel info -->

				</div>
			</div>
			<!--  end of outer most row  -->
		</div>
		<!-- end of container-fluid div -->

	</div>


	<!-- FOOTER  -->
	<div class="panel-footer">
		<div class="row text-center">

			<div class="col-xs-7">
				<h4 class="text-right">
					Total <strong id="totalInCart"></strong>
				</h4>
			</div>

			<div class="col-xs-3">
				<button type="button" id="btnCheckout"
					class="btn btn-success btn-block">Checkout</button>
			</div>

			<div class="col-xs-2">
				<button name="btnClearCart"
					class="btn btn-danger btn-block" data-dismiss="modal">Back</button>
			</div>

		</div>
	</div>
	</div>

</body>
</html>