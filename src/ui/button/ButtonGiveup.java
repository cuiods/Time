package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.FrameGame;
import dataBase.DataBase;

public class ButtonGiveup extends JLabel implements MouseListener{
	Image ButtonImage = null;
	private boolean isIn = false;
    public ButtonGiveup(){
    }
    public void paintComponent(Graphics g){
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/button/give.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/button/give1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		isIn=true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		isIn=false;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		DataBase.recover();
		Controller.changeTo(FrameGame.STARTPANEL);
	}

}
