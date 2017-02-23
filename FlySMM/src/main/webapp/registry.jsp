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

</head>
<body>
	<div class="ui stackable inverted menu">
		<a class="item">FlySMM</a> <a class="item"> About Us </a> <a
			class="item"> Jobs </a> <a class="item"> Locations </a>
		<%
			if (request.getSession().getAttribute("customer") == null) {
		%>

		<a href="loginPage.html" class="right item"> Login </a>

		<%
			} else {
		%>

		<a href="./logoutServlet " class="right item"> Log out </a>

		<%
			}
		%>
	</div>

	<div class="ui two column grid">
		<div class="column">
			<div class="ui raised segment">
				<form class="ui form" name="fSearchFly" method="post"
					action="./GetNewCustomer">
					<h1 class="ui header">Registry page</h1>

					<div class="field">
						<label>Name</label> <input type="text" name="name"
							placeholder="name" required>
					</div>
					<div class="field">
						<label>Surname</label> <input type="text" name="surname"
							placeholder="surname" required>
					</div>
					<div class="field">
						<label>Street</label> <input type="text" name="street"
							placeholder="via Roma" required>
					</div>
					<div class="field">
						<label>Street number</label> <input type="text"
							name="Street_number" placeholder="50" required>
					</div>
					<div class="field">
						<label>CAP</label> <input type="text" name="cap"
							placeholder="20090" required>
					</div>
					<div class="field">
						<label>City</label> <input type="text" name="city"
							placeholder="Milan" required>
					</div>
					<div class="field">
						<label>Country</label> <input type="text" name="country"
							placeholder="Italy" required>
					</div>
					<div class="field">
						<label>Email</label> <input type="email" name="email"
							placeholder="example@gmail.com" required>
					</div>
					<div class="field">
						<label>Password</label> <input type="password" name="password"
							placeholder="password" required>
					</div>
					<div class="field">
						<label>Phone Number</label> <input type="text" name="phoneNumber"
							placeholder="phone number">
					</div>
					<div class="field">
						<label>Date of birth</label> <input type="date" name="dateOfBirth"
							placeholder="yyyy-mm-dd">
					</div>

					<input class="ui blue submit button" type="submit" value="Registry">
					<input type="hidden" name="command" value="NewCustomer" />
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
