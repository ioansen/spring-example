<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: ioan.sendroiu
  Date: 10/15/2018
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
    <link href="<c:url value="/css/table.css" />" rel="stylesheet">
    <link href="<c:url value="/css/button.css" />" rel="stylesheet">


</head>
<body>
<table>
    <tr>
        <th>Emp ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Salary</th>
        <th>Department</th>
        <th>Job</th>
    </tr>
    <c:forEach var = "row" items = "${employeeList}">
        <tr>
            <td><c:out value = "${row.id}"/></td>
            <td><c:out value = "${row.name}"/></td>
            <td><c:out value = "${row.lastname}"/></td>
            <td><c:out value = "${row.salary}"/></td>
            <td><c:out value = "${row.dep}"/></td>
            <td><c:out value = "${row.job}"/></td>
            <td style="display: inline-block;">
                <a class = "button_table" href="
                    <c:url value="updateemp">
                        <c:param name="id" value="${row.id}"/>
                    </c:url>
                ">Modify</a>
                <a class = "button_table" href="
                    <c:url value="deleteemp">
                        <c:param name="id" value="${row.id}"/>
                    </c:url>
                ">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="addemp" class="button">Add employee</a><br><br>
<%-- <c:out value="${param.errmsg}"/>--%>
</body>
</html>
