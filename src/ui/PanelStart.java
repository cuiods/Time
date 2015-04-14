package ui;

import gamecontrol.*;

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
	ButtonLoad setButton = null;
	ButtonSet loadButton = null;
	ButtonClassic classicButton = null;
	
	public PanelStart(){
		//set the size of the panel
		this.setSize(Controller.gameframe.getWidth(), Controller.gameframe.getHeight());
		
		//load background image
		startBackGround = new ImageIcon("graphics/background/startbackground.jpg").getImage();
		//load button image
//		exitButtonImage = new ImageIcon("graphics/button/exitButton.png");
//		setButtonImage = new ImageIcon("graphics/button/setButton.png");
//		loadButtonImage = new ImageIcon("graphics/button/loadButton.png");
//		classicButtonImage = new ImageIcon("graphics/button/classicButton.png");
		
		//create buttons
		startButton = new ButtonStart();
		exitButton = new ButtonExit();
		setButton = new ButtonLoad();
		loadButton = new ButtonSet();
		classicButton = new ButtonClassic();
		
//		exitButton = new JLabel(exitButtonImage);
//		setButton = new JLabel(setButtonImage);
//		loadButton = new JLabel(loadButtonImage);
//		classicButton = new JLabel(classicButtonImage);
		
		//clear layout
		this.setLayout(null);
		
		//set location of the buttons
		startButton.setBounds(420,300,400,300);
		exitButton.setBounds(300, 200, 120, 100);
		
		//add listener
		startButton.addMouseListener(startButton);
		exitButton.addMouseListener(exitButton);
		
		//add buttons
		this.add(startButton);
		//this.add(exitButton);
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(startBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
	}
	
//	public void setIcon(String file, JButton iconButton) {  
//        ImageIcon icon = new ImageIcon(file);  
//        Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),  
//                iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);  
//        icon = new ImageIcon(temp);  
//        iconButton.setIcon(icon);  
//    }  
	
	
}
