package com.java.ex.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/testdb"; 
	static String uid = "root";
	static String pwd = "123456";
	
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		return con;
	}
}
