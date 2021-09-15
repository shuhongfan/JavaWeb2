<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙！！！</h1>
    <%
        String message = exception.getMessage();
        out.println(message);
    %>
</body>
</html>
