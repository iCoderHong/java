<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2020/12/31
  Time: 上午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>编辑用户</title>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <link href="./css/bootstrap.css" rel="stylesheet">

    <script src="./js/jQuery_3.5.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./js/bootstrap.js"></script>

    <style>
        .container {
            padding-top: 30px;
        }

        .container h3 {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h3 class="text-primary">更新用户信息</h3>
            <form action="${pageContext.request.contextPath}/updateUser" method="post">
                <input type="hidden" name="id" value="${requestScope.user.id}">
                <div class="form-group">
                    <label for="name">用户名</label>
                    <input type="text" class="form-control" id="name" name="name" value="${requestScope.user.name}">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password"
                           value="${requestScope.user.password}">
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="text" class="form-control" id="age" name="age" value="${user.age}">
                </div>
                <div class="checkbox">
                    <label style="padding-left: 0">
                        <input type="radio" name="gender" value="1" <c:if test="${user.gender == 1}">checked</c:if>> 男
                    </label>
                    <label>
                        <input type="radio" name="gender" value="2" <c:if test="${user.gender == 2}">checked</c:if>> 女
                    </label>
                </div>
                <div class="form-group">
                    <label for="qq">QQ</label>
                    <input type="text" class="form-control" id="qq" name="qq" value="${user.qq}">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                </div>
                <div class="form-group">
                    <label for="address">地址</label>
                    <input type="text" class="form-control" id="address" name="address" value="${user.address}">
                </div>
                <button type="submit" class="btn btn-primary">确认</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
