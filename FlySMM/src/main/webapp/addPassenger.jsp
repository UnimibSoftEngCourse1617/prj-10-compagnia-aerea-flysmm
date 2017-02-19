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
					action="./GetPassenger">
					<h1 class="ui header">Add passenger</h1>
					<div class="field">
						<label>Name</label> <input type="text" name="name"
							placeholder="name">
					</div>
					<div class="field">
						<label>Surname</label> <input type="text" name="surname"
							placeholder="surname">
					</div>
					<div class="field">
						<label>Fiscal code</label> <input type="text" name="fiscalCode"
							placeholder="fiscal code">
					</div>
					<div class="field">
						<label>Date of birth</label> <input type="date" name="dateOfBirth"
							placeholder="yyyy-mm-dd">
					</div>

					<!-- 	<div class="field">
						<label>Gender</label> <select
							class="ui compact selection dropdown">
							<option selected="type" value="1">Male</option>
							<option value="2">Female</option>
							<option value="3">Kid</option>
						</select>
					</div>
					<div class="field">
						<label>Baggage</label> <select
							class="ui compact selection dropdown">
							<option selected="" value="1">No</option>
							<option value="2">Sport</option>
							<option value="3">Normal</option>
						</select>
					</div> -->
					<div class="field">
						<label>Document</label> <input type="text" name="docCode"
							placeholder="document code">
					</div>
					<div>
						<select name="docType">
							<option value="None">Document type</option>
							<option value="Identity card">Identity card</option>
							<option value="Passport">Passport</option>
						</select>
					</div>
					<div>
						<select name="baggage">
							<option value="None">Select your baggage</option>
							<option value="Normal">Normal</option>
							<option value="Sport">Sport</option>
							<option value="Huge">Huge</option>

						</select>
					</div>


					<input type=submit name="command" value="AddPassenger">

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
