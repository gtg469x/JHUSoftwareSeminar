<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="rcb" scope="session" class="registration.RegCostBean"/>
<link rel="stylesheet" type="text/css" href="jhuStyle.css">
<%@ page errorPage="registrationError.jsp" %>
<title>Registration Successful</title>
 <img src="pics/jhuLogo.jpg">
</head>
<body>
<h1>Johns Hopkins Annual Software Development Seminar</h1>
<h2><jsp:getProperty name="rcb" property="welcomeName"/></h2>
<br>
<br>
You are registered as a <b><jsp:getProperty name="rcb" property="registrationType"/></b>
<br>
<br>
Your email confirmation will be sent to: <b><jsp:getProperty name="rcb" property="email"/></b>
<br>
<br>

<jsp:include page="courseCostListing.jsp"/>

<form action="SeminarController" method="get">
<input type="hidden" name="formType" value="edit"/>
<input type="submit" value="Edit Information or Add Courses"/>
</form>  

<form action="SeminarController" method="get">
<input type="hidden" name="formType" value="confirm"/>
<input type="submit" value="Confirm Registration"/>
</form>

 <!-- <input type="submit" value="Back">-->

</body>
</html>