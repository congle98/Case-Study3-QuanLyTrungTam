<%--
  Created by IntelliJ IDEA.
  User: CONG
  Date: 6/2/2021
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Hello, world!</title>
</head>
<body>
<table border="1">
<c:forEach items="${teacherList}" var="list">

        <tr>
<%--            <td>${list.id}</td>--%>
<%--            <td>${list.name}</td>--%>
<%--            <td>${list.aClass.name}</td>--%>
<%--            <td>${list.dateStart}</td>--%>
<%--            <td>${list.dateEnd}</td>--%>
<%--            <td>${list.studentList}</td>--%>
<%--            <td>${list.id}</td>--%>
<%--            <td>${list.description}</td>--%>
<%--            <td>${list.date}</td>--%>
<%--            <td>${list.aClass.name}</td>--%>
<%--            <td>${list.aClass.teacher.name}</td>--%>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.email}</td>
            <td>${list.status.name}</td>
        </tr>

</c:forEach>
</table>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</html>
