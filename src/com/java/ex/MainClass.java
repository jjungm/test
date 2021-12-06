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
		// �� ��ü 4�� ���� 
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
			
			int cols = rsmd.getColumnCount(); // �� 4���� �� 
			
			// �÷� ���� ���� ��°Ŷ� ���� ������ ����� 
			for(int i=1; i<=cols; i++)System.out.print(rsmd.getColumnName(i) + "\t");
			
			System.out.println(""); // ���� ���� 
			System.out.println("==========================================");
			
			while(rs.next()) { // ���ڵ带 ���� 
				String id = rs.getString("m_id");
				String pw = rs.getString("m_pw");
				String name = rs.getString("m_name");
				String email = rs.getString("m_email");
				System.out.println(id + "\t" + pw + "\t" + name + "\t" + email);
				// �������� ������ ���� �ٲ� 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close(); // ��Ÿ�����ʹ� resultset�� ������ �ڵ����� ��������
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
