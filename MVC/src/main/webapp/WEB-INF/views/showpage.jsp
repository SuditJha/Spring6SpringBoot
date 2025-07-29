<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

<form:form action="billDesk" method="post" modelAttribute="ticket">
	<a href="/showpage?language=en">English</a>|
	<a href="/showpage?language=fr">French</a>|
	<a href="/showpage?language=de">German</a>
	
	<spring:message code="label.customer" />
	<label for="customer">Customer name</label>
	<form:input path="customer" id="customer" />
	<form:errors path="customer" />
	
	<spring:message code="label.customerName" />
	<label for="contactNumber">Contact Number</label>
	<form:input path="contactNumber" id="contactNumber" />
	<form:errors path="contactNumber" />
	<label for="noOfTicket">No Of ticket</label>
	<form:input path="noOfTicket" id="noOfTicket" />
	<form:errors path="noOfTicket" />
	<label for="ticketType">Ticket Type</label>
	<form:select path="ticketType" id="ticketType" >
		<form:options items="${ticketList}" />		
	</form:select>
	<input type="submit" value="PlaceOrder" id="submit" />
	<input type="reset" value="Cancel" />
	
</form:form>


</body>
</html>