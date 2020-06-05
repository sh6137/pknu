package swingevent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class EventA implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트를 발생시킨 component를 알아낸다.
		JButton btn1 = (JButton) e.getSource();
		System.out.println(e.toString());
		String text = btn1.getText();
		System.out.println(text + "가 눌려졌습니다.");
		btn1.setText("바뀜");
	}
	
}

public class SwingEvent01 extends JFrame{
	
	JButton btn1, btn2, btn3;
	JLabel lbl1;
	public SwingEvent01() {
		super("스윙 이벤트 예제 1");
		
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("버튼클릭");
		btn2 = new JButton("버튼클릭");
		btn3 = new JButton("버튼클릭");
		lbl1 = new JLabel("여기에 출력");
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(lbl1);
		
		
		btn1.addActionListener(new EventA());
		btn2.addActionListener(new EventA());
		btn3.addActionListener(new EventA());
		
		this.setSize(400,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SwingEvent01();
	}
}
