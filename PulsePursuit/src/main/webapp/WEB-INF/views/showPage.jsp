<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body style="background-color:lavender">
<h1><center>Welcome to PulsePursuit Tournament</center></h1>

<form:form modelAttribute="registration" method="post" action="register">
    <table align="center">
        <tr>
            <td>Participant Name</td>
            <td><form:input path="participantName" id="participantName"/></td>
            <td><form:errors path="participantName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td><form:input path="phoneNumber" id="phoneNumber"/></td>
            <td><form:errors path="phoneNumber" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email" id="email"/></td>
            <td><form:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><form:input path="age" id="age"/></td>
            <td><form:errors path="age" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Event Type</td>
            <td>
                <form:select path="eventType" items="${eventTypeList}" id="eventType"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Register" id="submit"/>
            </td>
        </tr>
    </table>
</form:form>

<c:if test="${not empty message}">
    <div style="text-align:center; color:blue; font-size:18px;">
        ${message}
    </div>
</c:if>

<style>
    .error {
        color: red;
    }
</style>
</body>
</html>
