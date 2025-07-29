<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<body bgcolor="lightgreen">
    <center>
        <h1>Swift Cart Portal</h1>

        <sf:form method="post" modelAttribute="customer" action="registerCustomer">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><sf:input path="name" id="name" /></td>
                </tr>
                <tr>
                    <td>Email Id:</td>
                    <td><sf:input path="emailId" id="emailId" /></td>
                </tr>
                <tr>
                    <td>Mobile Number:</td>
                    <td><sf:input path="mobileNumber" id="mNumber" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" id="register" value="Register" id="submit" />
                        <input type="reset" value="Cancel" />
                    </td>
                </tr>
            </table>
        </sf:form>
    </center>
</body>
</html>
