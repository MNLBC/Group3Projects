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


<script>
	$(document).ready(
			function() {


							$.ajax({
								url : 'user',
								data : {
									method : 'userTrans'
								},
								method : 'POST',
								complete : function(responseText) {
									displayResults(responseText);

								}

							});

						});


	function displayResults(responseText) {
		var responseData = JSON.parse(responseText.responseText).data;
		console.log(responseData);
		var userTrans = responseData.orders;
		

		for (var i = 0; i < userTrans.length; i++) {
			//alert('item number' + i);
			var table = document.getElementById('transTable');
			var rowDiv = document.createElement('tr');
			rowDiv.id = 'itemRow' + userTrans[i].orderId;
			table.appendChild(rowDiv);
			
			var colDiv = document.createElement('td');
			var txtId =document.createTextNode(userTrans[i].orderId);
			
			
			var colDiv1 = document.createElement('td');
			var txtDate =document.createTextNode(userTrans[i].orderDate);
			
			
			var colDiv2 = document.createElement('td');
			var txtCost =document.createTextNode('$'+userTrans[i].totalCost);
			
			
			var colDiv3 = document.createElement('td');
			var status=document.createTextNode(userTrans[i].orderStatus);
			
			
			colDiv.appendChild(txtId);
			colDiv1.appendChild(txtDate);
			colDiv2.appendChild(txtCost);
			colDiv3.appendChild(status);
			
			rowDiv.appendChild(colDiv);
			rowDiv.appendChild(colDiv1);
			rowDiv.appendChild(colDiv2);
			rowDiv.appendChild(colDiv3);
		}

		return;
	};
</script>

</head>
<body>

	<header class="header-login-signup">
	<div class="header-limiter">
		<center>
			<h2>
				<im src="resources/cart.png" style="width: 58px; height: 47px;"><a
					href="MainDynamic.jsp"> Kanen<span>Online Shopping</span>
				</a>
				<hr width="700" align="center" color="white" style="width: 778px;">

			</h2>
		</center>


	</div>
	</header>
	<center>
		<h3>Your Transactions:</h3>
	</center>


	<table class="table table-bordered table-hover" >
		<thead>
			<tr>
				<th>Order ID</th>
				<th>Order Date</th>
				<th>Total Cost</th>
				<th>Order Status</th>
			</tr>
		</thead>
		<tbody id="transTable">
			

		</tbody>
	</table>

</body>
</html>