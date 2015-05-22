package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.MusicPlayer;
import tools.MusicThread;
import ui.FrameGame;

public class ButtonSet extends JLabel implements MouseListener,Runnable{
	Image ButtonImage = null;
	String filepath = null;
	public boolean isIn = false;
	public int x = 950;
	public int y = 210;
	public ButtonSet(){
		filepath = "graphics/button/setButton.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(x, y, 200, 50);
	}
	
	public void paintComponent(Graphics g){
		if(isIn){
			filepath = "graphics/button/helpbutton1.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}else{
			filepath = "graphics/button/helpButtonMoveIn.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}
		g.drawImage(ButtonImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		new MusicThread("music/effects/clicked.wav", false).start();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Controller.changeTo(FrameGame.HELPPANEL);
		isIn = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		this.repaint();
		
		new MusicThread("music/effects/moveIn.wav", false).start();
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		this.repaint();
		
	}

	@Override
	public void run() {
		while(x>=650){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			x-=20;
		}
		
	}

}
