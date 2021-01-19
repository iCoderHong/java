package com.aj.controller.servlet;

import com.aj.doman.User;
import com.aj.service.UserService;
import com.aj.service.UserServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            User user = new User();
            BeanUtils.populate(user, parameterMap);

            UserService userService = new UserServiceImp();
            boolean ret = userService.updateUser(user);
            if (ret) {
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
                // 更新用户信息失败
                request.getRequestDispatcher("/update.jsp").forward(request, response);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
