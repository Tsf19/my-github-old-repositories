<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Result</title>
</head>
<body>
	<%
			HttpSession hs = request.getSession();
			
			int usn = (Integer)hs.getAttribute("USN");
			String name = (String)hs.getAttribute("NAME");
			int marks1 = (Integer)hs.getAttribute("MARKS");
			
			out.println(usn+" "+name+" "+marks1);
			
		%>
</body>
</html>