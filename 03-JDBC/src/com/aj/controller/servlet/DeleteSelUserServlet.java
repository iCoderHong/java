package com.aj.controller.servlet;

import com.aj.service.UserService;
import com.aj.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectUser")
public class DeleteSelUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] uids = request.getParameterValues("uid");
        if (uids.length == 0) {
            response.sendRedirect( request.getContextPath() + "/home");
            return;
        }

        UserService userService = new UserServiceImp();
        boolean ret = userService.deleteUser(uids);
        if (ret) {
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            // TODO: 删除失败
        }
    }
}
