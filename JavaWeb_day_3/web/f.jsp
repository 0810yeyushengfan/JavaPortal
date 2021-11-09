<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--三元运算表达式: 1?表达式2:表达式3--%>
<%--如果表达式1的值为真，返回表达式2的值，如果表达式1的值为假，返回表达式3的值。--%>
<%--示例:--%>
${ 12 != 12 ? "夜雨声烦":"夜雨声烦不凡" }
<%--"."(点)运算和[](中括号)运算符:--%>
<%--.(点)运算，可以输出Bean对象中某个属性的值。 --%>
<%--[](中括号)运算，可以输出有序集合中某个元素的值。 并且[]中括号运算，还可以输出map集合中key里含有特殊字符的key的值。--%>
    <%
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("a.a.a", "aaaValue");
        map.put("b+b+b", "bbbValue");
        map.put("c-c-c", "cccValue");
        map.put("t","test");

        request.setAttribute("map", map);
    %>

        ${ map['a.a.a'] } <br>
        ${ map["b+b+b"] } <br>
        ${ map['c-c-c'] } <br>
        ${map.t}

</body>
</html>
