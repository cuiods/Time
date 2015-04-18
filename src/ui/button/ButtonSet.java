package ui.button;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonSet extends JLabel implements MouseListener{
	Image ButtonImage = null;
	String filepath = null;
	static boolean isIn = false;
	public ButtonSet(){
		filepath = "graphics/button/setButton.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(300, 250, 140, 140);
	}
	
	public void paintComponent(Graphics g){
		if(!isIn){
			filepath = "graphics/button/setbutton1.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}else{
			filepath = "graphics/button/setButtonMoveIn.png";
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
