<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope.jsp页面</h1>
<%--四大域对象经常用来保存数据信息。--%>
<%--1.pageContext(PageContextImpl类):可以保存数据在同一个jsp页面中使用，当前jsp页面范围内有效--%>
<%--2.request(HttpServletRequest类):可以保存数据在同一个request对象中使用，经常用于在转发的时候传递数据，一次请求内有效--%>
<%--3.session(HttpSession类):可以保存在一个会话中使用，一个会话范围内有效(打开浏览器访问服务器，直到关闭浏览器)--%>
<%--4.application(ServletContext类):就是ServletContext对象，整个web工程范围内都有效(只要web工程不停止，数据都在)--%>
<%--域对象是可以像Map一样存取数据的对象。--%>
<%--四个域对象功能一样。不同的是它们对数据的存取范围。虽然四个域对象都可以存取数据。在使用上它们是有优先顺序的。 --%>
<%--四个域在使用的时候，优先顺序分别是他们从小到大的范围的顺序。 --%>
<%--即pageContext ====>>> request ====>>> session ====>>> application--%>
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