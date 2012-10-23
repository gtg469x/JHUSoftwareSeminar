<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--<jsp:useBean id="rcb" scope="session" class="registration.RegCostBean"/>-->
<%@ page import="java.util.*, registration.RegCostBean" %>
</head>
<body>

<table frame="below" width="400" rules="rows">
<tr><td align="center"><i><b>Your Courses</b></i></td><td align="right"><i><b>Costs</b></i></td></tr>
<%
List<String> coursesList = (List)session.getAttribute("coursesList");
for(String course:coursesList){ 
%>
	<form action="SeminarController" method="GET">
	<input type="hidden" name="formType" value="tableListingPage"/>

<%
	//out.println("<tr><td>"+coursesList[i]+"</td></tr>");
	out.println("<tr><td>"+course+"\t</td><td align=\"right\">\t$"+session.getAttribute("individualCourseCost")+"</td>"
	+"<td><input type=\"hidden\" name=\"removeCourse\" value=\""+coursesList.indexOf(course)+"\"/></td>"
	+"<td>\t<input type=\"SUBMIT\" value=\"remove\"/></td></tr>"
	);
	out.println("</form>");
}

if(rcb.getParkingFee()!=0.0){
	out.println("<tr><td>"+"Parking Fees"+"\t</td><td align=\"right\">\t$"+session.getAttribute("parkingFee")+"</td><td></td></tr>");
}
if(rcb.getHotelFee()!=0.0){
	out.println("<tr><td>"+"Hotel Accommodations"+"\t</td><td align=\"right\">\t$"+session.getAttribute("hotelFee")+"</td><td></td></tr>");
}

%>	

<tr><td align="right"><b>Total:</b></td><td align="right"><b>$<%=session.getAttribute("totalCost")%></b></td></tr>

</table>


</body>
</html>