<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form class="ui form" name="fSearchFly" method="post"
		action="./GetNewCustomer">

		<div class="field">
			<label>id</label> <input type="long" name="id"
				placeholder="First Name">
		</div>
		<div class="field">
			<label>name</label> <input type="text" name="name"
				placeholder="Last Name">
		</div>
		<div class="field">
			<label>Last name</label> <input type="text" name="surname"
				placeholder="Last Name">
		</div>
		<div class="field">
			<label>email</label> <input type="email" name="email"
				placeholder="Last Name">
		</div>
		<div class="field">
			<label>password</label> <input type="password" name="password"
				placeholder="Last Name">
		</div>
		<div class="field">
			<label>phone Number</label> <input type="text" name="phoneNumber"
				placeholder="Last Name">
		</div>
		<div class="field">
			<label>date of birth</label> <input type="date" name="dateOfBirth"
				placeholder="Last Name">
		</div>
		<div class="field">
			<div class="ui checkbox">
				<input type="checkbox" tabindex="0" class="hidden"> <label>I
					agree to the Terms and Conditions</label>
			</div>
		</div>
		
			<input type=submit name="command" value="NewCustomer">Submit
		
	</form>
</body>
</html>