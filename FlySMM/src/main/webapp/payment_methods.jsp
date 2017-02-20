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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table class="ui celled table">
    <thead>
      <tr>
        <th>idAddress</th>
        <th>street</th>
        <th>street_number</th>
        <th>cap</th>
        <th>city</th>
        <th>country</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${payment_method}" var="payment_method">
        <tr>
          <td>${payment_method.idAddress}</td>
          <td>${payment_method.street}</td>
          <td>${payment_method.street_number}</td>
          <td>${payment_method.cap}</td>
          <td>${payment_method.city}</td>
          <td>${payment_method.country}</td>
        </tr>
      </c:forEach>
    </tbody>
    <tfoot></tfoot>
  </table>
</body>
</html>