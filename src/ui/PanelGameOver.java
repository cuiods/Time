package ui;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonGameSet;
import dataBase.DataBase;

public class PanelGameOver extends JPanel implements MouseListener, Runnable{

	Image gameover = null;
	Image win = null;
	Image exit = null;
	Image next = null;
	Image exit1 = null;
	Image next1 = null;
	boolean isWin = false;
	boolean isIn1 = false;
	boolean isIn2 = false;
	/**
	 * if win, the param is true,otherwise, false
	 * @param iswin
	 */
	public PanelGameOver(boolean iswin){
		this.isWin = iswin;
		this.setBounds(320, 180, 375, 204);
		Controller.gameframe.remove(Controller.gameframe.classicPanel);
		if(iswin){
			//System.out.println("yes");
			win = new ImageIcon("graphics/info/youwin.png").getImage();
			exit = new ImageIcon("graphics/button/give.png").getImage();
			next = new ImageIcon("graphics/button/next.png").getImage();
			exit1 = new ImageIcon("graphics/button/give1.png").getImage();
			next1 = new ImageIcon("graphics/button/next1.png").getImage();
		}else{
			win = new ImageIcon("graphics/info/gameover.png").getImage();
			exit = new ImageIcon("graphics/button/give.png").getImage();
			next = new ImageIcon("graphics/button/next.png").getImage();
			exit1 = new ImageIcon("graphics/button/give1.png").getImage();
			next1 = new ImageIcon("graphics/button/next1.png").getImage();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(win, 0, 0, 375,204,this);
		if(!isIn1){
			g.drawImage(exit, 30, 130, 152, 34, this);
		}else{
			g.drawImage(exit1, 30, 130, 152, 34, this);
		}
		if(!isIn2){
			g.drawImage(next, 200, 130, 152, 34, this);
		}else{
			g.drawImage(next1, 200, 130, 152, 34, this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getX()>=30&&e.getX()<=182&&e.getY()>=130&&e.getY()<=164){
			//return to start panel("exit")
			DataBase.recover();
			
			//restart
			Controller.changeTo(FrameGame.STARTPANEL);
						
		}else if(e.getX()>=200&&e.getX()<=330&&e.getY()>=130&&e.getY()<=164){
			
			//restart the game
			if(!isWin){
				DataBase.recover();
				Controller.changeTo(FrameGame.LOADING);
			}else{
				if(DataBase.pass==DataBase.passAlready){
					DataBase.passAlready++;
				}
			Controller.changeTo(FrameGame.STORYZERO);
			}		
		}
		DataBase.isPause = false;
		
	}

	@Override
	public void run() {
		while(true&&DataBase.threadContinue){
			Point point = MouseInfo.getPointerInfo().getLocation();
			if(point.getX()>=348&&point.getX()<=503&&point.getY()>=312&&point.getY()<=345){
				isIn1 = true;
			}else{
				isIn1 = false;
			}
			if(point.getX()>=521&&point.getX()<=673&&point.getY()>=312&&point.getY()<=345){
				isIn2 = true;
			}else{
				isIn2 = false;
			}
			this.repaint();
			
			try {
				Thread.sleep(50); 
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
		
	}
}
