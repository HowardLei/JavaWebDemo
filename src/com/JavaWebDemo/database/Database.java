package com.JavaWebDemo.database;

import java.sql.*;
import java.util.*;

/**
 * Database class
 *
 * @author apple
 * @date 2019-08-02
 */
public class Database {
    private static final String LOGIN_USER = "root";
    private static final String PASSWORD = "SweetieCan@0830";

    public static boolean hasData(String userName, String password) {
        var datas = getData();
        for (Map<String, String> data : datas) {
            if (data.get(userName).equals(password) && data.get(userName) != null) {
                return true;
            }
        }
        return false;
    }

    /***
     * 向数据库当中添加用户名和密码
     * @param userName 需要添加的用户名
     * @param password 需要添加的密码
     */
    public static void addData(String userName, String password) {
        try {
            var statement = linkDatabase();
            var insertQuery = String.format("insert into user (userName, password) values ('%s', '%s');", userName, password);
            System.out.println(insertQuery);
//            ResultSet resultSet = statement.executeQuery(insertQuery);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 从数据库当中查找数据。
     * @return 查找的结果。每个结果保存到一个列表当中。
     */
    private static List<Map<String, String>> getData() {
        var mapList = new ArrayList<Map<String, String>>();
        try {
            Statement statement = linkDatabase();
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

    /***
     * 连接数据库
     * @return
     * @throws ClassNotFoundException 当连接 MySQL 的驱动类加载不出来的时候，抛出该错误。
     * @throws SQLException 当连接创建失败，抛出该错误。
     */
    private static Statement linkDatabase() throws ClassNotFoundException, SQLException {
        var url = "jdbc:mysql://localhost:3306/JavaWebDemoDatabase?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = GMT";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, LOGIN_USER, PASSWORD);
        Statement statement = connection.createStatement();
        return statement;
    }
}
