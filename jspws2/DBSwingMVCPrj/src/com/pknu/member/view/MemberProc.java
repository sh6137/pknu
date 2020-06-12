package com.pknu.member.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.pknu.member.dao.MemberDao;
import com.pknu.member.vo.MemberVO;

//개인정보 : 조회, 추가 , 수정, 삭제
public class MemberProc extends JFrame implements ActionListener{
	
	MemberList memberList;
	//layout
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	//componment 부품
	JPanel p;
	JTextField txtId, txtName, txtRdate ;
	JComboBox cbJob;
	JPasswordField txtPwd;
	JRadioButton rbMan, rbWoman;
	JTextArea taIntro;
	JButton btnInsert, btnCancel, btnUpdate, btnDelete;
	//기본생성자(화면설정)
	public MemberProc() {
		super("회원상세정보");
		createUI();//화면구성
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(400,600);
		this.setVisible(true);
		
		
	}

	public MemberProc(MemberList memberList) {
		this();
		this.memberList = memberList;
		buttonSetting(1);
	}
	
	public MemberProc(String uid, MemberList memberList) {
		
		this(memberList);
		MemberDao mDao = new MemberDao();
		MemberVO mem = mDao.getMember(uid);
		viewData(mem);
		buttonSetting(2);
	}

	private void buttonSetting(int type) {
		switch (type) {
		case 1:
			this.btnInsert.setEnabled(true);
			this.btnUpdate.setEnabled(false);
			this.btnDelete.setEnabled(false);
			this.btnCancel.setEnabled(true);
			break;
		
		case 2:
			this.btnInsert.setEnabled(false);
			this.btnUpdate.setEnabled(true);
			this.btnDelete.setEnabled(true);
			this.btnCancel.setEnabled(true);
			break;
			
		default:
			break;
		}
		
	}

	private void viewData(MemberVO mem) {
		String id =mem.getId();
		String oldPwd = mem.getPwd();
		String name = mem.getName();
		String job = mem.getJob();
		String gender = mem.getGender();
		String intro  = mem.getIntro();
		
		this.txtId.setText(id);
		this.txtName.setText(name);
		this.cbJob.setSelectedItem(job);
		if(gender.equals("M"))
			this.rbMan.setSelected(true);
		if(gender.equals("F"))
			this.rbWoman.setSelected(true);
		
		this.taIntro.setText(intro);
		
		
	}

	//화면에 부품 배치
	private void createUI() {
		//layout 설정
		
		gb	=	new GridBagLayout();
		this.getContentPane().setLayout(gb);
		
		gbc					= new GridBagConstraints();
		gbc.fill 			= GridBagConstraints.BOTH;
		gbc.weightx			= 1.0;
		gbc.weighty 		= 1.0;
		
		//아이디
		JLabel lblId = new JLabel("아이디 : ");
		txtId = new JTextField(20);
		//그리드백에 붙이기
		gbAdd(lblId,0,0,1,1);
		gbAdd(txtId,1,0,3,1);
		
		//비밀번호
		JLabel  ldlPwd = new  JLabel("암호");
		txtPwd  = new JPasswordField(20);
		gbAdd(ldlPwd, 0, 1, 1, 1);
		gbAdd(txtPwd, 1, 1, 3, 1);
		//이름
		JLabel  lblName = new  JLabel("이름");
		txtName  = new JTextField(20);
		gbAdd(lblName, 0, 2, 1, 1);
		gbAdd(txtName, 1, 2, 3, 1);
		//직업
		JLabel  lblJob = new  JLabel("직업");
		String [] jobList = {"-","학생","회사원","공무원","무직"};
		cbJob  = new JComboBox(jobList);
		gbAdd(lblJob, 0, 3, 1, 1);
		gbAdd(cbJob, 1, 3, 3, 1);
		
		
		//성별
		JLabel  lblGender = new  JLabel("성별");
		rbMan = new JRadioButton("남자", true); //미리선택 true
		rbWoman = new JRadioButton("여자", false);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rbMan);
		btnGroup.add(rbWoman);
		
		JPanel panGender = new JPanel();
		
		panGender.add(rbMan);
		panGender.add(rbWoman);
		
		
		gbAdd(lblGender, 0, 4, 1, 1);
		gbAdd(panGender, 1, 4, 3, 1);
		
		
		
		//자기소개
		
