<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--要求:在你的web工程下，有一个admin目录。这个admin目录下的所有资源(html页面.jpg图片.jsp文件等等)都必须是用户登录之后才允许访问。--%>
<%--思考:根据之前我们学过内容。我们知道用户登录之后都会把用户登录的信息保存到Session域中。--%>
<%--所以要检查用户是否登录，可以判断Session中否包含有用户登录的信息即可--%>
<%
    Object user=session.getAttribute("user");
    //如果等于null，说明还没有登录
    if(user == null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
    }
%>
我是b.jsp文件
</body>
</html>
