package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
			}else if(type == 2){
				filepath = "graphics/button/close1.png";
			}
			if(!isIn2&&type == 3){
				filepath = "graphics/button/close.png";
			}else if(type == 3){
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
		if(type == 0 || type == 1){
			Controller.exitGame();
		}else if(type == 2){
			Controller.gameframe.fightPanel.remove(ButtonGameSet.gameSetPanel);
			ButtonGameSet.isLocked = false;
			isIn2 = false;
			DataBase.isPause = false;
		}else if(type == 3){
			Controller.gameframe.startPanel.remove(ButtonLoad.loadPanel);
			isIn2 = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(type == 1||type == 0){
			isIn1 = true;
		}else{
			isIn2 = true;
		}
		this.repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(type == 1||type == 0){
			isIn1 = false;
		}else{
			isIn2 = false;
		}
		this.repaint();
		
	}
}
