package ui;

import java.awt.*;

import javax.swing.*;

public class FrameGame extends JFrame{

	public PanelStart startPanel = null;
	public PanelFight fightPanel = null;
	
	public FrameGame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenSize.getWidth()-this.getWidth())/2, (int)((screenSize.getHeight()-this.getHeight())/2-20));
		
//		Rectangle bounds = new Rectangle( screenSize );
//		
//		this.setBounds(bounds);
		
		//sthis.setUndecorated(true);
		this.setVisible(true);
	}
	
	public void showFirstPanel(){
		startPanel = new PanelStart();
		this.setContentPane(startPanel);
	}
}


