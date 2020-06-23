<%--
  Created by IntelliJ IDEA.
  User: fkstart
  Date: 2020/6/23
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%--
      国际化：
        1、在页面中根据浏览器的语言设置情况，将文本（不是内容）、数值、时间根据语言情况进行显示。
          a.在SpringMVC的核心配置文件中配置国际化资源文件对应的bean  ResourceBundlerMessageSource
          b.配置国际化资源文件 .properties文件
          c. 使用 fmg:massage 获取国际化资源文件中的内容，并在页面中显示

        2、在控制器中获取国际化消息内容。
          在控制器中注入 ResouceBundlerMessageSource 对应的bean 通过其getMessage() 获取传入消息码对应的消息。

        3、通过超链接去切换
          a.编写超链接 需要在超链接后携带一个请求参数 locale  参数值为语言信息  en_US   zh_CN
          b.在SpringMVC的配置文件中配置 SessionLocaleResorver 和 LocaleChangeInterceptor
    --%>
    <a href="/test">Test </a>
  </body>
</html>
