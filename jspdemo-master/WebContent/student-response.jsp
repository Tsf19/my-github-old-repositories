<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation Title</title>
</head>
<body>
	<p>
		The Student is Confirmed: 
		<%= request.getParameter("firstName")%>
		<%= request.getParameter("lastName")%>
		<br /><br />
		The Student's Country is: 
		<%= request.getParameter("country1") %>
		<%= request.getParameter("country2") %>
	</p>

<%-- ALTERNATE WAY : Only Used for Displaying Form Data --%>

	<p>
		The Student is Confirmed : ${param.firstName} ${param.lastName}
		<br /><br />
		The Student's Country is: ${param.country1} ${param.country2}
	</p>
	
	<p>
		The Student's Favorite Programming Language is : <%= request.getParameter("favLang") %><br />
		The Student's Favorite Programming Language is : ${param.favLang}
	</p>
	
	<p>
		The Student's Favorite Programming Languages is :
		<% String[] langs = request.getParameterValues("favLangs");
			if (langs != null) { //Handeling If the user doesn't select a checkbox
				for(String tempLang : langs) {
					out.println("<li>" + tempLang + "</li>");
				}
			}
		
		%><br />
	</p>
</body>
</html>