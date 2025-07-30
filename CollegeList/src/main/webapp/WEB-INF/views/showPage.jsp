<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body style="background-color:lavender">
<h1><center> Top Colleges List</center></h1>
<center>
    <form:form method="post" action="viewCollegeList" modelAttribute="college">
        <table>
            <tr>
                <td>Course</td>
                <td><form:input path="offeringCourse" id="offeringCourse" /></td>
            </tr>
            <tr>
                <td>Annual Fees</td>
                <td><form:input path="annualFees" id="annualFees" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Search" id="submit"/>
                </td>
            </tr>
        </table>
    </form:form>
</center>
</body>
</html>
