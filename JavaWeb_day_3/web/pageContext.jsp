<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--pageContext对象的使用:--%>
<%--pageContext(PageContextImpl类):它可以获取jsp中的九大内置对象(除了pageContext自身其他八大内置对象)--%>
<%--
request.getScheme():它可以获取请求的协议
request.getServerName():获取请求的服务器ip或域名
request.getServerPort():获取请求的服务器端口号
request.getContextPath():获取当前工程路径
request.getMethod():获取请求的方式（GET或POST）
request.getRemoteHost():获取客户端的ip 地址
session.getId():获取会话的唯一标识
--%>
<%
    pageContext.setAttribute("req", request);
%>
<%=request.getScheme() %> <br>
1.协议: ${ req.scheme }<br>
2.服务器ip:${ pageContext.request.serverName }<br>
3.服务器端口:${ pageContext.request.serverPort }<br>
4.获取工程路径:${ pageContext.request.contextPath }<br>
5.获取请求方法:${ pageContext.request.method }<br>
6.获取客户端ip地址:${ pageContext.request.remoteHost }<br>
7.获取会话的id编号:${ pageContext.session.id }<br>

<%--下面两个对象的区别是，第一个可以做request的其他操作，第二个只能取得request域中的数据--%>
<%--${pageContext.request.getAttribute("key")}--%>
<%--${requestScope.key}--%>
</body>
</html>
