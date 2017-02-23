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
	<form name="newPaymentMethod" action="#" method="post">
		<div class="field">
			<label></label>
			<input name="" type="text">
		</div>
		
		<div class="field">
			<label>Numero Carta</label>
			<input name="NCard" type="text">
		</div>
		
		<div class="field">
			<label>cvv</label>
			<input name="cvv" type="text">
		</div>
		
		<div class="field">
			<label>owner</label>
			<input name="owner" type="text">
		</div>
		
		<div class="field">
			<label>Data di scadenza</label>
			<input name="expiredDate" type="text">
		</div>
		
		<div class="field">
			<label>street</label>
			<input name="street" type="text">
		</div>
		
		<!-- INIZIO PARTE DEDICATA ALL'INDIRIZZO -->
		<div class="field">
			<label>Numero civico</label>
			<input name="street" type="text">
		</div>
		
		<div class="field">
			<label>cap</label>
			<input name="cap" type="text">
		</div>
		
		<div class="field">
			<label>city</label>
			<input name="city" type="text">
		</div>
		
		<div class="field">
			<label>country</label>
			<input name="country" type="text">
		</div>
		<!-- FINE PARTE DEDICATA ALL'INDIRIZZO -->
	</form>
</body>
</html>