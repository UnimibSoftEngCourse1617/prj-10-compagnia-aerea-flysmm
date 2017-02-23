<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="sale.Flight"%>
<%@page import="java.util.List"%>


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

<body background="images/Error.jpg">
	<div class="ui stackable inverted menu">
		<a href="index.jsp" class="item">FlySMM</a> <a class="item"> About
			Us </a> <a class="item"> Jobs </a> <a class="item"> Locations </a> <a
			href="loginPage.html" class="right item"> Login </a>
	</div>
	<div
		style="position: relative; width: 600px; height: 550px;">
		<div style="position: absolute; bottom: 5px;">
			<h3><c:out value="${message}"></c:out></h3>
		</div>
	</div>
</body>
</html>