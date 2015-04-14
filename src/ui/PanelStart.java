package ui;

import gameControl.*;

import java.awt.*;

import javax.swing.*;

import ui.button.*;

/**
 * the first panel you see when you run the game
 * @author Cui
 *
 */
public class PanelStart extends JPanel{
	
	//define components
	Image startBackGround = null;
	ButtonStart startButton = null;
	ButtonExit exitButton = null;
	ButtonSet setButton = null;
	ButtonLoad loadButton = null;
	ButtonClassic classicButton = null;
	
	public PanelStart(){
		//set the size of the panel
		this.setSize(Controller.gameframe.getWidth(), Controller.gameframe.getHeight());
		
		//load background image
		startBackGround = new ImageIcon("graphics/background/startbackground.jpg").getImage();
		
		//create buttons
		startButton = new ButtonStart();
		exitButton = new ButtonExit();
		setButton = new ButtonSet();
		loadButton = new ButtonLoad();
		classicButton = new ButtonClassic();
		
		
		//clear layout
		this.setLayout(null);
		
		//add listener
		startButton.addMouseListener(startButton);
		exitButton.addMouseListener(exitButton);
		
		//add buttons
		this.add(startButton);
		this.add(exitButton);
		this.add(classicButton);
		this.add(loadButton);
		this.add(setButton);
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(startBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
	}
	
	
}
