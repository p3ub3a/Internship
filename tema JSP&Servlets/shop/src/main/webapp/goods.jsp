<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page errorPage="error.jsp" %> 

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Marketplace</title>
	</head>

	<body>
		<h3>Available offerings:</h3>
		
		<form action = "goods" method = "post" accept-charset="utf-8">
			<select name="selection">
				<c:forEach var="i" begin="0" end="${products.size() - 1}">
					<c:set var="product" scope="page" value="${products.get(i)}"/> 
			  		<option name="${product.label}" value="${product.id}">${product.label}</option>	
			  	</c:forEach> 
			</select>
			<input type="submit" value="Add to basket">
		</form>
		
		<br/>
		<a href="<c:url value="/" />">Go to the main page</a>
	</body>
</html>