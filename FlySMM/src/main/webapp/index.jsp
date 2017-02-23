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
<script>
	function viewReturnDate() {

		document.getElementById('returnDate').style.display = '';
	};

	function hideReturnDate() {
		document.getElementById('returnDate').style.display = 'none';
	};
</script>
<title>FlySMM</title>

</head>

<body>
	<div class="ui stackable inverted menu">

		<a href="index.jsp" class="item">FlySMM</a> <a class="item"> About Us </a> <a
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
	
	<!-- INIZIO area dedicata alla ricerca di un volo -->
	<div class="ui two column grid">
		<div class="column">
			<div class="ui raised segment">

				<form class="ui form" name="fSearchFly" method="post"
					action="./GetDepartureFlight">

					<div class="field">
						<div class="ui buttons">
							<div onclick="viewReturnDate()" class="ui green basic button">Andata
								e Ritorno</div>
							<div onclick="hideReturnDate()" class="ui red basic button">Solo
								Andata</div>
						</div>
					</div>

					<div class="field">
						<label>Volo da</label> <input name="aDeparture" type="text"
							placeholder="malpensa" required>
					</div>

					<div class="field">
						<label>Volo per</label> <input name="aArrival" type="text"
							placeholder="fiumicino" required></input>
					</div>

					<div class="three fields">

						<div class="field">
							<label>Partenza</label> <input name="dDate" type="date"
								placeholder="yyyy-mm-dd" required>
						</div>

						<div id="returnDate" style='' class="field">
							<label>Ritorno</label> <input id="btnreturnDate" name="rDate"
								type="date" placeholder="yyyy-mm-dd">
						</div>

						<div class="field">
							<label>Persone</label> <select name="passengers"
								class="ui compact selection dropdown">
								<option selected="true" value="1">1</option>
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
			</div>
		</div>
	</div>
	<!-- FINE area dedicata alla ricerca di un volo -->

</body>
</html>
