package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.Save;

public class ButtonSave extends JLabel implements MouseListener{

	private boolean isIn = false;
	public ButtonSave() {
		this.setBounds(60, 140, 250, 75);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/button/savegame.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/button/savegame1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isIn = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isIn = false;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Save sv = new Save();
		try {
			sv.Save();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
