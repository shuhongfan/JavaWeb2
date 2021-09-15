<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
    ${i}-------${s.index}-----${s.count} <br>
</c:forEach>

<hr>

<%
    ArrayList arrayList = new ArrayList();
    arrayList.add("aaa");
    arrayList.add("bbb");
    arrayList.add("ccc");
    request.setAttribute("list",arrayList);
%>

<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index}-----${s.count}-------${str} <br>
</c:forEach>
</body>
</html>
