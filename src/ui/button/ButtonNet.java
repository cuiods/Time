package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.FrameGame;
import dataBase.DataBase;

public class ButtonNet extends JPanel implements MouseListener,Runnable{

	public int x = 1000;
	public int y = 270;
	private boolean isIn = false;
	
	public ButtonNet() {
		setBounds(x, y, 200, 50);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/button/online.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/button/online.gif").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Controller.changeTo(FrameGame.NETSETPANEL);
		isIn = false;
	}

	@Override
	public void run() {
		while(!DataBase.threadContinue){
			if(x>=700){
				x-=20;
			}
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			repaint();
		}

		
	}

}
