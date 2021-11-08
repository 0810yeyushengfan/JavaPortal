<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
头部信息 <br>
主体内容 <br>
<%--
    <%@ include file=""%>就是静态包含
        file属性:指定你要包含的jsp页面的路径
        地址中第一个/(斜杠):表示为http://ip:port/工程路径/(因为这是jsp即原本的servlet，是在服务器中解析的)，映射到代码的web目录

     静态包含的特点:
        1.静态包含不会翻译被包含的jsp页面。
        2.静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出。--%>
<%--<%@ include file="/include/footer.jsp"%>--%>

<%--
    <jsp:include page=""></jsp:include>就是动态包含
    page属性:是指定你要包含的jsp页面的路径
    动态包含也可以像静态包含一样。把被包含的内容执行输出到包含位置

    动态包含的特点:
        1.动态包含会把包含的jsp页面也翻译成为java代码
        2.动态包含底层代码使用如下代码去调用被包含的jsp页面执行输出。
            JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
        3.动态包含还可以传递参数
--%>
<jsp:include page="/include/footer.jsp">
    <jsp:param name="username" value="bbj"/>
    <jsp:param name="password" value="root"/>
</jsp:include>
<%--在这里需要补充说明一点:我们在工作中几乎都是使用静态包含。因为jsp页面虽然可以写java代码，做其他的功能操作。--%>
<%--但是由于jsp在开发过程中被定位为专门用来展示页面的技术。也就是说。jsp页面中，基本上只有html.css.js，还有一些简单的--%>
<%--EL表达式脚本等输出语句。所以我们都使用静态包含。--%>
<%--不论是在静态包含还是在动态包含中，一旦碰到了jsp脚本/标签/包含等jsp语法，在最终都会对这些语法进行解析执行--%>
<%--这就造成了能够多重包含，比如a静态/动态包含了b，b还能静态/动态包含c，且执行之后的结果符合预期--%>
</body>
</html>