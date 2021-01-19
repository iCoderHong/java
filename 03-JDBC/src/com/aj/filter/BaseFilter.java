package com.aj.filter;

import com.aj.doman.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.tools.tree.ThisExpression;

import javax.naming.Name;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@WebFilter(urlPatterns = {"/*"}, initParams = {
            @WebInitParam(name = "includeUrl", value = "/jdbc/index.jsp;/jdbc/login.jsp;/jdbc/login;/jdbc/"),
            @WebInitParam(name = "includeSuffix", value=".jpg;.png;.PNG;.JPG;.css;.js")
        })
public class BaseFilter implements Filter {
    private List<String> includeUrl;
    private List<String> includeSuffix;

    public void init(FilterConfig config) throws ServletException {
        String includeUrl = config.getInitParameter("includeUrl");
        this.includeUrl = Arrays.asList(includeUrl.split(";"));
        String includeSuffix = config.getInitParameter("includeSuffix");
        this.includeSuffix = Arrays.asList(includeSuffix.split(";"));
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String URI = request.getRequestURI();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user != null || this.includeUrl.contains(URI) || this.containSuffix(URI)) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    public void destroy() {

    }

    private boolean containSuffix(String URI) {
        for (String suffix : this.includeSuffix) {
            if (URI.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }
}
