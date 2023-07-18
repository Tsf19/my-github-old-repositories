<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-Do List</title>
</head>
<body>

	<!-- STEP 1. Create a HTML Form -->
	<form action="Temp.jsp">
		<label>Add New Item: </label> <input type="text" autofocus name="theItem" />
		<br /> <br />
		<input type="submit" value="ADD" />
		<br /> <br />
	</form>

	<!-- STEP 2. Add new Item to "To DO List" -->
	<%
		//Get the "To Do items" from the session
		List<String> items = (List<String>)(session.getAttribute("myToDoList"));

		//If the "To Do items" doesn't exist, then create one
		if (items == null) {
			items = new ArrayList<String>();
			session.setAttribute("myToDoList", items);
		}

		//See if there is a Form data to add
		String theItem = request.getParameter("theItem");
		if (theItem != null) {
			items.add(theItem);
		}
	%>

	<!-- STEP3. Display all "To Do" item from session -->
	<hr> <!--Use the <hr> tag to define a thematic change in the content: -->
	<b>To List Items:</b> <br />
	
	<ol>
		<%
			for(String temp : items) {
				out.println("<li>"+temp+"</li>");
			}		
		%>
	</ol>
</body>
</html>