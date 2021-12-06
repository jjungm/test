package com.ex.java.UI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
	private JTabbedPane tp;
	
	private AddMember addMem;
	private FindMember findMem;
	private AllMember allMem;
	
	public MainFrame() {
		// tap 활용
		tp = new JTabbedPane();
		addMem = new AddMember();
		findMem = new FindMember();
		allMem = new AllMember();
		
		tp.addTab("멤버 입력", addMem);
		tp.addTab("멤버 조회", findMem);
		tp.addTab("멤버 전체", allMem);
		
		getContentPane().add(tp);
		setTitle("멤버 관리");
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainFrame(); // 실행

	}

}
