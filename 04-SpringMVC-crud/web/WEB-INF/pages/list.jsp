<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表页</title>
    <%--使用jquery--%>
    <script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
    <script type="text/javascript">
        $(function(){
           $(".delete").click(function(){
                //获取href属性
               //this.href
               $("#deleteForm").attr("action",this.href).submit();
               return false;
           });
        })
    </script>
</head>
<body>
    <h4>员工列表页</h4>
    <!-- 遍历模型中的数据 -->
    <c:if test="${empty emps}">
        没有员工信息
    </c:if>
    <c:if test="${!empty emps}">
        <!-- 遍历 -->
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>ID</td>
                <td>LastName</td>
                <td>Email</td>
                <td>Gender</td>
                <td>Department</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${emps}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>
                        <c:if test="${emp.gender == 0}">Female</c:if>
                        <c:if test="${emp.gender == 1}">Male</c:if>
                    </td>
                    <td>${emp.department.departmentName}</td>
                    <td><a href="/emp/${emp.id}">Edit</a></td>
                    <td><a href="/emp/${emp.id}" class="delete">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <a href="/emp">Add New Employee Info</a>
    <%--构建一个新的form表单，用于提交delete请求--%>
    <form action="" method="post" id="deleteForm">
        <input type="hidden" name="_method" value="DELETE" />
    </form>
</body>
</html>
