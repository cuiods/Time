package ui.button;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ui.PanelFight;

public class ButtonUnit extends JLabel implements MouseListener{

	public Image image = null;
	public String filepath = "graphics/button/unitButton.png";
	public static boolean canRemove = true;
	public static int pressTime = 0;
	
	public ButtonUnit(){
		image = new ImageIcon(filepath).getImage();
		this.setBounds(10, 100, 60, 60);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(), this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(pressTime == 0){
			PanelFight.addUnitPanel();
			pressTime = 1;
			canRemove = false;
		}else{
			pressTime = 0;
			canRemove = true;
			PanelFight.removeUnitPanel();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			PanelFight.addUnitPanel();					
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(canRemove){
			PanelFight.removeUnitPanel();	
		}
	}	
}
