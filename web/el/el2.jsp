<%@ page import="com.shf2.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user=new User();
    user.setName("张三");
    user.setAge(23);
    user.setBirthday(new Date());
    request.setAttribute("u",user);

    ArrayList arrayList = new ArrayList();
    arrayList.add("aaa");
    arrayList.add("bbb");
    arrayList.add(user);
    request.setAttribute("list",arrayList);

    HashMap hashMap = new HashMap();
    hashMap.put("sname","历史");
    hashMap.put("gender","男");
    hashMap.put("user",user);
    request.setAttribute("map",hashMap);
%>

${requestScope.u}
${requestScope.u.name}
${u.age}
${u.bitStr}

<h3>获取list值</h3>
${list}
${list[0]}
${list[1]}
${list[11]}
${list[2].name}

${map}
${map.sname}
${map["sname"]}
${map.user.name}

</body>
</html>
