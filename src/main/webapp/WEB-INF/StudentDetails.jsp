<%--
  Created by IntelliJ IDEA.
  User: Suman Kunwar
  Date: 12/3/2023
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<h1>Student Details</h1>

<c:if test="${!empty studentKey}">
    <table class="table table-striped">
    <thead>
    <tr>
    <th scope="col">Id</th>
    <th scope="col">Name</th>
    <th scope="col">Email</th>
    <th scope="col">Password</th>
    <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentKey}" var="student">
        <tr>
            <td> <c:out value="${student.id }"></c:out> </td>
            <td> <c:out value="${student.name }"></c:out> </td>
            <td> <c:out value="${student.email }"></c:out> </td>
            <td> <c:out value="${student.password }"></c:out> </td>
            <td> <a href="deleteUser?id=${student.id}" role="button" class="btn btn-danger" onclick="return msg()">Delete</a></td>
            <td> <a href="editUser?id=${student.id}" role="button" class="btn btn-success">Edit</a></td>
        </tr>

    </c:forEach>

    </tbody>
    </table>
</c:if>

<script type="text/javascript">
    function msg() {
        var v=confirm("Do you really want to delete?");
        if (v==true){
            return true;
        }
        else {
            return false;
        }

    }
</script>


    </body>

</html>