<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="rcb" scope="session" class="registration.RegCostBean"/>
<link rel="stylesheet" type="text/css" href="jhuStyle.css">
<%@ page errorPage="registrationError.jsp" %>
<title>Checkout</title>
</head>
<body>
<h1>Johns Hopkins Annual Software Development Seminar</h1>
<h2><jsp:getProperty name="rcb" property="welcomeName"/></h2>
<br>
<br>
You are registered as a <b><jsp:getProperty name="rcb" property="registrationType"/></b>
<br>
<table>
	<tr><td align="right"><b>Your total cost is: </b></td><td align="right"><b>$<%=session.getAttribute("totalCost")%></b></td></tr>
</table>
<fieldset>
	<legend>Payment Details</legend>
	<form action="SeminarController" method="POST">
		<table>
			<tr>
				<td>Credit Card Type</td>
				<td><input type="radio" name="credit" value="visa">Visa</td>
				<td><input type="radio" name="credit" value="master">Master Card</td>
				<td><input type="radio" name="credit" value="discover">Discover</td>
			</tr>
			<tr>
				<td>Credit Card Number</td>
				<td><input type="text" name="ccNum"></td>
			</tr>
			<tr>
				<td>Credit Card Expiration Date</td>
				<td><input type="text" name="ccExpDate"></td>
			</tr>
		</table>
		<input type="hidden" name="errMessage" id="errMessage" value="<%=(String)session.getAttribute("payError") %>" />
		<input type="hidden" name="formType" value="payment">
		<input type="submit" value="Submit for Final Confirmation"/>	
	</form>
	
	<script type="text/javascript">
		document.write(document.getElementById("errMessage").value);
	</script>
</fieldset>

<form action="SeminarController" method="get">
<input type="hidden" name="formType" value="edit"/>
<input type="submit" value="Edit Information or Add Courses"/>
</form>  
<!-- 
<form action="SeminarController" method="get">
<input type="hidden" name="formType" value="confirmPayment"/>
<input type="submit" value="Confirm Registration"/>
</form>
 -->


</body>
</html>