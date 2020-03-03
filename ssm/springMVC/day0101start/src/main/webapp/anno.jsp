<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/21
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>

<a href="anno/testRequestParam?name=哈哈">RequestParam</a><br>

<form action="anno/testRequestBody" method="post">
    用户：<input type="text" name="username"/><br>
    年龄：<input type="text" name="age"/><br>
    日期：<input type="text" name="date"><br>
    <input type="submit">
</form><br>

<a href="anno/testPathVariable/10">PathVariable</a><br>

<a href="anno/testRequestHeader">testRequestHeader</a><br>

<a href="anno/testCookieValue">testCookieValue</a>

<form action="anno/testModelAttribute" method="post">
    用户：<input type="text" name="uname"/><br>
    年龄：<input type="text" name="age"/><br>
    <input type="submit">
</form><br>

<a href="anno/testSessionAttributes">testSessionAttributes</a>

<a href="anno/getSessionAttributes">getSessionAttributes</a>

<a href="anno/deleteSessionAttributes">deleteSessionAttributes</a>


</body>
</html>
