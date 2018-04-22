<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Online shop</title>
	</head>
	
	<body>
		<h4><font color="Crimson">Hey, this is the main page, you may:</font></h4>
		<a href="<c:url value="/goods" />">See available products</a><br/>
		<a href="<c:url value="/basket" />">Go to basket</a>
	</body>
	
</html>