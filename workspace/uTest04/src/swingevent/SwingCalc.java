package swingevent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SwingCalc extends JFrame implements ActionListener{
	
	JTextField txt1, txt2;
	JButton btnAdd, btnSub, btnMul, btnDiv;
	JLabel lbl;
	public SwingCalc() {
		this.setTitle("계산기");
		getContentPane().setLayout(new FlowLayout());
		
		txt1 = new JTextField("0",20);
		txt1.setHorizontalAlignment(SwingConstants.TRAILING);
		txt2 = new JTextField("0",20);
		txt2.setToolTipText("zzzz");
		txt2.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.ORANGE);
		btnMul = new JButton("Mul");
		btnMul.setForeground(Color.BLUE);
		btnDiv = new JButton("Div");
		btnSub = new JButton("Sub");
		btnSub.setForeground(Color.CYAN);
		lbl = new JLabel("결과");
		
		getContentPane().add(txt1);
		getContentPane().add(txt2);
		getContentPane().add(btnAdd);
		
		getContentPane().add(btnSub);
		
		getContentPane().add(btnMul);
		getContentPane().add(btnDiv);
		getContentPane().add(lbl);
		
		btnSub.addActionListener(this);
		btnAdd.addActionListener(this);
		btnMul.addActionListener(this);
		btnDiv.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300,400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingCalc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		System.out.println(btn.getText());
		String text1 = txt1.getText();
		String text2 = txt2.getText();
		int num1 = Integer.valueOf(text1);
		int num2 = Integer.valueOf(text2);
		
		if(btn.getText().equals("Add")) {
			
			String msg = String.valueOf(num1+num2) ;
			lbl.setText(msg);
		}
		else if(btn.getText().equals("Sub")) {
			
			String msg = String.valueOf(num1-num2) ;
			lbl.setText(msg);
		}
		else if(btn.getText().equals("Mul")) {
			
			String msg = String.valueOf(num1*num2) ;
			lbl.setText(msg);
		}
		else if(btn.getText().equals("Div")) {
			if(num2 == 0) {
				lbl.setText("2번째 값은 0");
				return;
			}
			String msg = String.valueOf(num1/num2) ;
			lbl.setText(msg);
		}
		
		
	}
}
