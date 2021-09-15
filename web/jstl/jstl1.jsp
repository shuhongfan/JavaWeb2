<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <c:if test="false">我是真....</c:if>

    <%
        ArrayList arrayList = new ArrayList();
        arrayList.add("aaa");
        request.setAttribute("list",arrayList);

        request.setAttribute("number",3);
    %>

    <c:if test="${not empty list}">遍历集合...</c:if>
    
    <c:if test="${number%2==0}">
        ${number}为偶数
    </c:if>
    <c:if test="${number%2!=0}">
        ${number}为奇数
    </c:if>
</head>
<body>

</body>
</html>
