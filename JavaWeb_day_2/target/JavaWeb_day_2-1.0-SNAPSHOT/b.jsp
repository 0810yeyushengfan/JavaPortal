<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=utf-8" isErrorPage="true" language="java" errorPage="/err500.jsp" %>
<!--
errorPage:表示错误后自动跳转去的路径
这个路径一般都是以斜杠打头，它表示请求地址为http://ip:port/工程路径/，映射到代码的Web目录(jsp的本质是servlet，是通过服务器解析的)
-->
<html>
<head>
    <title>Title</title>
</head>
<body>
b.jsp页面
<%--<% int a=12/0; %>--%>
<%--html的注释会被翻译到java代码中输出到html页面中查看--%>
<!--这是html注释-->

<%--单行注释和多行注释能在翻译后的java源代码中看见--%>
<%
    //单行java注释
    /*多行java注释*/
%>

<%--jsp注释在翻译的时候会直接被忽略掉--%>
<%--这是jsp注释--%>

</body>
</html>
