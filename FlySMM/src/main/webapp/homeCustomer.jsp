<%@page import="customer.Customer"%>
<html>
<head>
<!-- Inizio sezione per Semantic ui -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/css/semantic.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/javascript/semantic.js"></script>
<!-- Fine sezione per Semantic ui -->
<title>Home Customer</title>
</head>
<body>

	<div class="ui stackable inverted menu">
		<a href="index.jsp" class="item">FlySMM</a>
		<a class="item"> About Us </a>
		<a class="item"> Jobs </a>
		<a class="item"> Locations </a>
	</div>

	<div class="ui two column grid">
		<div class="column">
			<div class="ui raised segment">
				<form class="ui form" name="myObject" method="post"
					action="./GetNewFidelityCustomer">
					<h1 class="ui header">Home</h1>

					<div class="field">
						Name : ${customer.name}<br> Surname :${customer.surname}<br>
						Email :${customer.email}<br> Phone number
						:${customer.phoneNumber}<br> 
					</div>

					Begin a fidelity Customer <br> <input
						class="ui blue submit button" type="submit" value="fidelity">
						<input type="hidden" name="myObjectId" value="${myObjectId}" />

				</form>
			</div>
		</div>
		<div class="column">
			<img class="ui rigth floated circular image"
				src="images/flysmmLogo.jpg" style="float: right">
		</div>

	</div>
</body>
</html>