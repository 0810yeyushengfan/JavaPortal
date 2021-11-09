<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--jsp的out和response的write的说明:--%>
<%--1.所有jsp中out输出流的内容都必须要先通过flush()方法写入到Response的writer对象的缓冲区中，才能最终输出到客户端(浏览器)--%>
<%--2.而jsp的out输出流的内容写入到Response的writer对象的缓冲区中时，永远是追加到writer缓冲区的末尾，而且若不是手动flush()，需要到jsp页面
所有代码全部执行完毕之后，才会自动flush()，将out输出流中的内容写入writer缓冲区末尾，最后(即jsp代码全部执行完毕之后)执行Response的刷新操作，把全部数据写给客户端--%>
<%
//out输出
out.write("这是out的第一次输出<br/>");
//out.flush()之后，会把输出的内容写入writer的缓冲区中
out.flush();
//最后一次的输出，由于没有手动flush，会在整个页面输出到客户端的时候，自动写入到writer缓冲区
out.write("这是 out 的第二次输出<br/>");
//writer的输出
response.getWriter().write("这是 writer 的第一次输出<br/>");
response.getWriter().write("这是 writer 的第二次输出<br/>");
%>
<%--由于jsp翻译之后，底层源代码都是使用out来进行输出，所以一般情况下我们在jsp页面中统一使用out来进行输出。避免打乱页面输出内容的顺序。--%>
<%--out.write():输出字符串没有问题，输出其他类型的变量会出现问题--%>
<%--out.print():输出任意数据都没有问题(都转换成为字符串后调用的write输出)--%>
<%--深入源码，浅出结论:在jsp页面中，可以统一使用out.print()来进行输出--%>
</body>
</html>