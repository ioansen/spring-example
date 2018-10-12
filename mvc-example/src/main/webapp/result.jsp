<%--
  Created by IntelliJ IDEA.
  User: ioan.sendroiu
  Date: 10/11/2018
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Select Operation</title>
    <link href="<c:url value="/css/table.css" />" rel="stylesheet">
</head>
<body>

<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Last name</td>
        <td>${lastname}</td>
    </tr>
    <tr>
        <td>Salary</td>
        <td>${salary}</td>
    </tr>
    <tr>
        <td>Department</td>
        <td>${dep}</td>
    </tr>
    <tr>
        <td>Job</td>
        <td>${job}</td>
    </tr>
</table>
</body>
