<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/19
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <a href="/testSpringMVCTag">Test SpringMVC Tag</a>
  <br>
  <a href="/testRedirect">Test Redirect</a>
  <br>
  <a href="/toInput">To Input Page</a>
  <br>
  <a href="/testBeanNameViewResolver">Test Bean Name View Resolver</a>
  <br>
  <form action="/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1" >
    <br>
    Name: <input type="text" name="name" value="zhangsan" >
    <br>
    Email: <input type="text" name="email" value="zhangsan@qq.com" />
    <br>
    <input type="submit" value="修改">
  </form>
  <br>
  <a href="/testSessionAttribute"> Test SessionAttribute</a>
  </body>
</html>
