
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/css/semantic.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/javascript/semantic.js"></script>

</head>


<body>
	<script>
		function viewReturnDate() {

			document.getElementById('returnDate').style.display = '';
		};

		function hideReturnDate() {
			document.getElementById('returnDate').style.display = 'none';
		};
	</script>

	<div class="ui stackable inverted menu">
		<div class="item">FltSMM</div>
		<a class="item"> About Us </a> <a class="item"> Jobs </a> <a
			class="item"> Locations </a> <a class="right item"> Sign up </a>
	</div>


	<!-- INIZIO area dedicata alla ricerca di un volo -->


	<div class="ui two column grid">
		<div class="column">
			<div class="ui raised segment">
				<form class="ui form" name="fSearchFly" method="post" action="/GetDepartureFlight">
					<div class="field">
						<div class="ui buttons">
							<button onclick="viewReturnDate()" class="ui mini button">Andata
								e Ritorno</button>
							<button onclick="hideReturnDate()" class="ui mini button">Solo
								Andata</button>
						</div>
					</div>

					<div class="field">
						<label>Volo da</label> <input name="aDeparture" type="text">
					</div>

					<div class="field">
						<label>Volo per</label> <input name="aArrival" type="text"></input>
					</div>

					<div class="three fields">

						<div class="field">
							<label>Partenza</label> <input name="dDate" type="text">
						</div>

						<div id="returnDate" style='' class="field">
							<label>Ritorno</label> <input id="btnreturnDate" name="rDate"
								type="text">
						</div>

						<div class="field">
							<label>Persone</label> <select
								class="ui compact selection dropdown">
								<option selected="" value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
						<input type="hidden" name="command" value="Sale">
					</div>
					<div class="ui submit green button">Cerca</div>
				</form>
			</div>
		</div>
	</div>
	<!-- FINE area dedicata alla ricerca di un volo -->
	<a href="./AppPromotion">Prova_Promotion</a>
</body>
</html>
