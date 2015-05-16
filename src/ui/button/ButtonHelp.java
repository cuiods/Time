package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.PanelHelp;

public class ButtonHelp extends JLabel implements MouseListener{
	private int type = 0;
	private boolean isIn = false;
	public ButtonHelp(int type) {
		this.type = type;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Image image = null;
		switch(type){
		case 0:
			if(!isIn&&PanelHelp.picNum>=3){
				image = new ImageIcon("graphics/help/basic.png").getImage();
			}else{
				image = new ImageIcon("graphics/help/basicIn.png").getImage();
			}
			break;
		case 1:
			if(!isIn&&PanelHelp.picNum!=3){
				image = new ImageIcon("graphics/help/science.png").getImage();
			}else{
				image = new ImageIcon("graphics/help/scienceIn.png").getImage();
			}
			break;
		case 2:
			if(!isIn&&PanelHelp.picNum!=4){
				image = new ImageIcon("graphics/help/unit.png").getImage();
			}else{
				image = new ImageIcon("graphics/help/unitIn.png").getImage();
			}
			break;
		case 3:
			if(!isIn){
				image = new ImageIcon("graphics/help/up.png").getImage();
			}else{
				image = new ImageIcon("graphics/help/upIn.png").getImage();
			}
			break;
		case 4:
			if(!isIn){
				image = new ImageIcon("graphics/help/down.png").getImage();
			}else{
				image = new ImageIcon("graphics/help/downIn.png").getImage();
			}
			break;
		}
		g.drawImage(image, 0,0,this.getWidth(),this.getHeight(), this);
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
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(type){
		case 0:
			PanelHelp.picNum = 1;
			break;
		case 1:
		case 2:
			PanelHelp.picNum = type+2;
			break;
		case 3:
			if(PanelHelp.picNum>=2){
				PanelHelp.picNum--;
			}
			break;
		case 4:
			if(PanelHelp.picNum<=3){
				PanelHelp.picNum++;
			}
			break;
		}
		Controller.gameframe.helpPanel.repaint();
	}

}
