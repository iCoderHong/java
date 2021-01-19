<%--
  Created by IntelliJ IDEA.
  User: coderhong
  Date: 2021/1/1
  Time: 上午10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Jedis</title>

    <script src="./js/jQuery_3.5.1.js"></script>

  </head>
  <body>
    <span>Hello Jedis</span>

    <div>
      <a href="javascript:void(0)" id="city_list">获取城市列表</a>

      <div><p id="data"></p></div>
    </div>

    <div>
      <select id="city"></select>
    </div>

  <script>
    window.onload = () => {
      let element = document.getElementById("city_list");
      element.onclick = e => {
        loadCityList();
      }

      loadCityList();
    }

    function loadCityList() {
      $.get("/jedis/cityList", data => {
        let json = JSON.stringify(data); // JSON对象 ==> JSON字符串
        $("#data").text(json);

        for (let city of data) {
          let option = $("<option value=" + city.id +">" + city.name + "</option>");
          $("#city").append(option);
        }
      }, error => {

      }, "json");
    }
  </script>
  </body>
</html>
