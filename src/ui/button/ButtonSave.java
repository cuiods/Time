package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.Save;

public class ButtonSave extends JLabel implements MouseListener{

	private boolean isIn = false;
	private int type = 1;
	public ButtonSave(int i) {
		this.setBounds(310, 80+100*i, 500, 80);
		this.type = i;
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/button/save"+type+".png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/button/save"+type+"m.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isIn = true;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isIn = false;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Save sv = new Save(type);
		try {
			sv.Save();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Controller.gameframe.setPanel.repaint();
	}

}
