package SwingLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutTest extends JFrame{
	GridBagLayoutTest(){
		super("GridBagLayoutTest");
		
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		JButton [] btns = new JButton[5];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton("단추" + i);
		}
		
		
		//constraints : 제약조건
		GridBagConstraints [] gbc = new GridBagConstraints[btns.length];
		
		gbc[0] = new GridBagConstraints();
		gbc[0].gridx = 0;
		gbc[0].gridy = 1;
		this.add(btns[0], gbc[0]);
		
		gbc[1] = new GridBagConstraints();
		gbc[1].gridx = 0;
		gbc[1].gridy = 2;
		this.add(btns[1], gbc[1]);
		
		gbc[2] = new GridBagConstraints();
		gbc[2].gridx = 1;
		gbc[2].gridy = 0;
		this.add(btns[2], gbc[2]);
		
		gbc[3] = new GridBagConstraints();
		gbc[3].gridx = 2;
		gbc[3].gridy = 0;
		this.add(btns[3], gbc[3]);
		
		gbc[4] = new GridBagConstraints();
		gbc[4].gridx = 1;
		gbc[4].gridy = 1;
		gbc[4].gridwidth = 2; //colspan
		gbc[4].gridheight = 2;//rowspan
		gbc[4].fill = GridBagConstraints.BOTH;
//		gbc[4].fill = GridBagConstraints.VERTICAL;		
//		gbc[4].fill = GridBagConstraints.HORIZONTAL;	
		this.add(btns[4],gbc[4]);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new GridBagLayoutTest();
	}
}
