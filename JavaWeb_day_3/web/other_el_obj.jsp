<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/4
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--EL表达式其他隐含对象的使用:--%>
<%--1.param Map<String,String>:它可以获取请求参数的值 --%>
<%--2.paramValues Map<String,String[]>:它也可以获取请求参数的值，获取多个值的时候使用。--%>
    输出请求参数username的值：${ param.username } <br>
    输出请求参数password的值：${ param.password } <br>
    输出请求参数username的值：${ paramValues.username[0] } <br>

<%--3.header Map<String,String>:它可以获取请求头的信息--%>
<%--4.headerValues Map<String,String[]>:它可以获取请求头的信息，它可以获取多个值的情况--%>
    输出请求参数hobby的值：${ paramValues.hobby[0] } <br>
    输出请求参数hobby的值：${ paramValues.hobby[1] } <br>
    <hr>
    输出请求头【User-Agent】的值：${ header['User-Agent'] } <br>
    输出请求头【Connection】的值：${ header.Connection } <br>
    输出请求头【User-Agent】的值：${ headerValues['User-Agent'][0] } <br>
    <hr>

<%--5.cookie Map<String,Cookie>:它可以获取当前请求的Cookie信息--%>
    获取Cookie的名称：${ cookie.JSESSIONID.name } <br>
    获取Cookie的值：${ cookie.JSESSIONID.value } <br>
    <hr>


<%--6.initParam Map<String,String>:它可以获取在web.xml中配置的<context-param>上下文参数--%>
    输出&lt;Context-param&gt;username的值：${ initParam.username } <br>
    输出&lt;Context-param&gt;url的值：${ initParam.url } <br>

</body>
</html>
