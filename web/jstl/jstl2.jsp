<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int number=5;
    request.setAttribute("num",number);
%>

<c:choose>
    <c:when test="${num==1}">星期一</c:when>
    <c:when test="${num==2}">星期二</c:when>
    <c:when test="${num==3}">星期三</c:when>
    <c:when test="${num==4}">星期四</c:when>
    <c:when test="${num==5}">星期五</c:when>
    <c:when test="${num==6}">星期六</c:when>
    <c:when test="${num==7}">星期七</c:when>
</c:choose>
</body>
</html>
