<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/23
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h3>查询了所有账户</h3>
<c:forEach items="${accounts}" var="a">
    ${a.name}
    ${a.money}
    <br>
</c:forEach>

</body>
</html>
