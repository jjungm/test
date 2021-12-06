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
			// PreparedStatement 를 이용하여 DB에 입력 정보를 기록
			
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
				// DB 자원 해제
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
			// PreparedStatement 를 이용하여 id를 기준으로 db에서 정보 검색
			
			pst = con.prepareStatement(query);
			pst.setString(1,id);
			rs = pst.executeQuery();
			
			// 검색 결과를 dto 객체를 담음
			if (rs.next()) mDto = new MemberDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// DB 자원 해제
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
		String query = "select * from member"; // 쿼리가 여기 있어서 rs 는 들어가기 애매 
		// 컬랙션 ->  MemberDto 형식으로 만들어둠'
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) { // rs으로 담았을 때 dto를 생성 ( 파라미터 값이 들어 있음) 
				String id = rs.getString("m_id");
				String pw = rs.getString("m_pw");
				String name = rs.getString("m_name");
				String email = rs.getString("m_email");
				
				MemberDto dto = new MemberDto(id, pw, name, email);
				//rs으로 받아오는게 아닌 dto에 값을 넣어서 한줄?컬럼을 생성 
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
		String query = "select * from member"; // 쿼리가 여기 있어서 rs 는 들어가기 애매 
		// 컬랙션 ->  MemberDto 형식으로 만들어둠'
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			rsmd = rs.getMetaData(); // member 테이블의 속성을 담음
			
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
