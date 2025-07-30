<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body bgcolor="lavender">
<h1><center> Top Colleges List </center></h1>
<h2><center>Available Colleges </center></h2>

<center>
    <table border="1">
        <tr>
            <th>College Name</th>
            <th>Location</th>
            <th>Offering Course</th>
            <th>Annual Fees</th>
        </tr>
        <c:forEach items="${collegeList}" var="college">
            <tr>
                <td>${college.collegeName}</td>
                <td>${college.location}</td>
                <td>${college.offeringCourse}</td>
                <td>${college.annualFees}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="showPage">Back to Search</a>
</center>
</body>
</html>
