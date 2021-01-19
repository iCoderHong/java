<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2020/12/24
  Time: 下午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
    </style>
</head>
<body>

    <div id="login">--%>
        <form action="${pageContext.request.contextPath}/login" method="post">--%>
            <div>--%>
                <label>用户名:</label><input type="text" name="username" autocomplete="off">--%>
            </div>--%>
            <div>--%>
                <label>密&nbsp&nbsp码:</label><input type="text" name="password autocomplete="off">--%>
            </div>--%>
            <div>--%>
                <input type="submit" value="提交">--%>
            </div>--%>
        </form>--%>
    </div>--%>

</body>
</html>
