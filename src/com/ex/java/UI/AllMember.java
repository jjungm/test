package com.ex.java.UI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.java.ex.DB.MemberModel;

public class AllMember extends JPanel {
	public AllMember() {
		JTable table = new JTable(new MemberModel());
		add(new JScrollPane(table));
	}
}
