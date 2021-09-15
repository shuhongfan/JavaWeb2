<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/9/14
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HTML5文档-->
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
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrapValidator.min.css">
    <script src="js/bootstrapValidator.min.js"></script>
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
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <label class="radio-inline">
                <input type="radio" name="gender" id="inlineRadio1" value="男" checked> 男
            </label>
            <label class="radio-inline">
                <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
            </label>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" placeholder="请输入邮箱地址"/>
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
