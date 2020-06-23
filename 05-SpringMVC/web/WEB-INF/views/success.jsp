<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/23
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
    <h4><fmt:message key="i18n.title"></fmt:message> </h4>
    <a href="/test?locale=zh_CN">中文</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="/test?locale=en_US">English</a>

    <form action="/testCommonsMultipartResovler" method="post" enctype="multipart/form-data">
        File: <input type="file" name="file" > DESC: <input type="text" name="desc" />
        <input type="submit" >
    </form>
</body>
</html>
