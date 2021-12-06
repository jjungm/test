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

public class FindMember extends JPanel implements ActionListener {
	private JPanel jp[] = new JPanel[7];
	private JLabel jl[] = new JLabel[4];
	private JTextField tf[] = new JTextField[4];
	private JButton okButton;
	private JButton resetButton;

	String[] caption = {"ID :","PW :","이름 :","이메일 :"};
	
	public FindMember() {
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
			if(i==0 || i==1) tf[i].setEditable(true);
			
		}
		
		jp[size] = new JPanel();
		okButton = new JButton("조회");
		okButton.addActionListener(this);
		resetButton = new JButton("다시");
		resetButton.addActionListener(this);
		jp[size].add(okButton);
		jp[size].add(resetButton);
		add(jp[size]);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		String  aeType = ae.getActionCommand();
		MemberDao mDao = null;
		MemberDto mDto = null;
		
		// ok 버튼 click 이벤트 발생시 액션 구성
		// 회원 검색 후 정보 노출 dao 객체 이용
		if(aeType.equals(okButton.getText())) {
			try {
				mDao = new MemberDao();
				String id = tf[0].getText().trim();
				
				if(!id.equals("")) mDto = mDao.getMemberCheck(id);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(mDto != null) {
				tf[0].setText(mDto.getId());
				tf[1].setText(mDto.getPw());
				tf[2].setText(mDto.getName());
				tf[3].setText(mDto.getEmail());
			}else {
				JOptionPane.showMessageDialog(this, "검색 실패");
			}
		}else if (aeType.equals(resetButton.getText())) {
			int size = caption.length;
			for(int i=0; i<size; i++) tf[i].setText("");
		}
		
	}
	

}
