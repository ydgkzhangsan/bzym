<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/20
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <c:if test="${empty employee.id}">
        <h4>新增页面</h4>
    </c:if>
    <c:if test="${!empty employee.id}">
        <h4>修改页面</h4>
    </c:if>

    <!--
        编写一个将字符串转换成 Employee 对象的装换器
            字符串必须满足如下规则： FF-ff@aliyun.com-0-1004
     -->
    <form action="/emp" method="post">
        <input type="text" name="employee" >
        <input type="submit" value="Submit">
    </form>


    <%--
        SpringMVC 的表单标签默认是需要做回显的，如果不做回显则会报错。
        SpringMVC 的form表单会自动的从模型中获取对应的模型数据，可以通过指定modelAttribute属性
        显式指定获取哪个模型数据作为表单回显数据。
        如果没有显示的指定，那么SpringMVC的form表单会从 request 域中查找一个名为 commend的属性
        取出作为表单回显的参考，如果没有获取到，则会报错。
    --%>
    <form:form action="/emp" method="post" modelAttribute="employee">

        <%--<form:errors path="*"></form:errors>--%>

        <%--如果是修改 1、保存员工的id  2、需要发送PUT请求--%>
        <c:if test="${!empty employee.id}">
            <form:hidden path="id" />
            <input type="hidden" name="_method" value="PUT" />
        </c:if>
        <c:if test="${empty employee.id}">
            LastName: <form:input path="lastName" /> <form:errors path="lastName"></form:errors>
        </c:if>
        <br>
        Email: <form:input path="email" /><form:errors path="email"></form:errors>
        <br>
        <%
            HashMap map = new HashMap();
            map.put(0,"Female");
            map.put(1,"Male");
            pageContext.setAttribute("map",map);
        %>
        Gender: <form:radiobuttons path="gender" items="${map}"></form:radiobuttons>
        <br>
        Department: <form:select path="department.id" items="${depts}"
                                 itemValue="id" itemLabel="departmentName"></form:select>
        <br>
        Birth: <form:input path="birth"></form:input> <form:errors path="birth"></form:errors>
        <br>
        <%-- 10,000 --%>
        Salary: <form:input path="salary" /> <form:errors path="salary"></form:errors>
        <br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
