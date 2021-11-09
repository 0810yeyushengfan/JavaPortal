<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--EL获取四个特定域中的属性:--%>
<%--1.pageScope ======> pageContext域 --%>
<%--2.requestScope ======> Request域 --%>
<%--3.sessionScope ======> Session域 --%>
<%--4.applicationScope ======> ServletContext域--%>
<%
    pageContext.setAttribute("key1", "pageContext1");
    pageContext.setAttribute("key2", "pageContext2");
    request.setAttribute("key2", "request");
    session.setAttribute("key2", "session");
    application.setAttribute("key2", "application");
%>
${ applicationScope.key2 }
</body>
</html>
