<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body background="gradient-wallpapers-2.jpg">
	


<center>
		<div style="height: 623px; width: 411px">
			<form action="Register" method="post"
				style="height: 501px; width: 387px">
				<center>
					<h1>Registration Form</h1>
					</br> <input type="email" placeholder="Email" name="email" size=20
						style="width: 352px; height: 33px"> </br> </br> <input type="text"
						placeholder="Username" name="username" size=20
						style="width: 353px; height: 33px"></br> </br> <input type="text"
						placeholder="First Name" name="fname" size=20
						style="width: 353px; height: 33px"></br> </br> <input type="text"
						placeholder="Last Name" name="lname" size=20
						style="width: 353px; height: 33px"></br> <br> <input
						type="Password" placeholder="Password " name="pass" size=20
						style="width: 353px; height: 33px"><br><br>

					<center>
						<button type="submit"  size=20 style="width: 353px; height: 33px;">Create Account</button>
					</center>
					<%
						String msg = (String) request.getAttribute("msg");
						if (msg == null) {
							out.println("");
						}

						else {
							out.println("<font color='#FF0000'><br>" + msg + "</font>");
						}
					%>

				</center>
			</form>
		</div>

	</center>
</body>
</html>