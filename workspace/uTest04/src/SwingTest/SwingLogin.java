package SwingTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingLogin extends JFrame {
	//생성자
	public SwingLogin() {
		super("");
		
		this.setLayout(new GridLayout(3,2));
		
		//컴포넌트 생성
		
		JLabel lblUserId = new JLabel("아이디");
		this.add(lblUserId);
		
		JTextField txtUserID = new JTextField("");
		this.add(txtUserID);
		
		JLabel lblPassword = new JLabel("암호");
		this.add(lblPassword);
		
		JPasswordField pwPass = new JPasswordField();
		this.add(pwPass);
		
		JButton btnOk = new JButton("로그인");
		this.add(btnOk);

		JButton btnCancel = new JButton("쥐소");
		this.add(btnCancel);
		
		//이벤트 연결
		//버튼을 클릭하면
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("로그인 버튼을 클릭하였습니다.");
				
				
				String uid = txtUserID.getText();
				
				String pwd = pwPass.getText();
				String result = getLogin(uid,pwd);
				System.out.println(result);
				
//				System.out.println(txtUserID.getText());
//				System.out.println(pwPass.getPassword());
//				char[] a = pwPass.getPassword();
//				String aa = String.valueOf(a);
//				System.out.println(aa);
//				if(txtUserID.getText().equals("sky") && aa.equals("blue")) {
//					System.out.println("환영");
//				}
//				else {
//					System.out.println("아이디나 비번이 틀립니다.");
//				}
			}

			private String getLogin(String uid, String pwd) {
				String result = null;
				File file = new File("E:\\pknu\\workspace\\uTest04\\src\\SwingTest\\member.dat"); //assembly가 존재하는 경로(현재 경로)
				FileReader fr = null;
				BufferedReader br = null;
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					String line ="";
					while((line= br.readLine()) != null) {
						if( line.startsWith(uid)) {
							//아이디가 있다.
							String [] mem = line.split(",");
							String memid = mem[0];
							String mempass = mem[1];
							String memname = mem[2];
							
							if(memid.equals(uid)) {
								if(mempass.equals(pwd)) {
									if(br != null) br.close();
									if(fr != null) fr.close();
									return memname; //아이디와 암호 일치
								}else {
									if(br != null) br.close();
									if(fr != null) fr.close();
									return "암호가 틀립니다.";
								}
							}
							
						}
							
					}
					return "아이디가 일치하지 않습니다.";
				} catch (FileNotFoundException e) {
					
					System.out.println("member.txt 파일없음");
				} catch (IOException e) {
					System.out.println("오류발생 : " + e.getMessage());
				}  
				finally {
						try {
							if(br != null) br.close();
							if(fr != null) fr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					
				}
				
				return result;
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("캔슬 버튼을 클릭하였습니다.");
				
			}
		});
		
		pack();
		//컴포넌트 배치
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//this.setSize(300,400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingLogin();
	}
	
	
}
