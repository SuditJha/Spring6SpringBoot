<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<head>
<style>
.error { color: red; }
</style>
</head>
<body style="background-color:lavender">

<h1><center>Preschool Enrollment</center></h1>

<form:form action="register" method="post" modelAttribute="admission">
    <table style="margin-left: auto; margin-right: auto;">
        <tr>
            <td>Child Name :</td>
            <td><form:input path="childName" id="childName"/></td>
            <td><form:errors path="childName" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Contact Number:</td>
            <td><form:input path="contactNumber" id="contactNumber"/></td>
            <td><form:errors path="contactNumber" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Age:</td>
            <td><form:input path="age" id="age"/></td>
            <td><form:errors path="age" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Email Id:</td>
            <td><form:input path="emailId" id="emailId"/></td>
            <td><form:errors path="emailId" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Program Name:</td>
            <td>
                <form:select path="programName" id="programName" items="${programNames}"/>
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Register" id="submit"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
