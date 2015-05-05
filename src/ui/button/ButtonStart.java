package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.MusicPlayer;
import ui.PanelFight;
import ui.PanelStory0;



public class ButtonStart extends JLabel implements MouseListener{

	Image ButtonImage = null;
	String filepath = null;
	static boolean isIn = false;
	
	public ButtonStart(){

		filepath = "graphics/button/startButton1.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(400,400,170,170);
	}
	
	public void paintComponent(Graphics g){
		if(!isIn){
			filepath = "graphics/button/startbutton1.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}else{
			filepath = "graphics/button/startButtonMoveIn.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}
		g.drawImage(ButtonImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
//		Controller.gameframe.startPanel.setVisible(false);
//		Controller.gameframe.fightPanel = new PanelFight();
//		Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
//		
//		Thread ft = new Thread(Controller.gameframe.fightPanel);
//		ft.start();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
//		Controller.gameframe.startPanel.setVisible(false);
//		Controller.gameframe.fightPanel = new PanelFight();
//		Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
//		
//		Thread ft = new Thread(Controller.gameframe.fightPanel);
//		ft.start();
		
		//full screen (if needed)
//		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
//		gd.setFullScreenWindow(Controller.gameframe);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		Controller.gameframe.getContentPane().setVisible(false);
		Controller.gameframe.zero=new PanelStory0();
		Controller.gameframe.setContentPane(Controller.gameframe.zero);

		isIn = false;
		
		try {
			new MusicPlayer().play("music/effects/clicked.wav", false);
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		isIn = true;
		this.repaint();
		
		//play sound
		try {
			new MusicPlayer().play("music/effects/moveIn.wav", false);
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		this.repaint();
	}
}
