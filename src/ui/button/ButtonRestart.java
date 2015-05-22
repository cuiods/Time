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

public class ButtonRestart extends JLabel implements MouseListener {
    private Image out,in ;
    private boolean isIn=false;
    private int type;
    public ButtonRestart(int type){
    	this.type=type;
    	if(type==0){
    		out = new ImageIcon("graphics/button/next.png").getImage();
    		in  = new ImageIcon("graphics/button/next1.png").getImage();
    	}else if(type==1){
    		out = new ImageIcon("graphics/button/again.png").getImage();
    		in = new ImageIcon("graphics/button/again1.png").getImage();
    	}
    }
    public void paintComponent(Graphics g){
		if(!isIn){
			g.drawImage(out, 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(in, 0, 0, this.getWidth(),this.getHeight(),this);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn=true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn=false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(type==0){
			if(DataBase.pass==DataBase.passAlready){
				DataBase.passAlready++;
			}
			Controller.changeTo(FrameGame.STORYZERO);
		}else if(type==1){
			DataBase.recover();
			Controller.changeTo(FrameGame.LOADING);
		}
	}

}
