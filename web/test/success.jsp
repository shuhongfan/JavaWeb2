<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <%=
        request.getSession().getAttribute("user")
    %>
     , 欢迎光临！！！
</h1>
</body>
</html>
