<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/3
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
列表
<ul>
    <c:forEach items="${users}" var="u">
        <li><a href="/getuser?id=${u.id}">${u.name }</a> </li>
    </c:forEach>
</ul>

</body>
</html>
