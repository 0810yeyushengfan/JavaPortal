<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--empty运算可以判断一个数据是否为空，如果为空则输出true,不为空输出false。 以下几种情况为空:--%>
<%--1.值为null值的时候为空--%>
<%--2.值为空串的时候为空--%>
<%--3值是Object类型数组，长度为零的时候--%>
<%--4.list集合，元素个数为零--%>
<%--5.map集合，元素个数为零--%>
    <%
//        1、值为null值的时候，为空
        request.setAttribute("emptyNull", null);
//        2、值为空串的时候，为空
        request.setAttribute("emptyStr", "");
//        3、值是Object类型数组，长度为零的时候
        request.setAttribute("emptyArr", new Object[]{});
//        4、list集合，元素个数为零
        List<String> list = new ArrayList<>();
//        list.add("abc");
        request.setAttribute("emptyList", list);
//        5、map集合，元素个数为零
        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("key1", "value1");
        request.setAttribute("emptyMap", map);
    %>
    ${ empty emptyNull } <br/>
    ${ empty emptyStr } <br/>
    ${ empty emptyArr } <br/>
    ${ empty emptyList } <br/>
    ${ empty emptyMap } <br/>

    <hr>
    ${ 12 != 12 ? "国哥帅呆":"国哥又骗人啦" }

</body>
</html>
