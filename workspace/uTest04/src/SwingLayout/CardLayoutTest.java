package SwingLayout;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CardLayoutTest extends JFrame {
	
		CardLayout card;
		Container c;
	
	public CardLayoutTest() {
		this.setTitle("cardlayout");
		
		c = this.getContentPane();
		card = new CardLayout(40,30); //간격
		c.setLayout(card);
		
		JButton btn1 = new JButton("버튼");
		JButton btn2 = new JButton("버튼1");
		JButton btn3 = new JButton("버튼2");
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		
		btn1.addActionListener(new ButtonListener());
		btn2.addActionListener(new ButtonListener());
		btn3.addActionListener(new ButtonListener());
		
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new CardLayoutTest();
	} 
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
}
