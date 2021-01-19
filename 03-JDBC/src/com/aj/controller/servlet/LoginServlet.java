package com.aj.controller.servlet;

import com.aj.doman.User;
import com.aj.service.UserService;
import com.aj.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
       String password = req.getParameter("password");
       UserService service = new UserServiceImp();
       User user = service.findUser(name, password);

       if (user != null) {
           HttpSession session = req.getSession();
           session.setAttribute("user", user);
           resp.sendRedirect("/jdbc/home");
       } else {
           req.getRequestDispatcher("/login.jsp").forward(req, resp);
       }
    }
}
