<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/20
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
    <script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
    <script type="text/javascript">
      $(function(){
          $("#testJson").click(function(){
              //alert(123);
              // 发送一个 ajax 请求
              $.ajax({
                  url     :   this.href,
                  type    :   "post",
                  success :   function(result){
                      for(var i = 0; i < result.length; i++){
                          alert(result[i].lastName)
                      }
                  }
              });
              return false;
          });
      })
    </script>
  </head>
  <body>
    <a href="/emps">Show Employees Info</a>

    <a href="/testJson" id="testJson">Test Json</a>

    <form action="/testHttpMessageConverter" method="post" enctype="multipart/form-data">
      <input type="file" name="file" />
      <input type="text" name="desc" />
      <input type="submit" />
    </form>

    <br>
    <a href="/testResponseEntity">Test ResponseEntity</a>
  </body>
</html>
