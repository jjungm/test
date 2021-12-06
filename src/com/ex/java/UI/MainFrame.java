package com.ex.java.UI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
	private JTabbedPane tp;
	
	private AddMember addMem;
	private FindMember findMem;
	private AllMember allMem;
	
	public MainFrame() {
		// tap Ȱ��
		tp = new JTabbedPane();
		addMem = new AddMember();
		findMem = new FindMember();
		allMem = new AllMember();
		
		tp.addTab("��� �Է�", addMem);
		tp.addTab("��� ��ȸ", findMem);
		tp.addTab("��� ��ü", allMem);
		
		getContentPane().add(tp);
		setTitle("��� ����");
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainFrame(); // ����

	}

}
