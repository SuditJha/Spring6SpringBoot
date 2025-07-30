<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<head>
    <style>
        #message {
            color: red;
        }
    </style>
</head>
<body style="background-color:lavender">

<a href="/showPage?language=en">English</a> | 
<a href="/showPage?language=fr">French</a>

<h1><center>Sports Academy</center></h1>

<form:form action="registration" modelAttribute="registration" method="post">
    <table style="margin: 0px auto;">
        <tr>
            <td><spring:message code="label.studentName"/></td>
            <td><form:input path="studentName" id="studentName"/></td>
        </tr>
        <tr>
            <td><spring:message code="label.phoneNumber"/></td>
            <td><form:input path="phoneNumber" id="phoneNumber"/></td>
        </tr>
        <tr>
            <td><spring:message code="label.age"/></td>
            <td><form:input path="age" id="age"/></td>
        </tr>
        <tr>
            <td><spring:message code="label.optedSports"/></td>
            <td>
                <form:select path="optedSports" id="optedSports">
                    <form:options items="${sportsList}" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" id="submit" name="submit" value="Register"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="message">${message}</div>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
