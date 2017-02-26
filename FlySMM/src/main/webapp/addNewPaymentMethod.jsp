<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="sale.Flight"%>
<%@page import="java.util.List"%>

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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<div class="ui stackable inverted menu">

		<a href="index.jsp" class="item">FlySMM</a>
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

				<form name="newPaymentMethod" class="ui form"
					action="./AddNewPaymentMethod" method="post">
					<div class="fields">
						<div class="field">
							<label>Numero Carta</label> <input name="NCard" type="text">
						</div>
						<div class="field">
							<label>cvv</label> <input name="cvv" type="text">
						</div>
						<div class="field">
							<label>owner</label> <input name="owner" type="text">
						</div>
						<div class="field">
							<label>Data di scadenza</label> <input name="expiredDate"
								type="date">
						</div>
						<div class="field">
							<label>street</label> <input name="street" type="text">
						</div>
					
						<input type="hidden" name="command" value="Payment"> <input
								class="ui red button" type="submit" name="invia" value="invia">
					</div>
				</form>
			</div>
		</div>
</body>
</html>