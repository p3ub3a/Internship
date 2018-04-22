<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page errorPage="error.jsp" %>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My basket</title>
	</head>

	<body>
		<h3>${message}</h3>
		
		<c:if test="${showList==true}">
			<c:forEach var="i" begin="0" end="${productsInBasket.size() - 1}">
			
				<c:set var="productInBasket" scope="page" value="${productsInBasket.get(i)}"/>  
				  
			   	<div>
			   		<b>${productInBasket.label}</b>
			   		<font color="Crimson"><b><i>x${productInBasket.quantity}</i></b></font><br/>
			   		<span>${productInBasket.description}</span>
				 
				   	<form action = "basket" method = "post" accept-charset="utf-8">
				   		<input name="id" value="${productInBasket.id}" type="hidden">
				   		<input name="quantity" value="${productInBasket.quantity}" type="hidden">
				   		<input name="delete" type="submit" value="Remove item">
				   	</form>
			   	</div>
			</c:forEach> 
			<p> Total items: ${totalItems}</p> 
		</c:if>
		
		<br/>
		<a href="<c:url value="/" />"><button>->main page<-</button></a>
		<a href="<c:url value="/goods" />"><button>->goods page<-</button></a>
	</body>
</html>