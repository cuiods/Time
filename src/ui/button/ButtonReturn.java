package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;
import ui.PanelStart;

public class ButtonReturn extends JLabel implements MouseListener{
	private boolean isIn = false;
	public ButtonReturn() {
		this.setBounds(30, 150, 180, 50);
	}
	public void paintComponent(Graphics g) {
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/button/returntostart.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/button/returntostart1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
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
		Controller.gameframe.getContentPane().setVisible(false);
		Controller.gameframe.startPanel = new PanelStart();
		Controller.gameframe.setContentPane(Controller.gameframe.startPanel);
		DataBase.isPause = false;
		ButtonGameSet.isLocked = false;
		Controller.gameframe.repaint();
		
	}

}
