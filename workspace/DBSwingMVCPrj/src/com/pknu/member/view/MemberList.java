package com.pknu.member.view;

import java.awt.BorderLayout;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pknu.member.dao.MemberDao;

public class MemberList extends JFrame 
    implements ActionListener, MouseListener {
	
	Vector              v;
	Vector<String>      colNames;  // 제목줄
	
	DefaultTableModel   model;    // datamodel
	
	// 추가할 컴포넌틉 록록
	JTable              jt;
	JScrollPane         pane;  
	JPanel              jpn1;
	JButton             btnInsert, btnRefresh;
	
	MemberProc memberProc;
	// 생성자
	public MemberList() {
		// 제목줄
		super("회원관리 프로그램 ver 1.0");
		
		initComponent();  // 컴포넌트 배치
		
		// 화면 크기 조정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 800);
		this.setVisible(true);
	}
	
	// 화면 배치, 부품배치
	private void initComponent() {
		// 제목줄
		colNames        =  getColumnNames();
		
		MemberDao  mDao =  new MemberDao();
		v               =  mDao.getMemberList("");
		
		model   =  new DefaultTableModel(v, colNames);  // v :Vector, data집합
		
		jt      =  new JTable( model );
		pane    =  new JScrollPane( jt );
		this.add( pane );
		
		// 화면상단에 회원가입버튼
		jpn1       = new JPanel();
		btnInsert  = new JButton("회원가입"); 
		btnRefresh = new JButton("새로고침");
		jpn1.add( btnInsert );
		jpn1.add( btnRefresh );
		
		this.add( jpn1, BorderLayout.NORTH );
		
		// 회원가입버튼을 누르면 작동 : 이벤트 연결
		 // addActionListener() 함수를 사용하려면 반드시 
		 // 인터페이스를 implement하여야한다
		btnInsert.addActionListener( this ); 
		btnRefresh.addActionListener( this );
		    // 이벤트 처리를 내 객첵 에게 맡긴다(위임)
		//jtable에 대한 마우스 이벤트를 추가한다.
		jt.addMouseListener(this);
		
	}

	// Jtable 에 제목줄 설정
	private Vector<String> getColumnNames() {
		Vector<String> titles = new Vector<String>();
		
		titles.add("아이디");
		titles.add("암호");
		titles.add("이름");
		titles.add("직업");
		titles.add("성별");
		titles.add("자기소개");
		titles.add("가입일");
		
		return   titles;
	}

	public static void main(String [] args) {
		new MemberList();
	}
	// Jtable 새로고침
	public void jtRefresh(){
		MemberDao mDao = new MemberDao();
		DefaultTableModel model = new DefaultTableModel(
				mDao.getMemberList(""), getColumnNames());
		jt.setModel(model);
	}
	
	//  btnInsert 를 클릭하엿을대 수행할 명령 작성하는 곳
	@Override
	public void actionPerformed(ActionEvent e) {
		if (  e.getSource() == btnInsert ) {		
			System.out.println("bntnInsert 가 클릭되엇습니다");
			new MemberProc(this);
		}else {
			if(e.getSource() == btnRefresh) {
				jtRefresh();
			}
		}
		
	}
	//Mouse 관련 이벤트들 : addMouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		int selRow = jt.getSelectedRow();
		System.out.println("선택한 줄번호 : " + selRow );
		String uid = String.valueOf(jt.getValueAt(selRow, 0)); ;
		System.out.println(uid);
		
		
		if(memberProc ==null) {
			memberProc = new MemberProc(uid, this);
		}else {
			memberProc.dispose();
			memberProc = new MemberProc(uid, this);
		}
		memberProc.setLocation(650,150);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
