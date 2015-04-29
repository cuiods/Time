package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dataBase.DataBase;
import ui.PanelGameSet;

public class ButtonGameSet extends JPanel implements MouseListener {
	
	static PanelGameSet gameSetPanel = null;
	private boolean isIn = false;
	static boolean isLocked = false;
	public ButtonGameSet() {
		this.setBounds(920,520, 60, 70);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/info/set.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/info/set1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//show set panel
		if(!isLocked){
			gameSetPanel = new PanelGameSet();
			gameSetPanel.addMouseListener(gameSetPanel);
			Controller.gameframe.fightPanel.add(gameSetPanel);
			Controller.gameframe.fightPanel.repaint();
			isLocked = true;
			DataBase.isPause = true;
		}	
	}
}
