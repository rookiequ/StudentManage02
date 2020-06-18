<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/18
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${pageInfo.list}" var="teacher">


    <td>${teacher.name}</td>


</c:forEach>
</body>
</html>
