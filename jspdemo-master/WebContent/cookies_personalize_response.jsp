<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
	<%
		//Read Form Data
		String favLang = request.getParameter("favoriteLanguage");
		
   		// encode cookie data ... handle case of languages with spaces in them
		favLang = URLEncoder.encode(favLang, "UTF-8");
	
		//Create the Cookie
		Cookie cookie = new Cookie("favLangCookie",favLang);
				
		//Set the MaxAge
		cookie.setMaxAge(60*5); //5 Minutes
		
		//Send Cookie to Browser
		response.addCookie(cookie);
	%>
	<h4>Thanks! We Set your favorite language to: ${param.favoriteLanguage}</h4>
	<h4>Thanks! We Set your favorite language to: <%= request.getParameter("favoriteLanguage") %></h4>
	<br /><br />
	
	<a href="cookies_homepage.jsp">Return to HomePage.</a>
</body>
</html>