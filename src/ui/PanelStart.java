package ui;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dataBase.DataBase;
import tools.MusicThread;
import tools.PicturePlayer;
import ui.button.ButtonClassic;
import ui.button.ButtonExit;
import ui.button.ButtonLoad;
import ui.button.ButtonNet;
import ui.button.ButtonSet;
import ui.button.ButtonStart;

/**
 * the first panel you see when you run the game
 * @author Cui
 *
 */
public class PanelStart extends JPanel implements Runnable{
	
	//define components
	Image startBackGround = null;
	ButtonStart startButton = null;
	ButtonExit exitButton = null;
	ButtonSet setButton = null;
	ButtonLoad loadButton = null;
	ButtonClassic classicButton = null;
	ButtonNet netButton = null;
	static MusicThread musicPlay  = new MusicThread("music/background/main.wav", true);
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
		netButton = new ButtonNet();
		
		
		//clear layout
		this.setLayout(null);
		
		//add listener
		startButton.addMouseListener(startButton);
		exitButton.addMouseListener(exitButton);
		setButton.addMouseListener(setButton);
		loadButton.addMouseListener(loadButton);
		classicButton.addMouseListener(classicButton);
		netButton.addMouseListener(netButton);
		
		//add buttons
		this.add(startButton);
		this.add(exitButton);
		this.add(classicButton);
		this.add(loadButton);
		this.add(setButton);
		this.add(netButton);
		
		//start thread
		Thread panel = new Thread(this);
		panel.start();
		Thread start = new Thread(startButton);
		start.start();
		Thread load = new Thread(loadButton);
		load.start();
		Thread exit = new Thread(exitButton);
		exit.start();
		Thread set = new Thread(setButton);
		set.start();
		Thread classic = new Thread(classicButton);
		classic.start();
		Thread net  = new Thread(netButton);
		net.start();
		
		setMusic();
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(startBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
		g.drawImage(new ImageIcon("graphics/background/starFast.gif").getImage(), 0, 0, 640, 400, this);
		g.drawImage(new ImageIcon("graphics/background/starSlow.gif").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		drawGif(g);
	}
	
	private void setMusic(){
		//close music

		Controller.gameframe.fightPanel.musicPlay.stopmusic();

		//create thread
		if(!isplay){
			musicPlay = new MusicThread("music/background/main.wav", true);
			musicPlay.start();
			isplay = true;
		}
	}
	
	public void drawGif(Graphics g){
		
		if(startButton.isIn==false){
			String[] picture1 = {"graphics/button/start1.png","graphics/button/start2.png","graphics/button/start3.png","graphics/button/start4.png","graphics/button/start5.png","graphics/button/start6.png","graphics/button/start7.png","graphics/button/start8.png","graphics/button/start9.png","graphics/button/start10.png"};
			PicturePlayer pic1 = new PicturePlayer(picture1, true, 3);
			pic1.panelPlay(490, 30, g, this, 0);
		}
		if(loadButton.isIn==false){
			String[] picture2 = {"graphics/button/load1.png","graphics/button/load2.png","graphics/button/load3.png","graphics/button/load4.png","graphics/button/load5.png","graphics/button/load6.png","graphics/button/load7.png","graphics/button/load8.png","graphics/button/load9.png","graphics/button/load10.png"};
			PicturePlayer pic2 = new PicturePlayer(picture2, true, 3);
			pic2.panelPlay(590, 150, g, this, 0);
		}
		if(exitButton.isIn1==false){
			String[] picture3 = {"graphics/button/exit1.png","graphics/button/exit2.png","graphics/button/exit3.png","graphics/button/exit4.png","graphics/button/exit5.png","graphics/button/exit6.png","graphics/button/exit7.png","graphics/button/exit8.png","graphics/button/exit9.png","graphics/button/exit10.png"};
			PicturePlayer pic3 = new PicturePlayer(picture3, true, 3);
			pic3.panelPlay(740, 330, g, this, 0);
		}
		if(setButton.isIn==false){
			String[] picture4 = {"graphics/button/help1.png","graphics/button/help2.png","graphics/button/help3.png","graphics/button/help4.png","graphics/button/help5.png","graphics/button/help6.png","graphics/button/help7.png","graphics/button/help8.png","graphics/button/help9.png","graphics/button/help10.png"};
			PicturePlayer pic4 = new PicturePlayer(picture4, true, 3);
			pic4.panelPlay(640, 210, g, this, 0);
		}
		if(classicButton.isIn==false){
			String[] picture5 = {"graphics/button/classic1.png","graphics/button/classic2.png","graphics/button/classic3.png","graphics/button/classic4.png","graphics/button/classic5.png","graphics/button/classic6.png","graphics/button/classic7.png","graphics/button/classic8.png","graphics/button/classic9.png","graphics/button/classic10.png"};
			PicturePlayer pic5 = new PicturePlayer(picture5, true, 3);
			pic5.panelPlay(540, 90, g, this, 0);
		}
		if(netButton.isIn==false){
			String[] picture6 = {"graphics/button/online1.png","graphics/button/online2.png","graphics/button/online3.png","graphics/button/online4.png","graphics/button/online5.png","graphics/button/online6.png","graphics/button/online7.png","graphics/button/online8.png","graphics/button/online9.png","graphics/button/online10.png"};
			PicturePlayer pic6 = new PicturePlayer(picture6, true, 3);
			pic6.panelPlay(690, 270, g, this, 0);
		}
		
	}

	@Override
	public void run() {
		while(!DataBase.threadContinue){
			startButton.setLocation(startButton.x, startButton.y);
			loadButton.setLocation(loadButton.x,loadButton.y);
			exitButton.setLocation(exitButton.x, exitButton.y);
			setButton.setLocation(setButton.x, setButton.y);
			classicButton.setLocation(classicButton.x, classicButton.y);
			netButton.setLocation(netButton.x, netButton.y);
			
	
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}
