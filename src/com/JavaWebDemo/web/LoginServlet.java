package com.JavaWebDemo.web;

import com.JavaWebDemo.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * LoginServlet class
 *
 * @author apple
 * @date 2019-08-02
 */
@WebServlet(name = "LoginServlet", description = "登录的Servlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    public static final String UTF8ENCODING = "utf-8";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<String> vector;
        var list = new ArrayList<String>();
        request.setCharacterEncoding(UTF8ENCODING);
        response.setCharacterEncoding(UTF8ENCODING);
        var userName = request.getParameter("userName");
        var password = request.getParameter("password");
        var resultJsonMap = new HashMap<String, String>();
        if (Database.hasData(userName, password)) {
            resultJsonMap.put("\"code\"", "\"200\"");
            resultJsonMap.put("\"message\"", "\"登录成功\"");
            response.sendRedirect("/JavaWebDemo/views/success.html");
        } else {
            resultJsonMap.put("\"code\"", "\"5-0\"");
            resultJsonMap.put("\"message\"", "\"登录失败\"");
            response.sendRedirect("/JavaWebDemo/views/failure.html");
        }
        var jsonObject = resultJsonMap.toString().replace('=', ':');
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
