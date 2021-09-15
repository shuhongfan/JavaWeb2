<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shf2.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList list = new ArrayList();
    list.add(new User("张三",23,new Date()));
    list.add(new User("李斯",24,new Date()));
    list.add(new User("王卫国",33,new Date()));
    request.setAttribute("list",list);
%>

<table border="1" align="center" width="500">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <c:forEach var="user" items="${list}" varStatus="s">
        <c:if test="${s.count%2==0}">
            <tr bgcolor="aqua">
                <th>${s.count}</th>
                <th>${user.name}</th>
                <th>${user.age}</th>
                <th>${user.bitStr}</th>
            </tr>
        </c:if>
        <c:if test="${s.count%2!=0}">
            <tr bgcolor="#663399">
                <th>${s.count}</th>
                <th>${user.name}</th>
                <th>${user.age}</th>
                <th>${user.bitStr}</th>
            </tr>
        </c:if>

    </c:forEach>
</table>
</body>
</html>
