<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<form method="post" action="./PayEdit"  >
		<label>accetti di cambiari il parametri del tuo volo?</label> 
		<label>${debit}</label>
		<input type="submit" name="submit" value="confirm">
		<input type="hidden" name="command" value="Edit">
	</form>
	<form action="./GetBook" method="post">
		<input type="submit" name="cancel" value="cancel">
		<input type="hidden" name="command" value="GetBook"> 
	</form>

</body>
</html>