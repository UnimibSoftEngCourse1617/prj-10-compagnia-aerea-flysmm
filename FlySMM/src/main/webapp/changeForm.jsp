<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<font face="Arial" />
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
	<div class="ui two column grid">
		<div class="column">
			<form class="ui form" action="./EditSale" method="post">
				<input type="hidden" name="command" value="Edit" />
				<div class="field">
					<label>Choose new date</label> <input type="date" name="newDate">
				</div>
				<input class="ui blue submit button" type="submit" name="submit"
					value="submit">
			</form>
		</div>
	</div>


</body>
</html>