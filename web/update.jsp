<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/14
  Time: 15:05
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-2.1.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrapValidator.min.css">
    <script src="/js/bootstrapValidator.min.js"></script>
    <script>
        $(function () {
            $("form").bootstrapValidator({
                live:"enable",
                message: 'This value is not valid',
                submitButtons:"#submit",
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    name: {
                        message: '姓名验证失败',
                        validators: {
                            notEmpty: {
                                message: '姓名不能为空'
                            },
                            stringLength: {
                                min: 2,
                                max: 18,
                                message: '用户名长度必须在2到18位之间'
                            }
                        }
                    },
                    gender: {
                        message: '性别验证失败',
                        validators: {
                            notEmpty: {
                                message: '性别不能为空'
                            }
                        }
                    },
                    age: {
                        message: '年龄验证失败',
                        validators: {
                            notEmpty: {
                                message: '年龄不能为空'
                            }
                        }
                    },
                    address: {
                        message: '籍贯验证失败',
                        validators: {
                            notEmpty: {
                                message: '籍贯不能为空'
                            }
                        }
                    },
                    qq: {
                        message: 'QQ验证失败',
                        validators: {
                            notEmpty: {
                                message: 'QQ不能为空'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: '邮箱地址不能为空'
                            },
                            emailAddress: {
                                message: '邮箱地址格式有误'
                            }
                        }
                    }
                }
            });
        });
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" value="${user.name}">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <label class="radio-inline">
                <input type="radio" <c:if test="${user.gender=='男'}">checked</c:if> name="gender" id="inlineRadio1" value="男" > 男
            </label>
            <label class="radio-inline">
                <input type="radio" <c:if test="${user.gender=='女'}">checked</c:if> name="gender" id="inlineRadio2" value="女"> 女
            </label>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄" value="${user.age}">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东" <c:if test="${user.address=='广东'}">selected</c:if>> 广东</option>
                <option value="广西"<c:if test="${user.address=='广西'}">selected</c:if>>广西</option>
                <option value="湖南"<c:if test="${user.address=='湖南'}">selected</c:if>>湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" placeholder="请输入QQ号码" value="${user.qq}"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" placeholder="请输入邮箱地址" value="${user.email}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <button type="submit"  id="subLogin" class="btn text-muted text-center btn-danger" >添加</button>
            <input class="btn btn-default" type="reset" value="重置" />
            <input id="reset" class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>