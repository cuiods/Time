package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;

public class ButtonPause extends JLabel implements MouseListener{

	private boolean isIn1 = false;
	private boolean isIn2 = false;
	public ButtonPause() {
		this.setBounds(880, 20, 30, 30);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(!DataBase.isPause){
			if(!isIn1){
				g.drawImage(new ImageIcon("graphics/button/pause.png").getImage(), 0, 0,this.getWidth(), this.getHeight(),this);
			}else if(isIn1){
				g.drawImage(new ImageIcon("graphics/button/pause1.png").getImage(), 0, 0,this.getWidth(), this.getHeight(),this);
			}
		}else{
			if(!isIn2){
				g.drawImage(new ImageIcon("graphics/button/continue.png").getImage(), 0, 0,this.getWidth(), this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/button/continue1.png").getImage(), 0, 0,this.getWidth(), this.getHeight(),this);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(!DataBase.isPause){
			isIn1 = true;
		}else{
			isIn2 = true;
		}
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isIn2 = false;
		isIn1 = false;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(!DataBase.isPause){
			DataBase.isPause = true;
		}else{
			DataBase.isPause = false;
		}
		this.repaint();
	}

}
