<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--第一种，声明脚本:--%>
<%--声明脚本格式如下:<%! java 代码 %>--%>
<%--在声明脚本块中，我们可以干4件事情:--%>
<%--1.我们可以定义全局变量--%>
<%--2.定义static静态代码块--%>
<%--3.定义方法--%>
<%--4.定义内部类--%>
<%--几乎可以写在类的内部写的代码，都可以通过声明脚本来实现--%>
<%--练习:--%>
<%--1.声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>
<%--2.声明static静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }
%>
<%--3.声明类方法--%>
<%!
    public int abc() {
        return 12;
    }
%>
<%--4.声明内部类--%>
<%!
    public static class A {
        private Integer id = 12;
        private String abc = "abc";
    }
%>

<%--第二种，表达式脚本:--%>
<%--表达式脚本格式如下:<%=表达式 %>--%>
<%--表达式脚本的特点:--%>
<%--1.所有的表达式脚本都会被翻译到_jspService()方法中 --%>
<%--2.表达式脚本都会被翻译成为out.print()输出到页面上 --%>
<%--3.由于表达式脚本翻译的内容都在_jspService()方法中,所以_jspService()方法中的对象都可以直接使用。--%>
<%--4.表达式脚本中的表达式不能以分号结束。--%>
<%--表达式脚本用于向页面输出内容。表达式脚本翻译到Servlet程序的service()方法中，以out.print()打印输出--%>
<%--out是jsp的一个内置对象，用于生成html的源代码--%>
<%--注意:表达式不要以分号结尾，否则会报错--%>
<%--表达式脚本可以输出任意类型，比如--%>
<%--1.输出整型 --%>
<%--2.输出浮点型 --%>
<%--3.输出字符串 --%>
<%--4.输出对象--%>
<%--练习:--%>
<%--1.输出整型--%>
<%=12 %> <br>
<%--2.输出浮点型--%>
<%=12.12 %> <br>
<%--3.输出字符串--%>
<%="我是字符串" %> <br>
<%--4.输出对象--%>
<%=map%> <br>


<%--第三种，代码脚本:--%>
<%--代码脚本格式如下:<% java代码 %> --%>
<%--代码脚本的特点是:--%>
<%--1.代码脚本翻译之后都在_jspService()方法中 --%>
<%--2.代码脚本由于翻译到_jspService()方法中，所以在_jspService()方法中的现有对象都可以直接使用。 --%>
<%--3.还可以由多个代码脚本块组合完成一个完整的java语句。--%>
<%--4.代码脚本还可以和表达式脚本一起组合使用，在jsp页面上输出数据--%>
<%--代码脚本里可以书写任意的java语句，代码脚本的内容都会被翻译到service()方法中。所以service()方法中可以写的java代码，都可以书写到代码脚本中--%>
<%--练习：--%>
<%--1.代码脚本----if 语句--%>
<%
    int i = 13;
    if (i == 12) {
%>
<h1>帅</h1>
<%
} else {
%>
<h1>骗人</h1>
<%
    }
%>
<br>
<%--2.代码脚本----for循环语句--%>
<table border="1" cellspacing="0">
    <%
        for (int j = 0; j < 10; j++) {
    %>
    <tr>
        <td>第 <%=j + 1%>行</td>
    </tr>
    <%
        }
    %>
</table>
<%--3.翻译后产生的java文件中_jspService方法内的代码都可以写--%>
<%
    String username = request.getParameter("username");
    System.out.println("用户名的请求参数值是:" + username);
%>


<%--jsp中九大内置对象分别是:--%>
<%--1.request对象:请求对象，可以获取请求信息--%>
<%--2.response对象:响应对象，可以设置响应信息--%>
<%--3.pageContext对象:当前页面上下文对象，可以在当前上下文保存属性信息--%>
<%--4.session对象:会话对象，可以获取会话信息。--%>
<%--5.exception对象:异常对象，只有在jsp页面的page指令中设置isErrorPage="true"的时候才会存在--%>
<%--6.application对象:ServletContext对象实例，可以获取整个工程的一些信息。--%>
<%--7.config对象:ServletConfig对象实例，可以获取Servlet的配置信息--%>
<%--8.out对象:输出流。--%>
<%--9.page对象:表示当前Servlet对象实例(无用，用它不如使用this对象)--%>
<%--上述九大内置对象，都是我们可以在[代码脚本中]或[表达式脚本]中直接使用的对象。--%>

</body>
</html>

