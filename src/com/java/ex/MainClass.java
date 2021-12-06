package com.java.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MainClass {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/testdb"; 
	static String uid = "root";
	static String pwd = "123456";
	
	public static void main(String[] args) {
		// 총 객체 4개 생성 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		String query1 = "select * from member";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,uid,pwd);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			rsmd = rs.getMetaData();
			
			int cols = rsmd.getColumnCount(); // 총 4개가 들어감 
			
			// 컬럼 갯수 까지 찍는거라 같을 때까지 찍어줌 
			for(int i=1; i<=cols; i++)System.out.print(rsmd.getColumnName(i) + "\t");
			
			System.out.println(""); // 라인 변경 
			System.out.println("==========================================");
			
			while(rs.next()) { // 레코드를 찍음 
				String id = rs.getString("m_id");
				String pw = rs.getString("m_pw");
				String name = rs.getString("m_name");
				String email = rs.getString("m_email");
				System.out.println(id + "\t" + pw + "\t" + name + "\t" + email);
				// 한줄찍을 때마다 줄이 바뀜 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close(); // 메타데이터는 resultset을 닫으면 자동으로 닫히나봄
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
