<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<form action="/updateteacher" method="post">
    用户<input type="text" value="${teacher.name}" name="name"><br>
    注册时间<fmt:formatDate value="${teacher.insertDate}" pattern="yyyy-MM-dd HH-mm"/><br><br>
    职称


</form>

</body>
</html>
