package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;

public class ButtonNetChoose extends JLabel implements MouseListener{

	public int type = 0;
	public ButtonNetChoose(int type) {
		this.type = type;
		setBounds(420,140+type*60,300,50+5*type);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		switch(type){
		case 0:
			if(DataBase.isServer){
				g.drawImage(new ImageIcon("graphics/net/create.png").getImage(), 0,0,this.getWidth(),this.getHeight(), this);
			}else{
				g.drawImage(new ImageIcon("graphics/net/create1.png").getImage(), 0,0,this.getWidth(),this.getHeight(), this);
			}
			break;
		case 1:
			if(!DataBase.isServer){
				g.drawImage(new ImageIcon("graphics/net/join.png").getImage(), 0,0,this.getWidth(),this.getHeight(), this);
			}else{
				g.drawImage(new ImageIcon("graphics/net/join1.png").getImage(), 0,0,this.getWidth(),this.getHeight(), this);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(type == 0){
			DataBase.isServer = true;
			Controller.gameframe.netSetPanel.repaint();
		}else{
			DataBase.isServer = false;
			Controller.gameframe.netSetPanel.repaint();
		}
	}

}
