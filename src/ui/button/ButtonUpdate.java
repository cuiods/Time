package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;

public class ButtonUpdate extends JLabel implements MouseListener{

	private boolean isIn = false;
	public ButtonUpdate() {
		setBounds(50, 10, 50, 50);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/button/update.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		}else{
			g.drawImage(new ImageIcon("graphics/button/update1.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(DataBase.pass==11&&DataBase.Money>=DataBase.UPGRADE_CONDITION_LV2){
			DataBase.pass++;
			DataBase.Money-=DataBase.UPGRADE_CONDITION_LV2;
		}
		if(DataBase.pass==12&&DataBase.Money>=DataBase.UPGRADE_CONDITION_LV3){
			DataBase.pass++;
			DataBase.Money-=DataBase.UPGRADE_CONDITION_LV3;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
