<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		//Default is Java
		String favLang = "Java";
	
		//Get The Cookies from Browser
		Cookie[] cookies = request.getCookies();
		
		//Find Out favLang Cookie
		if(cookies != null) {
			for(Cookie tempCookie : cookies) {
				if("favLangCookie".equals(tempCookie.getName())) {
					//favLang = tempCookie.getValue();
					favLang = URLDecoder.decode(tempCookie.getValue(),"UTF-8");
					break;
				}
			}
		}
	%>
	
	<h4>New Books for <%= favLang %></h4>
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>
	<h4>Latest News Report for <%= favLang %></h4>
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>
	<h4>Hot Jobs for <%= favLang %></h4>
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>
	<hr>
	<a href="cookies_personalize_form.html">Personalize This Page</a>
</body>
</html>