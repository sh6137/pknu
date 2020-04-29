package uTest04;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest01 extends JFrame {
	//Frame : AWT - OS 부품을 호출
	//Jframe : Swing window 와 unix 사이의 그래픽 차이를 극복하려고 별도의 라이브러리
	JButton btn1,btn2,btn3,btn4,btn5;
	//생성자
	
	public SwingTest01() {
		super("스윙 테스트 연습"); // 부모생성자 호출
		
		setLayout(new FlowLayout());
		btn1 = new JButton("버튼");
		btn2 = new JButton("버튼");
		btn3 = new JButton("버튼");
		btn4 = new JButton("버튼");
		btn5 = new JButton("버튼");
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new SwingTest01();
	}
}
