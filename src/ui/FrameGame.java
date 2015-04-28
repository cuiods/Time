package ui;

import java.awt.*;

import javax.swing.*;

public class FrameGame extends JFrame{

	
	public PanelStart startPanel = null;
	public PanelFight fightPanel = null;
    public StoryPlayer storyPlayer = null;
    public PanelLoading loadingPanel = null;
	
	public FrameGame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenSize.getWidth()-this.getWidth())/2, (int)((screenSize.getHeight()-this.getHeight())/2-20));
		
//		Rectangle bounds = new Rectangle( screenSize );
//		
//		this.setBounds(bounds);
		
		//set cursor
		Toolkit toolkit = Toolkit.getDefaultToolkit();   
		Image image = toolkit.getImage("graphics/icon/cursor.png");
		Cursor c = toolkit.createCustomCursor(image , new Point(5,5), "icon/cursor.png");  
		this.setCursor (c);
		
		this.setUndecorated(true);
		this.setVisible(true);
	}
	
	public void showFirstPanel(){
		startPanel = new PanelStart();
		this.setContentPane(startPanel);
	}
}


