<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<font face="Arial" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/css/semantic.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/javascript/semantic.js"></script>

<title>FlySMM</title>
</head>
<body>
	<div class="ui stackable inverted menu">

		<div href="index.jsp" class="item">FlySMM</div>

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
	<h2>Do you accept to change your flight parameters?</h2>
	<div class="ui two column grid">
		<div class="column">
			<form method="post" action="./PayEdit">

				<label>${debit}</label> <input class="ui green submit button"
					type="submit" name="submit" value="confirm"> <input
					type="hidden" name="command" value="Edit">
			</form>

		</div>
		<div class="column">
			<form action="./GetBook" method="post">
				<input class="ui red submit button" type="submit" name="cancel"
					value="cancel"> <input type="hidden" name="command"
					value="GetBook">
			</form>

		</div>
	</div>
</body>
</html>