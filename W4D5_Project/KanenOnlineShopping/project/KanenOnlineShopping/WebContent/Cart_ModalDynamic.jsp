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
	function displayResults(responseText) {
		var responseData = JSON.parse(responseText.responseText).data;
		console.log(responseData);
		var itemsInCart = responseData.itemsInCart;
		//console.log(itemsInCart);
		for (var i = 0; i < itemsInCart.length; i++) {
			//alert('item number' + i);
			var rowDiv = document.createElement('div');
			rowDiv.id = 'itemRow' + itemsInCart[i].productId;

			var colxsDiv = document.createElement('div');
			colxsDiv.className = 'col-xs-2';
			rowDiv.appendChild(colxsDiv);

			
			var imgContentDiv = document.createElement('img');
			imgContentDiv.className = 'img-responsive';
			imgContentDiv.src = itemsInCart[i].imagePath;
			colxsDiv.appendChild(imgContentDiv);
			
			
			var colxsProductDiv = document.createElement('div');
			colxsProductDiv.className = 'col-xs-4';
			rowDiv.appendChild(colxsProductDiv);
			
			var productNameDiv = document.createElement('h4');
			productNameDiv.className = 'product-name';
			productNameDiv.textContent = itemsInCart[i].productName;
			colxsProductDiv.appendChild(productNameDiv);
			
			var strongProductName = document.createElement('strong');
			productNameDiv.appendChild(strongProductName);
			
			var h4ProductDesc = document.createElement('h4');
			colxsProductDiv.appendChild(h4ProductDesc);
			
			var smallProductDesc = document.createElement('small');
			smallProductDesc.textContent = itemsInCart[i].productDescription;
			h4ProductDesc.appendChild(smallProductDesc);
			
			var colxsItemDiv = document.createElement('div');
			colxsItemDiv.className = 'col-xs-6';
			rowDiv.appendChild(colxsItemDiv);
			
			 
			var colxsItemCartDiv = document.createElement('div');
			colxsItemCartDiv.className = 'col-xs-6 text-right';
			colxsItemDiv.appendChild(colxsItemCartDiv);
			
			var h6ProductPrice = document.createElement('h6');
			colxsItemCartDiv.appendChild(h6ProductPrice);
			
			var strongProductPrice = document.createElement('strong');
			h6ProductPrice.appendChild(strongProductPrice);
			
			var labelProductPrice = document.createElement('label');
			labelProductPrice.textContent = itemsInCart[i].productPrice;
			strongProductPrice.appendChild(labelProductPrice);
			
			var spanProductPrice = document.createElement('span');
			spanProductPrice.className = 'text-muted';
			strongProductPrice.appendChild(spanProductPrice);
			
			
			var colxsInputDiv = document.createElement('div');
			colxsInputDiv.className = 'col-xs-4';
			rowDiv.appendChild(colxsInputDiv);
			
			var productQuantity = document.createElement('input');
			productQuantity.type = 'text';
			productQuantity.className = 'form-control input-sm';
			productQuantity.id = 'txtQty' + itemsInCart[i].productId;
			colxsItemDiv.appendChild(productQuantity);
			
			var trashButtonDiv = document.createElement('button');
			trashButtonDiv.type = 'button';
			trashButtonDiv.className = 'btn btn-link btn-xs';
			colxsItemDiv.appendChild(trashButtonDiv);
			
			var trashButton = document.createElement('span');
			trashButton.className = 'glyphicon glyphicon-trash';
			trashButtonDiv.appendChild(trashButton); 

			var divBodyCartModal = document.getElementById('divBodyCartModal');
			divBodyCartModal.appendChild(rowDiv);
		}
	}
</script>


<body>

	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4 class="modal-title">Modal Header</h4>
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

							<div id="divBodyCartModal">
								
							</div>
							<!-- end of div body cart modal,end of dynamic content  -->
							<div class="row">
								<div class="text-center">
									<div class="col-xs-9">
										<h6 class="text-right">Added items?</h6>
									</div>
									<div class="col-xs-3">
										<button type="button" class="btn btn-default btn-sm btn-block"
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
					Total <strong>$50.00</strong>
				</h4>
			</div>

			<div class="col-xs-3">
				<button type="button" class="btn btn-success btn-block">Checkout</button>
			</div>

			<div class="col-xs-2">
				<button id="btnRegisterCancel" name="btnRegisterCancel"
					class="btn btn-danger btn-block" data-dismiss="modal">Cancel</button>
			</div>

		</div>
	</div>
	</div>

</body>
</html>