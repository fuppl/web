<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/21
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    请求参数绑定详解--%>

<%--<a href="param/testParam?username=hehe&password=123">请求参数绑定</a>--%>
<%--把数据封装到Account中--%>
<%--<form action="param/saveAccount" method="post">--%>
<%--    姓名：<input type="text" name="username"/><br>--%>
<%--    密码：<input type="text" name="password"/><br>--%>
<%--    金额：<input type="text" name="money"/><br>--%>
<%--    用户：<input type="text" name="user.uname"/><br>--%>
<%--    年龄：<input type="text" name="user.age"/><br>--%>
<%--    <input type="submit">--%>
<%--</form>--%>
<%--把数据封装到Account中，有list和map--%>
<%--<form action="param/saveAccount" method="post">--%>
<%--    姓名：<input type="text" name="username"/><br>--%>
<%--    密码：<input type="text" name="password"/><br>--%>
<%--    金额：<input type="text" name="money"/><br>--%>

<%--    用户：<input type="text" name="list[0].uname"/><br>--%>
<%--    年龄：<input type="text" name="list[0].age"/><br>--%>

<%--    用户：<input type="text" name="map['one'].uname"/><br>--%>
<%--    年龄：<input type="text" name="map['one'].age"/><br>--%>
<%--    <input type="submit">--%>
<%--</form>--%>

<%--自定义类型转换器--%>
<%--<form action="param/saveUser" method="post">--%>
<%--    用户：<input type="text" name="uname"/><br>--%>
<%--    年龄：<input type="text" name="age"/><br>--%>
<%--    日期：<input type="text" name="date"><br>--%>
<%--    <input type="submit">--%>
<%--</form>--%>

<a href="param/testServlet">servlet原生api</a>


</body>
</html>
