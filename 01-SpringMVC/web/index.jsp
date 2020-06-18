<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/18
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="/abc/testAnt">Test Ant</a>
    <hr>
    <a href="/abc/testHeaders">Test Headers</a>
    <hr>
    <a href="/abc/testParam?name=zhangsan&age=18">TestParam</a>
    <hr>
    <form action="/abc/hello" method="post">
      <input type="submit" value="发送"/>
    </form>
  </body>
</html>
