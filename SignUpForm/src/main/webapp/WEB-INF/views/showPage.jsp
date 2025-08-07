<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<body>

<h2><spring:message code="label.userName" /></h2>
<form:form method="post" modelAttribute="account">
    
    <!-- User Name -->
    <label for="userName"><spring:message code="label.userName" /></label>
    <form:input path="userName" id="userName" required="required" minlength="3"/><br/><br/>

    <!-- Gender -->
    <spring:message code="label.gender" />:<br/>
    <label for="male"><spring:message code="label.male"/></label>
    <form:radiobutton path="gender" id="male" value="Male" required="required"/>

    <label for="female"><spring:message code="label.female"/></label>
    <form:radiobutton path="gender" id="female" value="Female" required="required"/><br/><br/>

    <!-- Phone Number -->
    <label for="phoneNumber"><spring:message code="label.phoneNumber" /></label>
    <form:input path="phoneNumber" id="phoneNumber" type="tel" pattern="\\d{10}" required="required"/><br/><br/>

    <!-- Email -->
    <label for="email"><spring:message code="label.email" /></label>
    <form:input path="email" id="email" type="email" required="required"/><br/><br/>

    <!-- Password -->
    <label for="password"><spring:message code="label.password" /></label>
    <form:password path="password" id="password" minlength="6" required="required"/><br/><br/>

    <!-- Submit -->
    <input type="submit" value="Submit"/>

</form:form>

<!-- Message display -->
<p id="message"><c:out value="${message}"/></p>

</body>
</html>
