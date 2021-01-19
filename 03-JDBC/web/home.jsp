<%@ page import="java.util.List" %>
<%@ page import="com.aj.doman.User" %>
<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2020/12/25
  Time: 下午3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>首页</title>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <link href="./css/bootstrap.css" rel="stylesheet">

    <style>
        .container {
            padding-top: 60px;
        }

        .container h3 {
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="container">
        <h3 class="text-primary">用户信息列表</h3>

        <div style="float: left">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="address">籍贯</label>
                    <input type="address" class="form-control" id="address" name="address">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>

        <div style="float: right; margin: 0 5px 5px 0">
            <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
            <a type="button" class="btn btn-primary" href="javascript:void(0);" id="delete_selecetd_user">删除选中联系人</a>
        </div>

        <form id="form" action="${pageContext.request.contextPath}/deleteSelectUser" method="post">
            <table class="table table-striped table-bordered table-hover table-condensed">
                <tr class="success">
                <th><input id="first_checkbox" type="checkbox"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
                <c:forEach items="${pageBean.list}" var="user">
                    <tr>
                        <td><input type="checkbox" name="uid" value="${user.id}"></td>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.gender == 1 ? "男" : "女"}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq}</td>
                        <td>${user.email}</td>
                        <td style="text-align: center">
                            <a class="btn btn-primary btn-xs"
                               href="${pageContext.request.contextPath}/findUser?id=${user.id}">编辑
                            </a>
                            <a class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/deleteUser?id=${user.id}">删除
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>

        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${pageBean.currPage > 1}">
                        <li>
                            <a href="${pageContext.request.contextPath}/home?page=${pageBean.currPage - 1}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach var="i" begin="1" step="1" end="${pageBean.pageCount}">
                        <li class="${pageBean.currPage == i ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/home?page=${i}">${i}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pageBean.currPage < pageBean.pageCount}">
                        <li>
                            <a href="${pageContext.request.contextPath}/home?page=${pageBean.currPage + 1}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>

    </div>

    <script>
        window.onload = function () {
            let element = document.getElementById("delete_selecetd_user");
            element.onclick = function () {

                if (!deleteEnableCheck()) {
                    alert("您未选中任何要删除的用户")
                    return
                }

                if (confirm("您确认要删除选中的用户吗")) {
                    let form = document.getElementById("form")
                    form.submit()
                }
            }

            let firstCheckBox = document.getElementById("first_checkbox")
            firstCheckBox.onclick = function () {
                let selected = this.checked
                let elements = document.getElementsByName("uid")
                for (let element of elements) {
                    element.checked = selected
                }
            }

            function deleteEnableCheck() {
                let enableDelete = false

                let elements = document.getElementsByName("uid")
                for (let element of elements) {
                    if(element.checked == true) {
                        enableDelete = true
                        break
                    }
                }
                return enableDelete
            }
        }
    </script>
    <script src="./js/jQuery_3.5.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./js/bootstrap.js"></script>
</body>
</html>
