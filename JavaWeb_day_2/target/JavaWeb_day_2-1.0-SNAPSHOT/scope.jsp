<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope.jsp页面</h1>
四大域对象经常用来保存数据信息。
1.pageContext:可以保存数据在同一个jsp页面中使用
2.request:可以保存数据在同一个request对象中使用，经常用于在转发的时候传递数据
3.session:可以保存在一个会话中使用
4.application(ServletContext):就是ServletContext 对象
<%
    //往四个域中都分别保存了数据
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext域是否有值:<%=pageContext.getAttribute("key")%> <br>
request域是否有值:<%=request.getAttribute("key")%> <br>
session域是否有值:<%=session.getAttribute("key")%> <br>
application域是否有值:<%=application.getAttribute("key")%> <br>
<%
    //request.getRequestDispatcher("/scope2.jsp").forward(request,response);
%>
<%--
    <jsp:forward page=""></jsp:forward>
        <jsp:forward>是请求转发标签，它的功能就是请求转发
        page属性:设置请求转发的路径
    <jsp:forward>转发功能相当于request.getRequestDispatcher("/xxxx.jsp").forward(request,response);的功能
--%>
<jsp:forward page="/scope2.jsp"></jsp:forward>
</body>
</html>