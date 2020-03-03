<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/23
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="account/findAll">测试查询</a>

<h3>测试保存</h3>
<form action="account/saveAccount" method="post">
    姓名：<input type="text" name="name"/><br>
    金额：<input type="text" name="money"/><br>
    <button type="submit">提交</button>
</form>

</body>
</html>
