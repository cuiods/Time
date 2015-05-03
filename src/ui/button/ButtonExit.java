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
import ui.PanelStart;
import dataBase.DataBase;

public class ButtonExit extends JLabel implements MouseListener{

	Image ButtonImage = null;
	String filepath = null;
	static boolean isIn1 = false;
	static boolean isIn2 = false;
	public int type = 0;
	public ButtonExit(){
		filepath = "graphics/button/exitbutton1.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(660, 400, 140, 140);
	}
	
	public void paintComponent(Graphics g){
		if(type == 0){
			if(!isIn1){
				filepath = "graphics/button/exitbutton1.png";
				ButtonImage = new ImageIcon(filepath).getImage();
			}else{
				filepath = "graphics/button/exitButtonMoveIn.png";
				ButtonImage = new ImageIcon(filepath).getImage();
			}
		}else if(type == 1||type == 2||type==3){
			if(!isIn1&&type == 1){
				filepath = "graphics/button/close.png";
			}else if(type == 1){
				filepath = "graphics/button/close1.png";
			}
			if(!isIn2&&type == 2){
				filepath = "graphics/button/close.png";
			}else if(isIn2&&type == 2){
				filepath = "graphics/button/close1.png";
			}
			if(!isIn2&&type == 3){
				filepath = "graphics/button/close.png";
			}else if(isIn2&&type == 3){
				filepath = "graphics/button/close1.png";
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
		try {
			new MusicPlayer().play("music/effects/clicked.wav", false);
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(type == 0 || type == 1){
			Controller.exitGame();
		}else if(type == 2){
			Controller.gameframe.fightPanel.remove(ButtonGameSet.gameSetPanel);
			ButtonGameSet.isLocked = false;
			isIn1 = false;
			isIn2 = false;
			DataBase.isPause = false;
		}else if(type == 3){
			isIn1 = false;
			isIn2 = false;
			Controller.gameframe.getContentPane().setVisible(false);
			Controller.gameframe.startPanel = new PanelStart();
			Controller.gameframe.setContentPane(Controller.gameframe.startPanel);
			Controller.gameframe.repaint();
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
			isIn1 = false;
			isIn2 = false;
		this.repaint();
		
	}
}
