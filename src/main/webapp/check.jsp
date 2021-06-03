<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 6/2/2021
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>name</td>
        <td>class</td>
        <td>address</td>
        <td>status</td>
        <td>module </td>
    </tr>
<c:forEach items="${listSTT}" var="list">
    <tr>
        <td>${list.name}</td>
        <td>${list.class_.name}</td>
        <td>${list.address.name}</td>
        <td>${list.status.name}</td>
        <td>${list.moduleList.name}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
