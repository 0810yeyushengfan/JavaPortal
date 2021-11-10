<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/11/10
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("target.jsp页面执行了");
    System.out.println("target.jsp所在的线程"+Thread.currentThread().getName());
    System.out.println("target.jsp所持有的Request"+request);
%>
我是target.jsp
</body>
</html>
