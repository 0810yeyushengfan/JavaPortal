<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--什么是EL表达式?--%>
<%--EL表达式的全称是:Expression Language，是表达式语言--%>
<%--EL表达式的作用?--%>
<%--EL表达式的作用:EL表达式主要是代替jsp页面中的表达式脚本，在jsp页面中进行数据的输出。 --%>
<%--因为EL表达式在输出数据的时候，要比jsp的表达式脚本要简洁很多--%>
<%
    request.setAttribute("key1", "值");
%>
<%--EL表达式的格式是:${表达式} --%>
<%--EL表达式在输出null值的时候，输出的是空串。jsp表达式脚本输出null值的时候，输出的是"null"字符串。--%>
表达式脚本输出key的值是：<%=request.getAttribute("key1") == null ? "" : request.getAttribute("key1")%><br/>
EL表达式输出key的值是：${key1}
</body>
</html>

