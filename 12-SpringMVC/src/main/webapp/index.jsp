<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2021/1/5
  Time: 下午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Spring MVC</title>
    <script src="${pageContext.request.contextPath}/js/jQuery_3.5.1.js"></script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/hello.do">发送请求</a>
    <a href="${pageContext.request.contextPath}/user/regist.do?username=Tom">注册</a>
    <a href="<${pageContext.request.contextPath}/user/login.do">登录</a>

    <div>
        <button id="btn">发送AJAX请求</button>
    </div>

    <script>
        $(function () {
            $('#btn').click(function () {
                sendRequest()
            })
        })

        function sendRequest() {
            // let url = "${pageContext.request.contextPath}/user/info.do"
            // $.get(url, data => {
            //     alert(JSON.stringify(data))
            // } "json");

            // $.get('${pageContext.request.contextPath}/user/update.do', data => {
            //     $.each(data, function (i, n) {
            //         console.log(i, n)
            //     })
            // }, "json");

            $.get('${pageContext.request.contextPath}/user/name.do', data => {
                alert(data)
            }, "text");
        }
    </script>
</body>
</html>
