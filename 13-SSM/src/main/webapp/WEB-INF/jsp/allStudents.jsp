<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2021/1/18
  Time: 下午11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>所有学生</title>

    <style>
        table {
            /* 设置边框合并 */
            border-collapse: collapse;
            width: 500px;
            height: 100px;
            background-color: #f2f2f2;

            /* table的居中显示 */
            margin: 100px auto;
        }

        table td {
            border: 1px solid #000;
            text-align: center;
        }
    </style>
</head>
<body>

    <table align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年纪</th>
        </tr>
        <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
        </tr>
        </c:forEach>
    </table>

</body>
</html>
