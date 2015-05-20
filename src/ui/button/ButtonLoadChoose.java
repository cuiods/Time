package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;
import tools.Save;
import ui.FrameGame;
import ui.PanelFight;
import ui.PanelLoad;

public class ButtonLoadChoose extends JLabel implements MouseListener{

	private int kind;
	Image image = null;
	Image imagem = null;
	private boolean isIn = false;
	public ButtonLoadChoose(int kind) {
		this.kind = kind;
		this.setBounds(210, 60+kind*120, 700, 100);
		image = new ImageIcon("graphics/info/save/save"+kind+".png").getImage();
		imagem = new ImageIcon("graphics/info/save/save"+kind+"m.png").getImage();
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(!isIn){
			g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isIn = true;
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isIn = false;
		this.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		DataBase.pass = 1;
		Save sv = new Save(kind);
		try {
			sv.Recover();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		switch(kind){
		case 0:
			if(!PanelLoad.time0.equals("�մ浵")){
				Controller.changeTo(FrameGame.LOADING);
			}break;
		case 1:
			if(!PanelLoad.time1.equals("�մ浵")){
				Controller.changeTo(FrameGame.LOADING);
			}break;
		case 2:
			if(!PanelLoad.time2.equals("�մ浵")){
				Controller.changeTo(FrameGame.LOADING);
			}break;
		case 3:
			if(!PanelLoad.time3.equals("�մ浵")){
				Controller.changeTo(FrameGame.LOADING);
			}break;
		
		}
	}

}
