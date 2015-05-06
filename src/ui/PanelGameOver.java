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
		this.setBounds(320, 140, 400, 300);
		Controller.gameframe.remove(Controller.gameframe.fightPanel);
		gameover = new ImageIcon("graphics/info/gameover.png").getImage();
		if(iswin){
			//System.out.println("yes");
			win = new ImageIcon("graphics/info/win.png").getImage();
			exit = new ImageIcon("graphics/button/exit2.png").getImage();
			next = new ImageIcon("graphics/button/nextGame.png").getImage();
			exit1 = new ImageIcon("graphics/button/exitgame1.png").getImage();
			next1 = new ImageIcon("graphics/button/again1.png").getImage();
		}else{
			win = new ImageIcon("graphics/info/lose.png").getImage();
			exit = new ImageIcon("graphics/button/exitgame.png").getImage();
			next = new ImageIcon("graphics/button/again.png").getImage();
			exit1 = new ImageIcon("graphics/button/exitgame1.png").getImage();
			next1 = new ImageIcon("graphics/button/again1.png").getImage();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(gameover, 0, 0, this.getWidth(),this.getHeight(),this);
		g.drawImage(win, 80, 80, 240,100,this);
		if(!isIn1){
			g.drawImage(exit, 220, 200, 120, 50, this);
		}else{
			g.drawImage(exit1, 220, 200, 120, 50, this);
		}
		if(!isIn2){
			g.drawImage(next, 50, 200, 120, 50, this);
		}else{
			g.drawImage(next1, 50, 200, 120, 50, this);
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
		if(e.getX()>=220&&e.getX()<=340&&e.getY()>=200&&e.getY()<=250){
			//return to start panel("exit")
			DataBase.recover();
			
			//restart
			Controller.changeTo(FrameGame.STARTPANEL);
			ButtonGameSet.isLocked = false;
						
		}else if(e.getX()>=50&&e.getX()<=170&&e.getY()>=200&&e.getY()<=250){
			
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
		while(true){
			Point point = MouseInfo.getPointerInfo().getLocation();
			if(point.getX()>=220&&point.getX()<=340&&point.getY()>=200&&point.getY()<=250){
				isIn1 = true;
			}else{
				isIn1 = false;
			}
			if(point.getX()>=50&&point.getX()<=170&&point.getY()>=200&&point.getY()<=250){
				isIn2 = true;
			}else{
				isIn2 = false;
			}
			this.repaint();
			
			try {
				Thread.sleep(100); 
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
		
	}
}
