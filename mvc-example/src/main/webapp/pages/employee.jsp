<%--
  Created by IntelliJ IDEA.
  User: ioan.sendroiu
  Date: 10/11/2018
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<%@ page isELIgnored = "false" %>
<html>
<head>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
    <link href="<c:url value="/css/err.css" />" rel="stylesheet">
    <title>Add employee</title>
</head>

<body>
    <div>
        <form:form method = "POST" action = "/addEmployee" modelAttribute="employee">
            <form:label path = "name">Name</form:label>
            <form:errors path = "name" cssClass = "error" />
            <form:input path = "name" /><br>
            <form:label path = "lastname">Last name</form:label>
            <form:errors path = "lastname" cssClass = "error"  />
            <form:input path = "lastname" /><br>
            <form:label path = "salary">Salary</form:label>
            <form:errors path = "salary" cssClass = "error" />
            <form:input path = "salary" /><br>
            <form:label path = "dep">Department</form:label><br>
            <form:input path = "dep" /><br>
            <form:label path = "job">Job</form:label><br>
            <form:input path = "job" /><br>
            <input type = "submit" value = "Submit"/>
        </form:form>
    </div>

</body>
</html>
