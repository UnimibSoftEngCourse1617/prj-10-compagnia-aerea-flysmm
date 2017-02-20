<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<title>FlySMM</title>
</head>
<body>
	<div class="ui stackable inverted menu">
		<div class="item">FltSMM</div>
		<a class="item"> About Us </a> <a class="item"> Jobs </a> <a
			class="item"> Locations </a> <a class="right item"> Sign up </a>
	</div>
	<h1 class="ui header">Add passenger</h1>
	<div class="column">
		<div class="ui raised segment">
			<form method="post" action="GetPassenger" class="ui form">

				<script type="text/javascript">
	var length = '<%=session.getAttribute("passengers")%>';
					for (i = 0; i < length; i++) {
						document.write("					<div class=\"field\">");
						document
								.write("						<label>Name<\/label> <input type=\"text\" name=\"name"
										+ i + "\"");
						document.write("							placeholder=\"name\">");
						document.write("					<\/div>");
						document.write("					<div class=\"field\">");
						document
								.write("						<label>Surname<\/label> <input type=\"text\" name=\"surname"
										+ i + "\"");
						document
								.write("							placeholder=\"surname\" required>");
						document.write("					<\/div>");
						document.write("					<div class=\"field\">");
						document
								.write("						<label>Fiscal code<\/label> <input type=\"text\" name=\"fiscalCode"
										+ i + "\"");
						document
								.write("							placeholder=\"fiscal code\" required>");
						document.write("					<\/div>");
						document.write("					<div class=\"field\">");
						document
								.write("						<label>Date of birth<\/label> <input type=\"date\" name=\"dateOfBirth"
										+ i + "\"");
						document
								.write("							placeholder=\"yyyy-mm-dd\" required>");
						document.write("					<\/div>");
						document.write("					<div class=\"field\">");
						document
								.write("						<label>Document<\/label> <input type=\"text\" name=\"docCode"
										+ i + "\"");
						document
								.write("							placeholder=\"document code\" required>");
						document.write("					<\/div>");
						document.write("					<div class=\"field\">");
						document
								.write("						<label>Document type<\/label> <select name=\"docType"
										+ i + "\"");
						document
								.write("							class=\"ui compact selection dropdown\">");
						document
								.write("							<option value=\"None\">Document type<\/option>");
						document
								.write("							<option value=\"Identity card\">Identity card<\/option>");
						document
								.write("							<option value=\"Passport\">Passport<\/option>");
						document.write("						<\/select>");
						document.write("					<\/div>");
						document.write("					<div class=\"field\">");
						document
								.write("						<label>Baggage<\/label> <select name=\"baggage"
										+ i + "\"");
						document
								.write("							class=\"ui compact selection dropdown\">");
						document
								.write("							<option value=\"None\">Select your baggage<\/option>");
						document
								.write("							<option value=\"Normal\">Normal<\/option>");
						document
								.write("							<option value=\"Sport\">Sport<\/option>");
						document
								.write("							<option value=\"Huge\">Huge<\/option>");
						document.write("						<\/select>");
						document.write("					<\/div>");

					}
				</script>
				<input class="ui blue submit button" type="submit"
					value="Add passenger"> <input type="hidden" name="command"
					value="AddPassenger" />
			</form>
</body>
</html>
