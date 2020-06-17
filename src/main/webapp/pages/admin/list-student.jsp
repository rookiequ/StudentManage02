<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/6/17
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${pageInfo.list}" var="student">


        <td>${student.name}</td>


</c:forEach>
</body>
</html>
