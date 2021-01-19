<%@ page import="com.aj.doman.User" %><%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2020/12/24
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>

  <%
    User user = (User)session.getAttribute("user");
    if (user == null) {
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("/home").forward(request, response);
    }
  %>

  <%-- 等价下面写法
   <jsp:forward page="${sessionScope.user == null ? \"/login.jsp\" : \"/home\"}"></jsp:forward>
   --%>

  </body>
</html>
