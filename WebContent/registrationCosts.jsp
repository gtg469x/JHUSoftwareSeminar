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
<table frame="below" width="400" rules="rows">
<tr><td align="center"><i><b>Your Courses</b></i></td><td align="right"><i><b>Costs</b></i></td></tr>
<%
/*
for(int i=0; i<Integer.parseInt((String) session.getAttribute("coursesLength")); i++){
	out.println("<tr><td>"+courses[i]+"\t</td><td align=\"right\">\t$"++"</td></tr>");
}
if(parking){
	out.println("<tr><td>"+"Parking Fees"+"\t</td><td align=\"right\">\t$"+regUser.calculateParkingFee()+"</td></tr>");
}
if(hotel){
	out.println("<tr><td>"+"Hotel Accommodations"+"\t</td><td align=\"right\">\t$"+regUser.calculateHotelFee()+"</td></tr>");
}
*/

%>	
	<tr><td align="right"><b>Total:</b></td><td align="right"><b>$<jsp:getProperty name="rcb" property="totalCost"/></b></td></tr>
</table>

<form action="seminarRegistration.html" method="get">
  <input type="submit" value="Back">
</form>
</body>
</html>