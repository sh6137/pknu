package SwingLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class FlowLayoutTest extends JFrame {

	public FlowLayoutTest() {
		super("플로우레이아웃 테스트");
		 getContentPane().setLayout(new FlowLayout());
		 
		 
		 
		 ArrayList<JButton> btnList = new ArrayList<JButton>();
		 for (int i = 0; i < 10; i++) {
			btnList.add(new JButton("버튼" + (i+1)));
			this.add(btnList.get(i));
			btnList.get(i).addActionListener((e)->{
				
				//String msg = btnList.get(i).getText();
				JButton  btn = (JButton) e.getSource();
				String msg = btn.getText();
				System.out.println(msg);
			});
		 }
		 
		 
		 /*
		 JButton [] btns = new JButton[30];
		 for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton("버튼" + i);
			this.add(btns[i]);
			
			final int index =i;
			btns[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String msg = btns[index].getText();
					System.out.println(msg);
					
				}
			});
		}
		 */
//		 JButton btn1 = new JButton("단추1");
//		 this.add(btn1);
//		 JButton btn2 = new JButton("단추2");
//		 this.add(btn2);
//		 JButton btn3 = new JButton("단추3");
//		 this.add(btn3);
//		 JButton btn4 = new JButton("단추4");
//		 this.add(btn4);
//		 JButton btn5 = new JButton("단추5");
//		 this.add(btn5);
		 
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 this.setSize(400,300);
		 this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutTest(); 
	}

}
