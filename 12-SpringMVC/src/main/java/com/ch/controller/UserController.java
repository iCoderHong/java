package com.ch.controller;

import com.ch.doman.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

   /**
    * GET方法 提交数据小 有缓存(优化) POST方法 支持提交大数据 相对安全 没有缓存
    * 1.默认GET和POST都支持
    * 2.若请求方式不支持 服务端默认响应405
    * 如果在方法中定义了HttpServletRequest request, HttpServletResponse response, HttpSession session 框架会进行赋值
    */

   @RequestMapping(value = "/regist.do", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
   // public ModelAndView register(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
   public ModelAndView register(@RequestParam(value = "username", required = false) String name, Integer age) { // 逐个参数接收: 请求名与形参名必须保持一致
      // @RequestParam解决参数名称与形参不一致的问题
      System.out.println(name + " " + age);
      ModelAndView mv = new ModelAndView();
      mv.addObject("username", name);
      mv.addObject("age", age);

      // 如果目标页面在试图解析器目录下, 可以简写为试图名称
      mv.setViewName("regist");
      // 如果目标页面不再试图解析器指定的目录下 需要单独指定完成的路径 因为forward:不和试图解析器一起工作
      // mv.setViewName("forward:/WEB-INF/view/regist.jsp");

      // 重定向 mv.setViewName("redirect:视图全路径(不需要项目名)"); 同样redirect:不和试图解析器一起工作

      return mv;
   }

   @RequestMapping(value = "/login.do")
   public ModelAndView login(User user, Boolean isVistor) {
      ModelAndView mv = new ModelAndView();
      mv.addObject("user", user);
      mv.setViewName("login"); // 等价 request.getRequestDispatcher("login").forward(request, response);
      return mv;
   }

   /*
   返回值代表当前响应结果
   返回值类型
      ModelAndView 数据和视图
      String 仅仅视图
      Void 针对AJAX请求
      Object
   */
   @RequestMapping("/save.do")
   public String save(HttpServletRequest request, String username, Integer age){
      request.setAttribute("username", username);
      request.setAttribute("age", age);
      return "save"; // 仅仅返回视图
   }

   /**
    * 没有返回值 比如AJAX的请求 用的很少(通过返回Object替代(List Map String Student))
    * @param response
    * @throws IOException
    */
   @RequestMapping("/info.do")
   public void userInfo(HttpServletResponse response) throws IOException {
      // 创建数据模型
      User user = new User();
      user.setUsername("Jack");
      user.setAge(20);

      // 对象 ==> JSON (MappingJackson2HttpMessageConverter代替)
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(user);

      // 服务端响应json数据(@ResponseBody代替)
      response.setContentType("application/json;charset=utf-8");
      response.getWriter().println(json);
   }

   // 返回对象类型
   @ResponseBody
   @RequestMapping("/update.do")
   public Object findUser() {
      // HttpMessageConverter接口负责序列化与反序列化
      // MediaType;
      // MappingJackson2HttpMessageConverter
      User user1 = new User("Jack", 10);
      User user2 = new User("Rose", 20);
      User user3 = new User("Jim", 30);
      List<User> userList = new ArrayList<>();
      userList.add(user1); userList.add(user2); userList.add(user3);
      return userList;
   }

   @ResponseBody
   @RequestMapping(value = "/name.do", produces = "text/plain;charset=utf-8")
   public String username() {
      // 如果返回字符串 默认Content-Type: text/html;charset=ISO-8859-1
      // 注解@Produces 用于定义方法的响应实体的数据类型
      return "Jack 呵呵"; // 如果没有指定@ResponseBody返回的字符串代表是视图名称 一旦指定@ResponseBody 代表返回响应的数据
   }
}
