<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="jhuStyle.css">
<title>Error Registering</title>
	 <img src="pics/jhuLogo.jpg">
</head>
<body>
<%@ page isErrorPage="true" %>
<h1>There was an error processing your request:</h1>
<i><%=request.getAttribute("error") %></i>

<form action="seminarRegistration.html" method="get">
  <input type="submit" value="Back">
</form>
</body>
</html>