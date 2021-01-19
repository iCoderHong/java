<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2020/12/24
  Time: 下午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>

    <link href="./css/bootstrap.css" rel="stylesheet">
    <link href="./css/signin.css" rel="stylesheet">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>
<body class="text-center">

    <main class="form-signin">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <img class="mb-4" src="./imgs/login.JPG" alt="" width="72" height="57">
            <h1 class="h3 mb-3 fw-normal">登录</h1>
            <label for="name" class="visually-hidden">Email address</label>
            <input type="username" id="name" class="form-control" name="name" placeholder="账号" required autofocus>
            <label for="password" class="visually-hidden">Password</label>
            <input type="password" id="password" class="form-control" name="password" placeholder="密码" required>
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">登录</button>
            <p class="mt-5 mb-3 text-muted">&copy; 1225-2020</p>
        </form>
    </main>

</body>
</html>
