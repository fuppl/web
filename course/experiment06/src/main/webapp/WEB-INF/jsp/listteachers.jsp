<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>

<table>
    <tr>
        <td>#</td>
        <td>姓名</td>
        <td>注册时间</td>
    </tr>
    <c:forEach items="${teachers }" var="t" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td><a href="updateteacher?tid=${t.id}"> ${ t.name} </a></td>
            <td>${t.insertDate}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>


