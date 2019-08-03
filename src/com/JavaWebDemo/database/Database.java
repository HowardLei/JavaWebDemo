package com.JavaWebDemo.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Database class
 *
 * @author apple
 * @date 2019-08-02
 */
public class Database {
    private static final String LOGIN_USER = "root";
    private static final String PASSWORD = "SweetieCan@0830";
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/JavaWebDemoDatabase?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = GMT";
        var mapList = new ArrayList<Map<String, String>>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, LOGIN_USER, PASSWORD);
            Statement statement = connection.createStatement();
            String query = "select * from user;";
            ResultSet resultSet = statement.executeQuery(query);
            // 获得表当中的数据
            while (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                var map = new HashMap<String, String>(1);
                map.put(userName, password);
                mapList.add(map);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        mapList.forEach(stringStringMap -> System.out.println(stringStringMap));
    }
    public static boolean hasData(String userName, String password) {
        var datas = getData();
        for (Map<String, String> data : datas) {
            if (data.get(userName) == password) {
                return true;
            }
        }
        return false;
    }
    private static List<Map<String, String>> getData() {
        var url = "jdbc:mysql://localhost:3306/JavaWebDemoDatabase?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = GMT";
        var mapList = new ArrayList<Map<String, String>>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, LOGIN_USER, PASSWORD);
            Statement statement = connection.createStatement();
            String query = "select * from user;";
            ResultSet resultSet = statement.executeQuery(query);
            // 获得表当中的数据
            while (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                var map = new HashMap<String, String>(1);
                map.put(userName, password);
                mapList.add(map);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return mapList;
    }
}
