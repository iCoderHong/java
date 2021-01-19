package com.aj.controller.servlet;

import com.aj.doman.PageBean;
import com.aj.doman.User;
import com.aj.service.UserService;
import com.aj.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pageUser")
public class PageUserServlet extends HttpServlet {
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_PAGE = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = DEFAULT_PAGE;
        int pageSize = DEFAULT_PAGE_SIZE;

        try {
            page = Integer.parseInt(request.getParameter("page"));
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImp();
        PageBean<User> pageBean = service.findUser(page, pageSize);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
