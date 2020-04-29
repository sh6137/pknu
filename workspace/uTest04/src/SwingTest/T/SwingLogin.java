package SwingTest.T;

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

	// 생성자
	public SwingLogin() {
		super("첫번째 프레임");
		
		this.setLayout(new GridLayout(3, 2));
		
		// 컵포넌트 생성
		JLabel      lblUserId = new JLabel("아이디");
		this.add( lblUserId );
		
		JTextField  txtUserID = new JTextField(10);
		this.add(  txtUserID  );
		
		JLabel     lblPassword = new JLabel("암호");
		this.add( lblPassword );

		JPasswordField   pwPass = new JPasswordField(10);
		this.add(pwPass);
		
		JButton    btnOk = new JButton("로그인");
		this.add(btnOk);
		
		JButton    btnCancel = new JButton("취소");
		this.add(btnCancel);
		
		// 이벤트 연결
		// 버튼을 누르면
		btnOk.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				System.out.println("로그인 버튼을 클릭하였습니다");
				
				String uid  =  txtUserID.getText().toLowerCase().trim();
				// @ : annotation - 컴파일러에게 알려주는 설정정보 : 바로 다음라인에 적용
				@SuppressWarnings("deprecation")   
				String pwd  =  pwPass.getText().toLowerCase().trim();
				//String pwd  =  new String(pwPass.getPassword());
				String result  = getLogin(uid, pwd);
				System.out.println(result);
			}

			private String getLogin(String uid, String pwd) {
				
				String result = null;
				
				File            file = new File("E:\\pknu\\workspace\\uTest04\\src\\SwingTest\\T\\member.dat");  // (.clss)assembly 가 존재하는 경로(현재 경로)
				FileReader      fr   = null;
				BufferedReader  br   = null;
				try {
					fr   = new FileReader(file);
					br   = new BufferedReader(fr);
					
					String line = ""; 
					while( (line = br.readLine()) != null  ) {
						if( line.startsWith(uid)  ) {
							// 아이디가 있다
							String [] mem   = line.split(",");
							String  memid   = mem[0];  
							String  mempass = mem[1];  
							String  memname = mem[2];
							
							if( memid.equals(uid)  ) {
								if ( mempass.equals(pwd) ) {
									if( br != null )  br.close();
									if( fr != null )  fr.close();
									return memname;  // 아이디와 암호 일치
								} else {
									if( br != null )  br.close();
									if( fr != null )  fr.close();
									return "암호가 틀립니다";
								}
							} 						
						} 
					}
					if( br != null )  br.close();
					if( fr != null )  fr.close();
					return "아이디가 일치하지 않습니다";
				} catch (FileNotFoundException e) {					
					System.out.println( "member.dat 파일없음");
				} catch (IOException e) {					
					System.out.println( "오류발생:" + e.getMessage() );					
				} 		
				return result;
			}
			
		} );
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소 버튼을 클릭하였습니다");				
			}
		});
		
		pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.setSize(400, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingLogin();
	}

}