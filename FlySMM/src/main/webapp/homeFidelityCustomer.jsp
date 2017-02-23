<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<font face="Arial"/>
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
<title>Home Fidelity Costumer</title>
</head>
<body>
	<div class="ui stackable inverted menu">
		<a href="index.jsp" class="item">FlySMM</a>
		<a class="item"> About Us </a>
		<a class="item"> Jobs </a> 
		<a class="item"> Locations </a> 
		<a href="loginPage.html" class="right item"> Login </a>
	</div>

	<h1 class="ui center aligned header">
		<img class="ui image " style="margin: 0 auto;"
			src="images/fidelity.png"> HOME
		<div class="sub header">Welcome to our home page for fidelity users, enjoy it.</div>
	</h1>

	<div class="ui two column very relaxed grid">
		<div class="column">
			<div class="ui raised segment">
				<form class="ui form" name="myObject" method="post"
					action="./GetNewFidelityCustomer">
					<h1 class="ui header">Personal Data</h1>

					<div class="field">
						Name : ${customer.name}<br> Surname : ${customer.surname}<br>
						Email : ${customer.email}<br> Phone number :
						${customer.phoneNumber}<br> Start Date Program :
						${customer.startDate}<br> Latest Book :
						${customer.lastestBook}<br> Points Accumulated <i
							class="star icon"></i> : ${customer.point}<br>
					</div>

				</form>
			</div>
		</div>
		<div class="column">
			<img class="ui rigth floated circular image"
				src="images/flysmmLogo.jpg" style="float: right">
		</div>
	</div>
	<div class="ui three column very relaxed grid">
		<div class="column">
			<form name="listBook" method="post" action="./GetBook">
				<button class="ui green button">
					<i class="tags icon"></i> See Your Books
				</button>
				<input type="hidden" name="command" value="GetBook">
			</form>
		</div>
		<div class="column">
			<form method="post" action="./GetPromotion">
				<button class="ui grey button" name="command" value="Promo">
					<i class="plane icon"></i> See Your Flights
				</button>
			</form>
		</div>
		<div class="column">
			<form method="post" action="./GetPromotion">
				<button class="ui red button">
					<i class="gift icon"></i> See Promotions
				</button>
				<input type="hidden" name="command" value="Promo">
				<input type="hidden" name="customertype" value="fidelity">
			</form>
		</div>
	</div>
</body>

</html>