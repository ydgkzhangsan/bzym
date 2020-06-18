<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/18
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%--
    想要返送 PUT 或 DELETE 请求：
      0、必须配置好 HiddentHttpMethodFilter 过滤器
      1、需要发送一个 POST 请求
      2、需要在 POST 请求中携带一个请求参数 _method 值是 PUT 或 DELETE
  --%>
  Delete 请求: <form method="post" action="/testRest">
    <input type="hidden" name="_method" value="DELETE" />
    <input type="submit" value="Test DELETE">
  </form>
  <hr>
  Put 请求：<form method="post" action="/testRest">
    <input type="hidden" name="_method" value="PUT" />
    <input type="submit" value="Test Put">
  </form>
  <hr>
  POST 请求：<br>
  <form method="post" action="/testRest">
    <input type="submit" value="Test Post">
  </form>
  <hr>
  GET 请求： <a href="testRest"> Test Get</a>
  <hr>
    <a href="/testPathVariable/2">Test PathVariable</a>
  </body>
</html>
