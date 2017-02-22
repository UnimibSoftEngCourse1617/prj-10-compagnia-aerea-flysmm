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
		<%-- <a href="index.jsp" class="item"> <form >
			Logout<input type="hidden" name="${customer}" value="logout"/>
			<%
				request.getSession().removeAttribute("customer");
			%>
		</form></a> --%>
	</div>

	<h1 class="ui center aligned header">
		HOME
		<div class="sub header">Welcome to our home page for users, enjoy it.</div>
	</h1>

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
						class="ui green submit button" type="submit" value="fidelity">

				</form>
				<form name="listBook" method="post" action="./GetBook">
					<button class="ui grey button">
						<i class="plane icon"></i> See Your Flights
					</button>
					<input type="hidden" name="command" value="GetBook">
				</form>
				<form method="post" action="./GetPromotion">
					<button class="ui red button">
						<i class="gift icon"></i> See Promotions
					</button>
					<input type="hidden" name="command" value="Promo">
					<input type="hidden" name="customertype" value="nope">
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