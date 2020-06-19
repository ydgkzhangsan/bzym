<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/19
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Page</title>
    <%--使用Jquery 导入Jquery库--%>
    <script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
    <script>
        $(function(){
            alert(123);
        })
    </script>
</head>
<body>
    <h4>Input Page</h4>
    <%--
        SpringMVC的表单标签默认所有的表单都需要回显。如果没有回显，就会报错

        SpringMVC 提供的表单标签有:
            form:from 标签： 是用来构建一个 form 表单的
                属性：
                    action: 表单提交的路径
                    method: 表单提交的方式
                    modelAttribute: 指定将模型数据中的数据在表单中进行回显
            form:input 标签： 相当于 input 标签
                属性：
                    path: 指定模型数据中的属性名, 相当于 input 标签中的name属性
            form:select 标签： 用于构建下拉列表
                属性：
                    items: 表示遍历的对象集合
                    itemLabel： 使用对象中的那个字段显示
                    itemValue： 使用对象中的那个字段进行提交作为值
                    path： 相当于name属性
           form:radiobuttons 标签： 用于构建一组单选按钮
                    如果想items属性中放入一个Map 将会以 map中属性的键作为单选按钮的value
                    以键的值作为显示的名称

    --%>
    <form:form action="/testCommit" method="post" modelAttribute="user">
        Name: <form:input path="name" />
        <br>
        Email: <form:input path="email" />
        <br>
        age: <form:input path="age" />
        <br>
        <%
            HashMap map = new HashMap();
            map.put(0,"Female");
            map.put(1,"Male");

            ArrayList list = new ArrayList();
            list.add("Female");
            list.add("male");
            request.setAttribute("gender",list);
        %>
        Gender: <form:radiobuttons path="gender" items="${gender}" delimiter="<br>"></form:radiobuttons>
        <br>
        <form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id" ></form:select>
        <input type="submit" value="提交" />
    </form:form>
</body>
</html>
