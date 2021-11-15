<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="pojo.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--需求:Person类中普通属性，数组属性，list集合属性和map集合属性。--%>
<%
    Person person = new Person();
    person.setName("夜雨声烦");
    person.setPhones(new String[]{"18610541354", "18688886666", "18699998888"});

    List<String> cities = new ArrayList<String>();
    cities.add("北京");
    cities.add("上海");
    cities.add("深圳");
    person.setCities(cities);

    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    person.setMap(map);

    pageContext.setAttribute("p", person);
%>

输出Person：${ p }<br/>
输出Person的name属性：${p.name} <br>
输出Person的pnones数组属性值：${p.phones[2]} <br>
输出Person的cities集合中的元素值：${p.cities} <br>
输出Person的List集合中个别元素值：${p.cities[2]} <br>
输出Person的Map集合: ${p.map} <br>
输出Person的Map集合中某个key的值: ${p.map.key3} <br>
输出Person的age属性：${p.age} <br>


</body>
</html>
