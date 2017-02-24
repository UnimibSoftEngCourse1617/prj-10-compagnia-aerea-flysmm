<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<font face="Arial"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<%
			if (request.getSession().getAttribute("customer") == null) {
		%>

		<a href="loginPage.html" class="right item"> Login </a>

		<%
			} else {
		%>
		<%
			if (request.getSession().getAttribute("customer").getClass().toString().matches("class customer.FidelityCustomer")){
				%> <a href="homeFidelityCustomer.jsp" class="right item"> Home </a>
	<%}else{ %>
		<a href="homeCustomer.jsp" class="right item"> Home </a><%} %>

		<!-- <a href="./logoutServlet " class="right item"> Home </a> --> <a
			href="./logoutServlet " class="right item"> Log out </a>

		<%
			}
		%>
	<form name="newPaymentMethod" action="./AddNewPaymentMethod" method="post">
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
			<label>Data di scadenza</label>
			<input name="expiredDate" type="date">
		</div>
		<div class="field">
			<label>street</label> <input name="street" type="text">
		</div>
		<input type="hidden" name="command" value="Payment">
		<input type="submit" name="invia" value="invia">
	</form>
</body>
</html>