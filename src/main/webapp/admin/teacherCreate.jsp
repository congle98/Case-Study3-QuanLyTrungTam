<%--
  Created by IntelliJ IDEA.
  User: CONG
  Date: 6/2/2021
  Time: 10:25 AM
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
<nav class="navbar navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand btn btn-outline-info" href="/Admin?action=home">Back to home</a>
    </div>
</nav>
<div class="create-form col-sm-5  border border-secondary border-5 rounded">
    <p>${message}</p>
    <form method="post">
        <label class="form-label" for="name">Nhập tên</label>
        <input name="name" id="name"  class="form-control" type="text" placeholder="tên">
        <label class="form-label" for="email">Nhập email</label>
        <input name="email" id="email"  class="form-control" type="text" placeholder="email">
        <label class="form-label" for="password">Nhập mật khẩu</label>
        <input name="password" id="password" class="form-control"  type="text" placeholder="password">
        <label class="form-label" for="url">Nhập link ảnh</label>
        <input name="url" id="url" class="form-control"  type="text" placeholder="link ảnh">
        <label class="form-label" for="dob">Ngày sinh</label>
        <input name="dob" id="dob" class="form-control"  type="date" placeholder="ngày sinh">
        <select name="address_id" class="form-select">
            <c:forEach items="${addressList}" var="address">
                <option value="${address.id}">${address.name}</option>
            </c:forEach>
        </select>
        <select name="status_id" class="form-select">
            <c:forEach items="${statusList}" var="status">
                <option value="${status.id}">${status.name}</option>
            </c:forEach>
        </select>


        <button  class="btn btn-danger" type="submit">Thêm mới</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</html>
