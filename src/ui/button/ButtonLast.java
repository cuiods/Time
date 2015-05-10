package ui.button;
import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;
import ui.FrameGame;
import ui.PanelFight;
import ui.PanelStart;
import ui.PanelStory;
import ui.PanelStory0;

public class ButtonLast extends JLabel implements MouseListener{
	 Image buttonImage;

     static boolean isIn = false;

 	 public ButtonLast(){
 		 buttonImage = new ImageIcon("graphics/button/back2.png").getImage();
 		 this.setBounds(30, 500, 80, 80);
 	
     }
 	
 	 public void paintComponent(Graphics g){
    	 if(!isIn){
    		 buttonImage = new ImageIcon("graphics/button/back2.png").getImage();
    	 }else{
    		 buttonImage = new ImageIcon("graphics/button/back3.png").getImage();
    	 }
    	 g.drawImage(buttonImage, 0,0,this.getWidth(), this.getHeight(),this);
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn = true;
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn = false;
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
			if(PanelStory.picNum>1){
				PanelStory.picNum--;
				Controller.gameframe.repaint();
			}else{
				Controller.changeTo(FrameGame.STORYZERO);
			}
		
		isIn=false;
	}

}

