package com.ex.java.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.java.ex.DB.MemberDao;
import com.java.ex.DB.MemberDto;

public class AddMember extends JPanel implements ActionListener {
	private JPanel jp[] = new JPanel[7];
	private JLabel jl[] = new JLabel[4];
	private JTextField tf[] = new JTextField[4];
	private JButton okButton;
	private JButton resetButton;
	
	String[] caption = {"ID :","PW :","이름 :","이메일 :"};
	
	public AddMember() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(7, 1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		add(new JPanel());
		
		for (int i=0; i<size; i++) {
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
		}
		
		jp[size] = new JPanel();
		okButton = new JButton("저장");
		okButton.addActionListener(this);
		resetButton = new JButton("다시");
		resetButton.addActionListener(this);
		jp[size].add(okButton);
		jp[size].add(resetButton);
		add(jp[size]);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String  aeType = ae.getActionCommand();
		MemberDao mDao = null;
		MemberDto mDto = null;
		
		if(aeType.equals(okButton.getText())) {
			try {
				mDto = new MemberDto(tf[0].getText(), tf[1].getText(), tf[2].getText(), tf[3].getText());
				mDao = new MemberDao();
				mDao.getMemberDtoRegiste(mDto);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(mDao != null) {
				JOptionPane.showConfirmDialog(this, tf[1].getText() + "님 추가!");
			}
			// click 이벤트 발생시 null로 다시 세팅
			else if (aeType.equals(resetButton.getText())) {
				int size = caption.length;
				for(int i=0; i<size-1; i++) tf[i].setText("");
			}
		}

	}

}
