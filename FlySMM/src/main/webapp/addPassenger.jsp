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
	<p id="pass"></p>
	<script>
		var text = "";
		var length = '<%=session.getAttribute("passengers")%>';
		for (i = 0; i < length; i++) {
			text += "<div class=\"ui two column grid\"> <div class=\"column\"> <div class=\"ui raised segment\"> <form class=\"ui form\" name=\"fSearchFly\" method=\"post\" action=\".\/GetPassenger\"> <div class=\"field\"> <label>Name<\/label> <input type=\"text\" name=\"name"+i"\" placeholder=\"name\" required> <\/div> <div class=\"field\"> <label>Surname<\/label> <input type=\"text\" name=\"surname"+i"\" placeholder=\"surname\" required> <\/div> <div class=\"field\"> <label>Fiscal code<\/label> <input type=\"text\" name=\"fiscalCode"+i"\" placeholder=\"fiscal code\" required> <\/div> <div class=\"field\"> <label>Date of birth<\/label> <input type=\"date\" name=\"dateOfBirth"+i"\" placeholder=\"yyyy-mm-dd\" required> <\/div> <div class=\"field\"> <label>Document<\/label> <input type=\"text\" name=\"docCode"+i"\" placeholder=\"document code\" required> <\/div> <div class=\"field\"> <label>Document type<\/label> <select name=\"docType"+i"\" class=\"ui compact selection dropdown\"> <option value=\"None\">Document type<\/option> <option value=\"Identity card\">Identity card<\/option> <option value=\"Passport\">Passport<\/option> <\/select> <\/div> <div class=\"field\"> <label>Baggage<\/label> <select name=\"baggage"+i"\" class=\"ui compact selection dropdown\"> <option value=\"None\">Select your baggage<\/option> <option value=\"Normal\">Normal<\/option> <option value=\"Sport\">Sport<\/option> <option value=\"Huge\">Huge<\/option> <\/select> <\/div>  <\/form> <\/div> <\/div>";
		}
		document.getElementById("pass").innerHTML = text;
	</script>
	<input class="ui blue submit button" type="submit"
		value="Add passenger">
	<input type="hidden" name="command" value="AddPassenger" />
	<div class="column">
		<img class="ui rigth floated circular image"
			src="images/flysmmLogo.jpg" style="float: right">
	</div>
</body>
</html>
