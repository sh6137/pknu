package swingevent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//두번째 이벤트 처리방법
public class SwingEvent02 extends JFrame{
	
	JButton btn1, btn2, btn3;
	//ArrayList<JButton> btnList = new ArrayList<JButton>();
	JLabel lbl1;
	
	public SwingEvent02() {
		super("스윙 이벤트 02");
		
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		lbl1 = new JLabel("레이블");
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(lbl1);
		
		btn1.addActionListener(new BtnClick());
		btn2.addActionListener(new BtnClick());
		btn3.addActionListener(new BtnClick());
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new SwingEvent02();
	}
	
	private class BtnClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)  e.getSource();
			String text = btn.getText();
			System.out.println(text);
			lbl1.setText(text+"클릭");
		}
		
	}
}
