package com.aj.controller.servlet;

import com.aj.doman.User;
import com.aj.service.UserService;
import com.aj.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUser")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id == null) {
            request.getRequestDispatcher("/home").forward(request, response);
            return;
        }

        UserService userService = new UserServiceImp();
        User user = userService.findUser(id);
        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } else {
            // 更新失败
        }
    }
}
