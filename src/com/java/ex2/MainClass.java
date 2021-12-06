package com.java.ex2;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.ex.DB.MemberDao;
import com.java.ex.DB.MemberDto;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		MemberDao dao = new MemberDao();
		
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();// 메서드를 받아오는 dtos를 생성 
		dtos = dao.mSelect(); // 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴를 선택 해주세요 (1.회원 추가  2.회원검색  3.회원수정  4.회원 탈퇴) : ");
		int menu = sc.nextInt();
		
		if (menu == 1) {
			String id = sc.next();
			String pw = sc.next();
			String name = sc.next();
			String email = sc.next();
			
			MemberDto dto = new MemberDto(id, pw, name,email);
			
			dao.getMemberDtoRegiste(dto);
			
		}else if (menu == 2) {
			
			// 갯수만큼 for문을 돌아 -> size() 이용
			for(int i=1; i<=dtos.size(); i++) {
				// 갯수만큼 꺼내와 
				// dto 생성
				MemberDto dto = dtos.get(i);
				
				System.out.println(dto.getId());
				System.out.println(dto.getPw());
				System.out.println(dto.getName());
				System.out.println(dto.getEmail());
			}
			
		}else if (menu == 3) {
			
		}else if (menu == 4) {
			
			String id = sc.next();
			System.out.println("삭제할 회원의 아이디를 입력하세요.");
			//dao.delete(id);
			
		}else {
			
		}
		
		
		
		
	}

}
