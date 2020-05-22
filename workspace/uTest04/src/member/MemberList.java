package member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MemberList extends JFrame {
	//Fields
	DefaultTableModel 	model;
	JTable 				jt;
	JScrollPane			pane;
	JPanel				pbtn;
	JButton				btnInsert;
	
	//제목이름들
	//String[] colNames = {"아이디","암호","이름","태어난연도"};
	Vector<String> colNames;
	
	Vector dataList;
	//생성자
	public MemberList() {
		super("회원목록");
		
		colNames = getColumnNames();
		
		try {
			dataList = getDataList();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		model = new DefaultTableModel(dataList ,colNames);
		
		jt = new JTable(model);
		pane = new JScrollPane(jt);
		this.add(pane);
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,300);
		this.setVisible(true);
	}
	
	private Vector getDataList() throws IOException {
		Vector list  = new Vector<>();
		
		MemberVO m;
		Vector  v;
		
		//파일처리
		File file = new File("bin\\member\\member.dat");
		System.out.println("현재 경로 : " + file.getAbsolutePath());
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line ="";
		while((line = br.readLine()) != null) {
			String[] str = line.trim().split(",");
			String uid = str[0].trim();
			String pwd = str[2].trim();
			String name = str[3].trim();
			int bYear = Integer.valueOf(str[4].trim());
			
			m = new MemberVO(uid, pwd, name, bYear);
			v = m.getVector();
			list.add(v);
		}
		
		
		br.close();
		fr.close();
		
		return list;
	}

	private Vector<String> getColumnNames() {
		Vector<String> colNames = new Vector<String>();
		colNames.add("아이디");
		colNames.add("암호");
		colNames.add("이름");
		colNames.add("나이");
		colNames.add("성인");
		
		return colNames;
	}

	public static void main(String[] args) {
		new MemberList();
	}
}
