package ui.button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonExit extends JLabel implements MouseListener{

	public ImageIcon ButtonImage = null;
	public String filepath = "graphics/button/exitButton.png";
	public ButtonExit(){
		ButtonImage = new ImageIcon(filepath);
		this.setIcon(ButtonImage);
		this.setBounds(660, 400, 140, 140);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
