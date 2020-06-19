<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/19
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
    <h4>Success Page</h4>
    RequestScope: ${requestScope.user}
    <br>
    SessionScope: ${sessionScope.user}
    <br>
    RequestSchool: ${requestScope.school}
    <br>
    SessionSchool: ${sessionScope.school}
</body>
</html>
