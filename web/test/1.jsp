<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page errorPage="500.jsp" contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        ArrayList<Object> objects = new ArrayList<>();
//        int i=3/0;

    %>

    <%
        pageContext.setAttribute("msg","hello");
    %>

    <%=
        pageContext.getAttribute("msg")
    %>
</head>
<body>

</body>
</html>
