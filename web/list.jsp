<%@ page import="java.util.List" %>
<%@ page import="com.shf3.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/14
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            if (confirm("您确定要删除吗？"))
            location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
        }

        window.onload=function () {
            // 给删除选中按钮添加单击时间
            document.getElementById("delSelect").onclick=function () {
                let cbs = document.getElementsByName("uid");
                let flag=false;
                for (let i = 0; i < cbs.length; i++) {
                    if (cbs[i].checked){
                        flag=true;
                        break;
                    }
                }
                if (flag==false) alert("没有被选中的用户")
                else if (confirm("您确定要删除选中吗？"))
                // 表单提交
                document.getElementById("form").submit();
            }
            document.getElementById("firstCheckbox").onclick=function () {
                // 获取所有的cb
                let cbs = document.getElementsByName("uid");
                for (let i = 0; i < cbs.length; i++) {
                    cbs[i].checked=this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left">
        <form action="${pageContext.request.contextPath}/findUserByPageServlet" method="post" class="form-inline">
            <div class="form-group">
                <label for="name">姓名</label>
                <input name="name" type="text" class="form-control" id="name" value="${condition.name[0]}">
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <input name="address" type="text" class= "form-control" id="address" value="${condition.address[0]}">
            </div>
            <div class="form-group">
                <label for="email">EMAIL</label>
                <input name="email" type="text" class="form-control" id="email" value="${condition.email[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0)" id="delSelect">删除选择</a>
    </div>
    <form id="form" method="post" action="${pageContext.request.contextPath}/delSelectServlet">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>
                    <input type="checkbox" id="firstCheckbox">
                </th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <th>
                        <input type="checkbox" name="uid" value="${user.id}">
                    </th>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>


    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="<c:if test="${pb.currentPage==1}">disabled</c:if>">
                <a class="<c:if test="${pb.currentPage==1}">btn disabled</c:if>" href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"><span aria-hidden="true">&laquo;</span></a>
            </li>
            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <li class=" <c:if test="${pb.currentPage==i}">active</c:if>">
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                </li>

            </c:forEach>

            <li class="<c:if test="${pb.currentPage==pb.totalPage}">disabled</c:if>">
                <a class="<c:if test="${pb.currentPage==pb.totalPage}">btn disabled</c:if>" href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage+1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"><span aria-hidden="true">&raquo;</span></a>
            </li>
            <span style="font-size: 25px">共 ${pb.totalCount} 条记录， 共 ${pb.totalPage}  页</span>
        </ul>
    </nav>
</div>
</body>
</html>
