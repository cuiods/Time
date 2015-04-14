package ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonExit;

public class PanelFight extends JPanel{

	Image fightBackGround = null;
	ButtonExit butExit = null;
	
	public PanelFight(){
		
		fightBackGround = new ImageIcon("graphics/background/fightbackground1.jpg").getImage();
		butExit = new ButtonExit();
		butExit.setIcon(new ImageIcon("graphics/button/close.png"));
		butExit.setBounds(920, 10, 50, 50);
		butExit.addMouseListener(butExit);
		
		this.setLayout(null);
		this.add(butExit);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(fightBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
	}

}
