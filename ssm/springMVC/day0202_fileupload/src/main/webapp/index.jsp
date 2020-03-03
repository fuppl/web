<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/22
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<h3>传统方式</h3>
<%--enctype 后的值表示把表单分成几个部分，分开上传--%>
<form action="user/fileUpload1" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"><br>
    <button type="submit" value="提交">提交</button>
</form>


<h3>SpringMVC方式</h3>
<form action="user/fileUpload2" method="post" enctype="multipart/form-data">
<%--    todo 此处name中的值必须与方法参数名相同（方法在UserController中）--%>
    选择文件：<input type="file" name="upload"><br>
    <button type="submit" value="提交">提交</button>
</form>

<h3>跨服务器上传方式</h3>
<form action="user/fileUpload3" method="post" enctype="multipart/form-data">
    <%--    todo 此处name中的值必须与方法参数名相同（方法在UserController中）--%>
    选择文件：<input type="file" name="upload"><br>
    <button type="submit" value="提交">提交</button>
</form>


</body>
</html>