		JLabel  lblIntro = new  JLabel("자기소개");
		taIntro = new JTextArea(5,20);
		JScrollPane paneIn = new JScrollPane(taIntro);
		gbAdd(lblIntro, 0, 5, 1, 1);
		gbAdd(taIntro, 1, 5, 3, 1);
		
		//날짜
		JLabel  lblRdate = new  JLabel("날짜");
		txtRdate = new JTextField(20);
		gbAdd(lblRdate, 0, 6, 1, 1);
		gbAdd(txtRdate, 1, 6, 3, 1);
		
		
		//버튼
		JPanel panBtn = new JPanel();
		btnInsert		=new JButton("Add");
		btnUpdate		=new JButton("Update");
		btnDelete		=new JButton("Delete");
		btnCancel		=new JButton("Cancel");
		
		panBtn.add(btnInsert);
		panBtn.add(btnUpdate);
		panBtn.add(btnDelete);
		panBtn.add(btnCancel);
		
		gbAdd(panBtn,1,7,4,1);
		
		
		//기혼/미혼
//		JLabel lblMarried = new JLabel("혼인 : ");
//		JRadioButton rbMarried = new JRadioButton("기혼", true);
//		JRadioButton rbNotMarried = new JRadioButton("미혼", true);
//		
//		JPanel panMarried =new JPanel();
		
		
		//이벤트 추가
		//버튼이 클릭될 때 수행할 함수(Event Handler)를 연결
		this.btnInsert.addActionListener(this);
		this.btnUpdate.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnCancel.addActionListener(this);
		
		
		
		//람다식
		this.btnCancel.addActionListener((e)->{
			System.out.println("취소버튼 클릭");
			this.dispose(); //현재 창 닫기
			System.out.println();
		});
		
		
		//익명함수방식
//		this.btnCancel.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		
	}
	
	
	//그리드백레이아웃에 부품을 붙이는 메소드
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight =h;
		
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		this.getContentPane().add(c, gbc);
	}

	//버튼이 클릭 될 때 수행할 문장
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		JButton btn = (JButton) e.getSource();
		switch(btn.getText()) {
		case "Add":
			System.out.println(btn.getText() + "버튼클릭");
			insertMember();
			System.out.println("회원추가 완료");
			
			break;
		case "Update":
			System.out.println(btn.getText() + "버튼클릭");
			//updateMember();
			break;
		case "Delete":
			System.out.println(btn.getText() + "버튼클릭");
			deleteMember();
			break;
		//case "Cancel":
		//	break;
		}
		memberList.jtRefresh(); //MemberList 에 있는 jtable 을 새로고침 한다.
	}
	public MemberVO getViewData(){
		String id = this.txtId.getText();
		//String pwd = String.valueOf(this.txtPwd.getPassword());
		char[] cpwd = this.txtPwd.getPassword();
		String pwd = new String(cpwd);
		String name = this.txtName.getText();
		String job = (String) this.cbJob.getSelectedItem();
		String gender ="";
		if(this.rbMan.isSelected() ==true) gender ="M";
		if(this.rbWoman.isSelected() ==true) gender ="F";
		//남자가 선택되면 "M" 여자 "F"
		String intro = this.taIntro.getText();
		MemberVO mem =new MemberVO(id, pwd, name, job, gender, intro);
		return mem;
	}
	
	//회원추가 : db에 저장
	private void insertMember() {
		MemberDao mDao  = new MemberDao();
		MemberVO mem = getViewData();
		boolean ok = mDao.insertMember(mem);
		//성공 다이얼로그
		String msg = "추가되었습니다.";
		JOptionPane.showMessageDialog(null, msg,"회원가입",JOptionPane.OK_OPTION);
		System.out.println(ok);
		textClear();
	}
	
	
	//회원삭제 : 
	private void deleteMember() {
		MemberDao mDao = new MemberDao();
		MemberVO mem = getViewData();
		boolean ok = mDao.deleteMember(mem);
		String msg = "삭제됨.";
		textClear();
	}
	//회원 갱신
//	private void updateMember() {
//		MemberDao mDao = new MemberDao();
//		MemberVO mem = getViewData();
//		boolean ok = mDao.updateMember(mem);
//		String msg = "갱신됨.";
//		textClear();
//	}
	

	private void textClear() {
		this.txtId.setText("");
		this.txtName.setText("");
		this.txtPwd.setText("");
		this.taIntro.setText("");
	}
	
	
}
