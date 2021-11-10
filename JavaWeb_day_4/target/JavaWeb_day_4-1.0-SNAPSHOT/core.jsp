<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--JSTL标签库:全称是指JSP Standard Tag Library(JSP标准标签库)，是一个不断完善的开放源代码的JSP标签库。--%>
<%--EL表达式主要是为了替换jsp中的表达式脚本，而标签库则是为了替换代码脚本。这样使得整个jsp页面变得更佳简洁。--%>
<%--JSTL标签库的使用步骤:--%>
<%--1.先导入jstl标签库的jar包--%>
<%--taglibs-standard-impl-1.2.1.jar --%>
<%--taglibs-standard-spec-1.2.1.jar --%>
<%--2.使用taglib指令引入标签库--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--1.<c:set />
    set标签作用:可以往域中保存数据
    以前(jsp)的做法:域对象.setAttribute(key,value);
    scope属性:设置保存到哪个域
        page表示PageContext域（默认值）
        request表示Request域
        session表示Session域
        application表示ServletContext域
    var属性:设置key是多少
    value属性:设置值
--%>
保存之前：${ sessionScope.abc } <br>
<c:set scope="session" var="abc" value="abcValue"/>
保存之后：${ sessionScope.abc } <br>
<hr>

<%--2.<c:if />
     if标签作用:用来做if判断。
     test属性:表示判断的条件(使用EL表达式输出)
--%>
<c:if test="${ 12 == 12 }">
    <h1>12等于12</h1>
</c:if>
<c:if test="${ 12 != 12 }">
    <h1>12不等于12</h1>
</c:if>
<hr>

<%--3.<c:choose> <c:when> <c:otherwise>标签
作用:多路判断。跟switch ... case .... default非常接近
choose标签:开始选择判断
when标签:表示每一种判断情况
    test属性:表示当前这种判断情况的值
otherwise标签:表示剩下的情况

<c:choose> <c:when> <c:otherwise>标签使用时需要注意的点:
    1.标签里不能使用html注释，要使用jsp注释
    2.when标签的父标签一定要是choose标签，不能直接在otherwise标签内嵌套
--%>
<%
    request.setAttribute("height", 180);
%>
<c:choose>
    <%-- 这是html注释 --%>
    <c:when test="${ requestScope.height > 190 }">
        <h2>小巨人</h2>
    </c:when>
    <c:when test="${ requestScope.height > 180 }">
        <h2>很高</h2>
    </c:when>
    <c:when test="${ requestScope.height > 170 }">
        <h2>还可以</h2>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${requestScope.height > 160}">
                <h3>大于160</h3>
            </c:when>
            <c:when test="${requestScope.height > 150}">
                <h3>大于150</h3>
            </c:when>
            <c:when test="${requestScope.height > 140}">
                <h3>大于140</h3>
            </c:when>
            <c:otherwise>
                其他小于140
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>


</body>
</html>
