<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/13
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<style>
    div{
        color: red;
    }
</style>
<script>
    window.onload=function () {
        document.getElementById("checkCode").onclick=function () {
            this.src="/checkCodeServlet?"+new Date().getTime();
        }
    }
</script>
<body>

<form action="/loginSer" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>验证码</td>
            <td>
                <input type="text" name="checkCode">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <img id="checkCode" src="/checkCodeSer" alt="">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
<div>
<%--    <%=--%>
<%--        request.getAttribute("cc_error")==null ? "" : request.getAttribute("cc_error")--%>
<%--    %>--%>
    ${requestScope.getAttribute("cc_error")}
</div>

<div>
<%--    <%=--%>
<%--        request.getAttribute("login_error")==null ? "" : request.getAttribute("login_error")--%>
<%--    %>--%>
    ${ requestScope.getAttribute("login_error")}
</div>
</body>
</html>
