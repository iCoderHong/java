<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ch.domain.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2020/12/26
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>

  <%-- jsp编译后生成也是一个Java Class --%>

  <%-- 代码片段 --%>
  <%
    int num = 20;
    System.out.println("Hello");
  %>

  <%-- JSP表达式 --%>
  <%=
    "hello World"
  %>

  <%=
    "<p style='color:red'>Hello World<p/>"
  %>

  <%-- JSP声明 --%>
  <%!
    private int age = 10;
    private String name = "Jack";

    private static void printLine() {
      System.out.println("=================");
    }
  %>

  <%
    printLine();
  %>

  <%= application.getAttribute("name") %>
  <%= session.getAttribute("name") %>
  <%= request.getAttribute("name") %>
  <%= pageContext.getAttribute("name") %>
  <%= request.getContextPath() %>

  <%-- EL工具包 是一个由Java开发的工具包 EL工具自动存在Tomcat中的lib(el-api.jar) --%>
  ${applicationScope["name"]}
  ${sessionScope["name"]}
  ${requestScope["name"]}
  ${pageScope["name"]}
  ${pageCotext.reqest.cotextPath}


  <%-- JSTL 依赖jar jstl-api-1.2.jar和 standard-1.1.2.jar --%>
  <c:set scope="session" var="age" value="23"></c:set>
  <c:if test="${sessionScope.age > 18}">
    <font color="red">age > 18</font>
  </c:if>
  <c:if test="${sessionScope.age < 18}">
    <font color="red">age < 18</font>
  </c:if>

  <c:set scope="page" var="sal" value="15000"></c:set>
  <c:choose>
    <c:when test="${pageScope.sal > 50000}">高工资</c:when>
    <c:when test="${pageScope.sal > 20000}">正常工资</c:when>
    <c:when test="${pageScope.sal > 10000}">正常工资</c:when>
    <c:otherwise>低工资</c:otherwise>
  </c:choose>

  <br>
  <select>
    <% for (int i = 0; i < 5; i++) { %>
    <option value="北京">第<%=i%>页</option>
    <% } %>
  </select>


  <select>
    <c:forEach var="i" begin="0" step="1" end="5">
      <option value="${i}">第${i}页</option>
    </c:forEach>
  </select>

  <c:forEach items="${pageScope.users}" var="user">
    ${user.name} ${user.age}
  </c:forEach>

  <c:forEach items="${users}" var="user">
    ${user.name} ${user.age}
  </c:forEach>

  </body>
</html>
