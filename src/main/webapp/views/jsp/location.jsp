<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.security.Principal" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
</head>
<body>
	Welcome <%=((Principal)request.getAttribute("principal")).getName()%> <br>
	Ap version is ${version} <br>
	${greet}<br>
	
	<spring:message code="good.morning"/>
</body>
</html>