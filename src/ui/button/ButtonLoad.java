package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.PanelLoad;

public class ButtonLoad extends JLabel implements MouseListener{
	Image load=null;
	Image ButtonImage = null;
	String filepath = null;
	static boolean isIn = false;
	static boolean isLocked=false;
	static PanelLoad loadPanel=null;
	
	public ButtonLoad(){
		filepath = "graphics/button/loadbutton1.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(180, 400, 140, 140);
	}
	
	public void paintComponent(Graphics g){
		if(!isIn){
			filepath = "graphics/button/loadgame1.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}else{
			filepath = "graphics/button/loadButtonMoveIn.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}
		g.drawImage(ButtonImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!isLocked){
			loadPanel = new PanelLoad();
			loadPanel.addMouseListener(loadPanel);
			Controller.gameframe.startPanel.removeAll();
			Controller.gameframe.startPanel.add(loadPanel);
			loadPanel.repaint();
			Controller.gameframe.repaint();
		}	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		this.repaint();
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		this.repaint();
		
	}

}
