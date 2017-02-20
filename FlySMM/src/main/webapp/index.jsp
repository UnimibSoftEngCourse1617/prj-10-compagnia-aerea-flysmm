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
<script>
	function viewReturnDate() {

		document.getElementById('returnDate').style.display = '';
	};

	function hideReturnDate() {
		document.getElementById('returnDate').style.display = 'none';
	};
</script>
<script>
	$.validate({
		lang : 'it'
	});
</script>
</head>


<body>


	<div class="ui stackable inverted menu">
		<a class="item">FlySMM</a> <a class="item"> About Us </a> <a
			class="item"> Jobs </a> <a class="item"> Locations </a> <a
			href="loginPage.html" class="right item"> Sign up </a>
	</div>


	<!-- INIZIO area dedicata alla ricerca di un volo -->


	<div class="ui two column grid">
		<div class="column">
			<div class="ui raised segment">
				<div class="field">
					<div class="ui buttons">
						<button onclick="viewReturnDate()" class="ui mini button">Andata
							e Ritorno</button>
						<button onclick="hideReturnDate()" class="ui mini button">Solo
							Andata</button>
					</div>
				</div>
				<form class="ui form" name="fSearchFly" method="post"
					action="./GetDepartureFlight">
					<div class="field">
						<label>Volo da</label> <input name="aDeparture" type="text"
							required="required" pattern="[a-zA-z]*">
					</div>

					<div class="field">
						<label>Volo per</label> <input name="aArrival" type="text"
							required="required"></input>
					</div>

					<div class="three fields">

						<div class="field">
							<label>Partenza</label> <input name="dDate" type="date"
								data-validation="date" data-validation-format="yyyy-mm-dd"
								required="required">
						</div>

						<div id="returnDate" style='' class="field">
							<label>Ritorno</label> <input id="btnreturnDate" name="rDate"
								type="date" data-validation="date"
								data-validation-format="yyyy-mm-dd">
						</div>

						<div class="field">
							<label>Persone</label> <select name="passengers"
								class="ui compact selection dropdown">
								<option value="1" selected>1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
						<input type="hidden" name="command" value="Sale">
					</div>
					<input type="submit" value="Cerca" class="ui submit green button" />
				</form>
				<script
					src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
				<script
					src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js">
					
				</script>
			</div>
		</div>
	</div>
	<!-- FINE area dedicata alla ricerca di un volo -->

	<a href="./AppCustomer">ProvaCustomer</a>

	<a href="./AppBook">ProvaBook</a>
  
  <form  method="post" action="./GetPromotion">
    	<button class="ui red button" name="command" value="Promo">
  			<i class="gift icon"></i>
  			See Promotions
		</button>
	</form>
</body>
</html>
