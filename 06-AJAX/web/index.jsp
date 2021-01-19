<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2020/12/31
  Time: 下午11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>AJAX</title>
  </head>
  <body>

    <button id="send">发送网络请求</button>

    <div>
      响应结果:
      <span id="result" style="font-size: 14px; color: darkgreen">

      </span>
    </div>

  <script>
    window.onload = function () {
        let btn = document.getElementById("send");
        btn.onclick = function () {
          ajaxRequest3();
        }
    
        // 原生
        function ajaxRequest() {
          <%--
            AJAX的两种实现方式
              1.原生
              2.JQuery
                $.ajax()
                $.get()
                $.post()
          --%>
          var xmlhttp;
          if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
          } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
          }

          // xmlhttp.open("GET", "/ajax/ajaxServlet?username=tom&password=1177", true);
          // xmlhttp.send("username=tom&password=1177");

          xmlhttp.open("POST", "/ajax/ajaxServlet", true);
          // POST请求必须设置application/x-www-form-urlencoded
          xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')


          xmlhttp.onload = function () {
            document.getElementById("result").innerText = this.responseText;
          }

          xmlhttp.send("username=tom&password=1177");
        }
        
        function ajaxRequest2() {
          $.ajax({
            url: "/ajax/ajaxServlet",
            type: "POST",
            data: {"username" : "tom", "password" : "1177" },
            success: data => {
              document.getElementById("result").innerText = data;
            },
            error: error => {

            }
          });
        }

        function ajaxRequest3() {
          $.get("/ajax/ajaxServlet",{"username" : "tom", "password" : "1177" }, data => {
              document.getElementById("result").innerText = data;
            }, error => {

            }, "json");
        }

      function ajaxRequest4() {
        $.post("/ajax/ajaxServlet",{"username" : "tom", "password" : "1177" }, data => {
          document.getElementById("result").innerText = data;
        }, error => {

        }, "json");
      }
    }
  </script>

  <script src="./js/jQuery_3.5.1.js"></script>
  </body>
</html>
