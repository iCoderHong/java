package com.aj.controller.servlet;

import com.aj.service.UserService;
import com.aj.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
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
        boolean ret = userService.deleteUser(id);
        request.getRequestDispatcher("/home").forward(request, response);
    }
}
