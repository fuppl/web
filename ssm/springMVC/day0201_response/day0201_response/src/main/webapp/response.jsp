<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/22
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script>
        //页面加载
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
            //    发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe", "password":"123, "age":30}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        // data表示服务器响应的json的数据，进行解析
                    }
                });
            })
        })
    </script>
</head>
<body>

<a href="user/testString">testString</a><br>

<a href="user/testVoid">testVoid</a><br>

<a href="user/testModelAndView">testModelAndView</a><br>

<a href="user/testFrowardOrRedirect">testFrowardOrRedirect</a><br>

<button id="btn">发送ajax请求</button>

</body>
</html>
