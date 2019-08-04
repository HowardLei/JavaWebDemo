package com.JavaWebDemo.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ${NAME} class
 *
 * @author apple
 * @date 2019-08-03
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"}, description = "注册Servlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(LoginServlet.UTF8ENCODING);
        response.setCharacterEncoding(LoginServlet.UTF8ENCODING);
        var user = request.getParameter("accountTextField");
        var password = request.getParameter("password1");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
