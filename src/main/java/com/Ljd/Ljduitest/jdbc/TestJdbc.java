package com.Ljd.Ljduitest.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {
	 public static void main(String[] args) throws Exception{
	        //3.通过数据库的连接操作数据库，实现增删改查
		 	Connection conn = DBUtil.getConnection();
	        Statement stmt = conn.createStatement();
	        //ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句   ，返回一个结果集（ResultSet）对象。
	        ResultSet rs = stmt.executeQuery("SELECT UID,UserAccount,LoginPwd FROM acc_accountinfo"
	        		+ " WHERE UserAccount = '13641734598'");
	        while(rs.next()){//如果对象中有数据，就会循环打印出来
	            System.out.println(rs.getInt("UID")+","+rs.getString("UserAccount")+","+rs.getString("LoginPwd"));
	        }
	    }
}
