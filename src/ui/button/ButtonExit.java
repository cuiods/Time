package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonExit extends JLabel implements MouseListener{

	Image ButtonImage = null;
	String filepath = null;
	static boolean isIn = false;
	public int type = 0;
	public ButtonExit(){
		filepath = "graphics/button/exitbutton1.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(660, 400, 140, 140);
	}
	
	public void paintComponent(Graphics g){
		if(type == 0){
			if(!isIn){
				filepath = "graphics/button/exitbutton1.png";
				ButtonImage = new ImageIcon(filepath).getImage();
			}else{
				filepath = "graphics/button/exitButtonMoveIn.png";
				ButtonImage = new ImageIcon(filepath).getImage();
			}
		}else if(type == 1){
			if(!isIn){
				filepath = "graphics/button/close.png";
			}else{
				filepath = "graphics/button/close1.png";
			}
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
		Controller.exitGame();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
