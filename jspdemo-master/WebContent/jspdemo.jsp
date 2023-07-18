<%--
<%@page import="com.jsp.jspdemo.JavaCall"%>
OR
--%>
<%@ page import="java.util.Date, com.jsp.jspdemo.JavaCall"%>

<html>
<body>
	<h3>Hello World!</h3>
	<br />
	<br />

	<h3>JSP EXPRESSION</h3>
	<br /> The Time on The Server is
	<%=new Date()%>
	<br /> The Time on The Server is
	<%=new Date().toString()%>
	<br /> The Time on The Server is
	<%=new Date().toLocaleString()%>
	<br /> The Time on The Server is
	<jsp:expression>new Date().toLocaleString()</jsp:expression>
	<br />
	<br /> Converting a String
	<%="\"Hello World\""%>
	to Upper Case:
	<%=new String("\"Hello World\"").toUpperCase()%>
	<br />
	<br /> 25 multiplied by 4 equals:
	<%=25 * 4%>
	<br />
	<br /> Is 75 less than 69?
	<%=75 < 69%>
	<br />
	<br />

	<h3>JSP SCRIPTLET</h3>
	<br />
	<%
		for (int i = 1; i <= 5; i++) {
			out.println(new java.util.Date() + "<br/>");
			Thread.sleep(1000);
			//out.println((new java.util.Date()).toString()+"<br/>"); //Same Output
		}
	%>
	<br />
	<br />


	<h3>JSP Declaration</h3>
	<br />

	<%!String makeItLower1(String data) {
		return data.toLowerCase();
	}%>

	<%--
	Now calling makeItLower() from Java Class,
	for that we must import that class with fully qualified name (with package name)  
	--%>

	Lower case "Hello World" :
	<%=makeItLower1("\"Hello World\"")%>
	<br />
	<br />

	<h3>Calling Java Class from JSP</h3>
	<br /> Lower case "Hello World" :
	<%=JavaCall.makeItLower2("\"Hello World\"")%>
	<br />
	<br />

	<h3>JSP BUILT-IN Objects</h3>
	<br /> Request User agent:
	<%=request.getHeader("User-Agent")%>
	<br />
	<br /> Request Language:
	<%=request.getLocale()%>
	<br />
	<br /> Request IP Adress:
	<%=request.getRemoteAddr()%>



	<h3>Including Files in JSP</h3>

	<br />

	<%--Three Ways of Including Files--%>


	<%--JSP include action--%>
	<jsp:include page="my-header.html" />


	<%--JSP include directive--%>
	<%@ include file="my-header.html"%>

	<%--JSP include directive - XML Equivalent Syntax--%>
	<jsp:directive.include file="my-header.html" />

	Blah blah blah ...
	<br /> Blah blah blah ...
	<br /> Blah blah blah ...
	<br />

	<%@ include file="my-footer.jsp"%>
	<jsp:include page="my-footer.jsp" />

</body>
</html>