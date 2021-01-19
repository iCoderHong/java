<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2021/1/9
  Time: 下午12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
    <div align="center">
        <p>SSM整合开发的例子</p>
        <table>
            <tr>
                <td><a href="${pageContext.request.contextPath}/addStudent.jsp">注册学生</a></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><a href="${pageContext.request.contextPath}/student/allStudents.do">查看学生</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
