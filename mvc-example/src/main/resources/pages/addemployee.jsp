<%--
  Created by IntelliJ IDEA.
  User: ioan.sendroiu
  Date: 10/11/2018
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored = "false" %>
<html>
<head>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
    <link href="<c:url value="/css/err.css" />" rel="stylesheet">
    <title>Add employee</title>
</head>

<body>
    <div>
        <form:form method = "POST" action = "${action}" modelAttribute="employee">
            <c:choose>
                <c:when test="${action_name == 'Modify'}">
                    <form:label path="id">Employee Id </form:label><br>
                    <form:input path="id" value="${param.id}" readonly="true"/><br>
                </c:when>
            </c:choose>
            <form:label path = "name">Name</form:label>
            <form:errors path = "name" cssClass = "error" />
            <form:input path = "name" value = "${param.name}"/><br>
            <form:label path = "lastname">Last name</form:label>
            <form:errors path = "lastname" cssClass = "error"  />
            <form:input path = "lastname" value = "${param.lastname}" /><br>
            <form:label path = "salary">Salary</form:label>
            <form:errors path = "salary" cssClass = "error" />
            <form:input path = "salary" value = "${param.salary}"/><br>
            <form:label path = "dep">Department</form:label><br>
            <form:select path = "dep">
                <form:option value="it">IT</form:option>
                <form:option value="hr">HR</form:option>
                <form:option value="contabilitate">Contabilitate</form:option>
            </form:select>
            <form:label path = "job">Job</form:label><br>
            <form:input path = "job" value = "${param.job}"/><br>
            <input type = "submit" value ="${action_name}"/>
        </form:form>
    </div>

</body>
</html>
