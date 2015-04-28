package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonExit;

public class PanelGameSet extends JPanel implements MouseListener{

	private ButtonExit butExit = null;
	public PanelGameSet() {
		butExit = new ButtonExit();
		butExit.type = 2;
		butExit.setBounds(280, 20, 30, 30);
		butExit.addMouseListener(butExit);
		this.setBounds(320, 130, 320, 380);
		this.add(butExit);
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon("graphics/info/gameSetPanel.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
