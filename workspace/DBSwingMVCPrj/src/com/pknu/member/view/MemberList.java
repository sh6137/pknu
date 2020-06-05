package com.pknu.member.view;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pknu.member.dao.MemberDao;

public class MemberList extends JFrame {
	Vector 				 v;
	Vector<String>		 colNames;
	//추가할 컴포넌트
	DefaultTableModel	 model; //datamodel  데이터 그릇
	 
	
	JTable				 jt;
	JScrollPane				pane;
	JButton					btnInsert;
	public MemberList() {
		super("회원관리");
		
		initComponet();
		
		
		//화면크기조정
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setVisible(true);
		
	}
	private void initComponet() {
		// TODO Auto-generated method stub
		colNames = getColumnNames();
		
		MemberDao mDao = new MemberDao();
		v = mDao.getMemberList("");
		model = new DefaultTableModel(v, colNames);
		
		jt = new JTable(model);
		
	}
	private Vector<String> getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {

	}
}
