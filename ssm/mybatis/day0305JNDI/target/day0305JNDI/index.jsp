<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.example.dao.UserDao" %>
<%@ page import="com.example.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>

<h2>Hello World!</h2>

<%
    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(in);
    SqlSession sqlsession = factory.openSession();
    UserDao userDao = sqlsession.getMapper(UserDao.class);
    List<User> users = userDao.findAll();
    for(User u :users){
        System.out.println(u);
    }
    sqlsession.close();
    in.close();
%>
</body>
</html>
