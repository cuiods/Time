package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import tools.MusicThread;

import ui.FrameGame;

import dataBase.DataBase;

public class ButtonNet extends JLabel implements MouseListener,Runnable{

	Image ButtonImage = null;
	String filepath = null;
	public int x = 1000;
	public int y = 270;
	public boolean isIn = false;
	
	public ButtonNet() {
		filepath = "graphics/button/online.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(x, y, 200, 50);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(isIn){
			filepath = "graphics/button/online.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}else{
			filepath = "graphics/button/online0.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}
		g.drawImage(ButtonImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		repaint();
		new MusicThread("music/effects/moveIn.wav", false).start();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		new MusicThread("music/effects/clicked.wav", false).start();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Controller.changeTo(FrameGame.NETSETPANEL);
		isIn = false;
	}

	@Override
	public void run() {
		while(x>=700){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			x-=20;
		}
		
	}


}
