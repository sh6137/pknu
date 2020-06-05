package SwingLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

public class BorderLayoutTest extends JFrame{
	public BorderLayoutTest() {
		//프레임 제목을 출력
		this.setTitle("BorderLayout 테스트");
		
		this.setLayout(new BorderLayout());
		//Component 를 배치한다.
		JButton btn1 = new JButton("단축1");
		JButton btn2 = new JButton("단축2");
		JButton btn3 = new JButton("단축3");
		JButton btn4 = new JButton("단축4");
		JButton btn5 = new JButton("단축5");
		JButton btn6 = new JButton("단축6");
		JButton btn7 = new JButton("단축7");
		
		this.add(btn1, BorderLayout.NORTH);
		this.add(btn2, BorderLayout.EAST);
		this.add(btn3, BorderLayout.WEST);
		this.add(btn4, BorderLayout.SOUTH);
		
		JPanel pan1 = new JPanel(new FlowLayout());
		pan1.add(btn5);
		pan1.add(btn6);
		pan1.add(btn7);
		this.add(pan1,BorderLayout.CENTER);
		//프레임을 보여준다
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BorderLayoutTest();
	}
}
