<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing Bean</title>
</head>
<body>
	<center>
		<h2>Using JavaBeans in JSP</h2>
		<jsp:useBean id="test" class="com.jsp.action.TestBean" />
		<jsp:setProperty name="test" property="message" value="Hello JSP.. From .jsp.." />
		<p>Got Message...</p>
		<jsp:getProperty name="test" property="message" />
	</center>
</body>
</html>