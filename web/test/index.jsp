<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/10
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
       int i=5;
       System.out.println("hello jsp");
       String contextPath = request.getContextPath();
       out.print(contextPath);
   %>
    <%!
        int i=3;
    %>
    <%=i%>
    <%= "sfd"%>

    <%
        response.getWriter().write("response....");
    %>
</body>
</html>
