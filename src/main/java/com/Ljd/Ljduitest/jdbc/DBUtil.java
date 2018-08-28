package com.Ljd.Ljduitest.jdbc;

import java.sql.*;

public class DBUtil {

    //这里可以设置数据库名称
    private final static String URL = "jdbc:sqlserver://192.168.8.25;DatabaseName=TopJetP2PTest";
    private static final String USER="qa";
    private static final String PASSWORD="qa@566560.com";
    
    private static Connection conn=null;
    //静态代码块（将加载驱动、连接数据库放入静态块中）
    static{
        try {
            //1.加载驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.获得数据库的连接
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("连接数据库成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
    }
    
    //对外提供一个方法来获取数据库连接
    public static Connection getConnection(){
        return conn;
    }
}