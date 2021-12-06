package com.java.ex.DB;

// 테이블의 속성을 멤버로 가져감 
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	
	// private으로 되어 있어 getter setter 생성 
	public MemberDto(String id, String pw, String name, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	


}
