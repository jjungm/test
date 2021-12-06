package com.java.ex2;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.ex.DB.MemberDao;
import com.java.ex.DB.MemberDto;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		MemberDao dao = new MemberDao();
		
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();// �޼��带 �޾ƿ��� dtos�� ���� 
		dtos = dao.mSelect(); // ����
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�޴��� ���� ���ּ��� (1.ȸ�� �߰�  2.ȸ���˻�  3.ȸ������  4.ȸ�� Ż��) : ");
		int menu = sc.nextInt();
		
		if (menu == 1) {
			String id = sc.next();
			String pw = sc.next();
			String name = sc.next();
			String email = sc.next();
			
			MemberDto dto = new MemberDto(id, pw, name,email);
			
			dao.getMemberDtoRegiste(dto);
			
		}else if (menu == 2) {
			
			// ������ŭ for���� ���� -> size() �̿�
			for(int i=1; i<=dtos.size(); i++) {
				// ������ŭ ������ 
				// dto ����
				MemberDto dto = dtos.get(i);
				
				System.out.println(dto.getId());
				System.out.println(dto.getPw());
				System.out.println(dto.getName());
				System.out.println(dto.getEmail());
			}
			
		}else if (menu == 3) {
			
		}else if (menu == 4) {
			
			String id = sc.next();
			System.out.println("������ ȸ���� ���̵� �Է��ϼ���.");
			//dao.delete(id);
			
		}else {
			
		}
		
		
		
		
	}

}
