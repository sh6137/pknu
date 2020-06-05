package swingevent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingEvent03 extends JFrame implements ActionListener{
	JButton btn1;
	JLabel lbl1;
	public SwingEvent03(){
		super("스윙 이벤트");
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("단추 1");
		this.add(btn1);
		btn1.addActionListener(this);
		
		lbl1 = new JLabel();
		this.add(lbl1);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingEvent03();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		lbl1.setText(btn.getText() + ":눌려짐");
	}
}
