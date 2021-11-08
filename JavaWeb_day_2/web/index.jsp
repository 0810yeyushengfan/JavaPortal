<%--page指令(<%@ page %>)这是jsp文件的头声明。表示这是jsp页面。--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--1.language:值只能是java，表示翻译的得到的是java语言--%>
<%--2.contentType:设置响应头contentType的内容，其中charset是指服务器发送给客户端时的内容编码--%>
<%--3.pageEncoding:设置当前jsp页面的编码--%>
<%--4.import:给当前jsp页面导入需要使用的类包--%>
<%--5.autoFlush:设置是否自动刷新out的缓冲区，默认为true--%>
<%--6.buffer:设置out的缓冲区大小，默认为8KB--%>
<%--7.errorPage:设置当前jsp发生错误后，需要跳转到哪个页面去显示错误信息--%>
<%--8.isErrorPage:设置当前jsp页面是否是错误页面。是的话，就可以使用jsp九大内置对象中的exception异常对象--%>
<%--9.session:设置当前jsp页面是否获取session对象,默认为true--%>
<%--10.extends:给服务器厂商预留的jsp默认翻译的servlet设置继承于什么类--%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP</title>
</head>
<body>
<%--1.jsp页面是一个类似于html的一个页面。jsp直接存放到web目录下，和 html一样，访问jsp的时候，也和访问html一样 --%>
<%--2.jsp的默认编码集是iso-8859-1，需要修改jsp的默认编码为UTF-8--%>

<%--jsp的实质:--%>
<%--当我们访问一个xxx.jsp文件后，其翻译成java文件的全名是xxx_jsp.java文件，xxx_jsp.java文件是一个Servlet 程序。--%>
<%--原来jsp中的html内容都被翻译到Servlet类的service()方法中原样输出。--%>
<h1>hello jsp 中国</h1>
</body>
</html>