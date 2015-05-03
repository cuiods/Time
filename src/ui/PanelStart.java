package ui;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tools.MusicPlayer;
import tools.MusicThread;
import ui.button.ButtonClassic;
import ui.button.ButtonExit;
import ui.button.ButtonLoad;
import ui.button.ButtonSet;
import ui.button.ButtonStart;

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
	MusicThread musicPlay  = new MusicThread("music/background/main.wav", true);
	static boolean isplay = false;
	
	public PanelStart(){
		//set the size of the panel
		this.setSize(Controller.gameframe.getWidth(), Controller.gameframe.getHeight());
		
		//load background image
		startBackGround = new ImageIcon("graphics/background/background.png").getImage();
		
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
		setButton.addMouseListener(setButton);
		loadButton.addMouseListener(loadButton);
		classicButton.addMouseListener(classicButton);
		
		//add buttons
		this.add(startButton);
		this.add(exitButton);
		this.add(classicButton);
		this.add(loadButton);
		this.add(setButton);
		
		setMusic();
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(startBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
	}
	
	private void setMusic(){
		//close music
		if(Controller.gameframe.fightPanel!=null){
			Controller.gameframe.fightPanel.musicPlay.stopmusic();
		}
		//create thread
		if(!isplay){
			musicPlay.start();
			isplay = true;
		}
	}
}
