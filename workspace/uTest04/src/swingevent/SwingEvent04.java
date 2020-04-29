package swingevent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SwingEvent04 extends JFrame{
	JButton btn1;
	JTextField txt1;
	
	
	
	public SwingEvent04() {
		super("스윙 이벤트");
		this.setLayout(new FlowLayout());
		
		txt1 = new JTextField(20);
		this.add(txt1);
		
		btn1 = new JButton("새버튼");
		this.add(btn1);
		
		/*익명 클래스 기법
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.toString());
				String txtString = txt1.getText() + "님 안녕하세요";
				System.out.println(txtString);
			}
		});
		*/
		//람다식 : java1.8이상에만 작동
		btn1.addActionListener((e)->{
			System.out.println(e.toString());
			String txtString = txt1.getText() + "님 안녕하세요";
			System.out.println(txtString);
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingEvent04();
	}
}
