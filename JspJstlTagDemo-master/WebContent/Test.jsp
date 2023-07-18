<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TestJsp</title>
</head>
<body>
	<c:set var="stuff" value="<%= new java.util.Date() %>" />
	
	Time on the server is ${stuff}
	
</body>
</html>