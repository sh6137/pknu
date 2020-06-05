package swingevent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//이벤트 처리
//adapter 클래스 활용 : 필요한 이벤트 만 사용한다.
public class SwingEvent05 extends JFrame {
	JButton btn1;
	JLabel la = new JLabel("Hello");
	public SwingEvent05() {
		super("스윙 이벤트");
		this.setLayout(new FlowLayout());
		btn1 = new JButton("OK");
		
		this.add(la);
		la.setLocation(30,30);
		
		this.add(btn1);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter());
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println(x+"+"+y);
			la.setLocation(x,y);
		}
	}
	public static void main(String[] args) {
		new SwingEvent05();
	}
}
