package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;
import ui.FrameGame;
import ui.PanelStart;

public class ButtonReturn extends JLabel implements MouseListener{
	private boolean isIn = false;
	private int type = 0;
	public ButtonReturn() {
		this.setBounds(30, 150, 180, 50);
	}
	public void paintComponent(Graphics g) {
		switch(type){
		case 0:
			if(!isIn){
				g.drawImage(new ImageIcon("graphics/button/returntostart.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/button/returntostart1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}
			break;
		case 1:
			if(!isIn){
				g.drawImage(new ImageIcon("graphics/button/back.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/button/back1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isIn = true;
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isIn = false;
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Controller.changeTo(FrameGame.STARTPANEL);
		DataBase.isPause = false;
		ButtonGameSet.isLocked = false;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
