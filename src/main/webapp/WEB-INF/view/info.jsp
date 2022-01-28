<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Employees</title>
</head>
<body>
<h3>Info For All Employees</h3>
<br>
<security:authorize access="hasRole('HR')">Only for HR stuff<input type="button" value="Salary"
    onclick="window.location.href= 'http://localhost:8080/spring/hr'"></security:authorize>

<br>

<br>

<security:authorize access="hasRole('Manager')">Only for Managers <input type="button" value="Performance"
       onclick="window.location.href= 'http://localhost:8080/spring/manager'"></security:authorize>
<br>

</body>
</html>
