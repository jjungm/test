package com.java.ex.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDao {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	public MemberDto getMemberDtoRegiste(MemberDto mDto) throws Exception{
		String query = "insert into member values(?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = DBUtil.getConnection();
			// PreparedStatement �� �̿��Ͽ� DB�� �Է� ������ ���
			
			pst = con.prepareStatement(query);
			pst.setString(1, mDto.getId());
			pst.setString(2, mDto.getPw());
			pst.setString(3, mDto.getName());
			pst.setString(4, mDto.getEmail());
			int i = pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// DB �ڿ� ����
				if (pst != null) pst.close();
				if (con != null) con.close();
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
		return mDto;
	}
	
	public MemberDto getMemberCheck(String id) throws Exception{
		String query = "select * from member where id=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		MemberDto mDto = null;
		
		try {
			con = DBUtil.getConnection();
			// PreparedStatement �� �̿��Ͽ� id�� �������� db���� ���� �˻�
			
			pst = con.prepareStatement(query);
			pst.setString(1,id);
			rs = pst.executeQuery();
			
			// �˻� ����� dto ��ü�� ����
			if (rs.next()) mDto = new MemberDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// DB �ڿ� ����
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
		return mDto;
	}

	
	public ArrayList<MemberDto> mSelect() {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		String query = "select * from member"; // ������ ���� �־ rs �� ���� �ָ� 
		// �÷��� ->  MemberDto �������� ������'
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) { // rs���� ����� �� dto�� ���� ( �Ķ���� ���� ��� ����) 
				String id = rs.getString("m_id");
				String pw = rs.getString("m_pw");
				String name = rs.getString("m_name");
				String email = rs.getString("m_email");
				
				MemberDto dto = new MemberDto(id, pw, name, email);
				//rs���� �޾ƿ��°� �ƴ� dto�� ���� �־ ����?�÷��� ���� 
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	
	
	public ArrayList<String> getMemberColumn() {
		ArrayList<String> mColumns = new ArrayList<String>();
		String query = "select * from member"; // ������ ���� �־ rs �� ���� �ָ� 
		// �÷��� ->  MemberDto �������� ������'
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			rsmd = rs.getMetaData(); // member ���̺��� �Ӽ��� ����
			
			int colCount = rsmd.getColumnCount();
			
			for (int i=1; i<=colCount; i++) mColumns.add(rsmd.getColumnName(i));

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return mColumns;
	}
	
}
