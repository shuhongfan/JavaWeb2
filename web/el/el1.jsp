<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page isELIgnored="true" contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

\${3>4}
${3>4}
${3+4}
${3/4}
${3 div 4}
${3%4}
${3 mod 4}
${3 == 4}

<%
    session.setAttribute("name","李斯");
    request.setAttribute("name","张三");
    session.setAttribute("age",23);

    String str="abc";
    request.setAttribute("str",str);

    ArrayList arrayList = new ArrayList();
    request.setAttribute("list",arrayList);
%>
${requestScope.name}
${requestScope.age}
${requestScope.haha}
${name}

${empty str}
${empty list}
</body>
</html>
