
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin HOME</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand btn btn-outline-info" href="/Admin?action=createSupervisor">CREATE NEW SUPERVISOR</a>
        <a class="navbar-brand btn btn-outline-info" href="/Admin?action=createTeacher">CREATE NEW TEACHER</a>
        <h3 style="color: red">Admin : ${admin.id}</h3>
    </div>
</nav>

<div style="margin-top: 70px">

    <table class="table table-hover">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id giáo vụ</th>
            <th scope="col">Tên giáo vụ</th>
            <th scope="col">Email giáo vụ</th>
            <th scope="col">Mật khẩu giáo vụ</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">link ảnh</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Trạng thái</th>
            <th colspan="2" scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${supervisorList}" var="s">
            <tr>
                <td scope="row">${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.password}</td>
                <td>${s.address.name}</td>
                <td>${s.url}</td>
                <td>${s.dob}</td>
                <td>${s.status.name}</td>

                <td>
                    <a class="btn btn-outline-warning" href="/Admin?action=editSupervisor&id=${s.id}">Sửa</a>
                </td>

                <td>
                    <a class="btn btn-outline-danger" href="/Admin?action=deleteSupervisor&id=${s.id}">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div style="margin-top: 70px">

    <table class="table table-hover">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id giáo viên</th>
            <th scope="col">Tên giáo viên</th>
            <th scope="col">Email giáo viên</th>
            <th scope="col">Mật khẩu giáo viên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">link ảnh</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Trạng thái</th>
            <th colspan="2" scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teacherList}" var="t">
            <tr>
                <td scope="row">${t.id}</td>
                <td>${t.name}</td>
                <td>${t.email}</td>
                <td>${t.password}</td>
                <td>${t.address.name}</td>
                <td>${t.url}</td>
                <td>${t.dob}</td>
                <td>${t.status.name}</td>

                <td>
                    <a class="btn btn-outline-warning" href="/Admin?action=editTeacher&id=${t.id}">Sửa</a>
                </td>

                <td>
                    <a class="btn btn-outline-danger" href="/Admin?action=deleteTeacher&id=${t.id}">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</html>
