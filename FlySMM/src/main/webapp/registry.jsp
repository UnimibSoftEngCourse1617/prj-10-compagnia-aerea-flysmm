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
	</div>

	<div class="ui two column grid">
		<div class="column">
			<div class="ui raised segment">
				<form class="ui form" name="fSearchFly" method="post"
					action="./GetNewCustomer">
					<h1 class="ui header">Registry page</h1>
					<div class="field">
						<label>id</label> <input type="long" name="id">
					</div>
					<div class="field">
						<label>Name</label> <input type="text" name="name"
							placeholder="name">
					</div>
					<div class="field">
						<label>Surname</label> <input type="text" name="surname"
							placeholder="surname">
					</div>
					<div class="field">
						<label>Email</label> <input type="email" name="email"
							placeholder="email">
					</div>
					<div class="field">
						<label>Password</label> <input type="password" name="password"
							placeholder="password">
					</div>
					<div class="field">
						<label>Phone Number</label> <input type="text" name="phoneNumber"
							placeholder="phone number">
					</div>
					<div class="field">
						<label>Date of birth</label> <input type="date" name="dateOfBirth"
							placeholder="yyyy-mm-dd">
					</div>
					<div class="field">
						<div class="ui checkbox">
							<input type="checkbox" tabindex="0" class="hidden"> <label>I
								agree to the Terms and Conditions</label>
						</div>
					</div>

					<input type=submit name="command" value="NewCustomer">Submit

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
