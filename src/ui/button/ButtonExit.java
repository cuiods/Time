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
import ui.PanelStart;
import dataBase.DataBase;

public class ButtonExit extends JLabel implements MouseListener,Runnable{

	Image ButtonImage = null;
	String filepath = null;
	public boolean isIn1 = false;
	public boolean isIn2 = false;
	public int type = 0;
	public int x = 1050;
	public int y = 330;
	
	public ButtonExit(){
		filepath = "graphics/button/exitbutton1.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(x, y, 200, 50);
	}
	
	public void paintComponent(Graphics g){
		if(type == 0){
			if(isIn1){
				filepath = "graphics/button/exitbutton1.png";
				ButtonImage = new ImageIcon(filepath).getImage();
			}else{
				filepath = "graphics/button/exitButtonMoveIn.png";
				ButtonImage = new ImageIcon(filepath).getImage();
			}
		}else if(type == 1||type == 2||type==3||type==4){
			if(!isIn1&&type == 1){
				filepath = "graphics/button/close.png";
			}else if(type == 1){
				filepath = "graphics/button/close1.png";
			}
			if(!isIn2&&type == 2){
				filepath = "graphics/button/exitset.png";
			}else if(isIn2&&type == 2){
				filepath = "graphics/button/exitset1.png";
			}
			if(!isIn2&&type == 3){
				filepath = "graphics/button/back.png";
			}else if(isIn2&&type == 3){
				filepath = "graphics/button/back1.png";
			}
			if(!isIn2&&type == 4){
				filepath = "graphics/button/exitset.png";
			}else if(isIn2&&type == 4){
				filepath = "graphics/button/exitset1.png";
			}
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
		if(type == 0 || type == 1){
			Controller.exitGame();
		}else if(type == 2){
			Controller.changeTo(FrameGame.FIGHTPANEL);
			isIn1 = false;
			isIn2 = false;
			DataBase.isPause = false;
		}else if(type == 3){
			isIn1 = false;
			isIn2 = false;
			Controller.changeTo(FrameGame.STARTPANEL);
		}else if(type == 4){
			Controller.changeTo(FrameGame.CLASSICPANEL);
			isIn1 = false;
			isIn2 = false;
			DataBase.isPause = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(type == 1||type == 0){
			isIn1 = true;
		}else{
			isIn2 = true;
		}
		this.repaint();
		
		new MusicThread("music/effects/moveIn.wav", false).start();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
			isIn1 = false;
			isIn2 = false;
		this.repaint();
		
	}

	@Override
	public void run() {
		while(x>=750){
			x-=20;
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
