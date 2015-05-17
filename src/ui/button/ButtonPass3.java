package ui.button;

import gamecontrol.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.FrameGame;
import ui.PanelStory;


import dataBase.DataBase;

public class ButtonPass3 extends JLabel implements MouseListener {
        Image buttonImage;
        static boolean isIn = false;
        
     public ButtonPass3(){
    	 buttonImage = new ImageIcon("graphics/storyteller/satellite.png").getImage();
  		 this.setBounds(480, 430, 125, 125);
     }
     
     public void paintComponent(Graphics g){
    	 if(DataBase.passAlready<3)
    			 buttonImage = new ImageIcon("graphics/storyteller/satellite2.png").getImage();
    		
    	
    	 else{
    		 if(!isIn){
    			 buttonImage = new ImageIcon("graphics/storyteller/satellite.png").getImage();
    		 }else{
    			 buttonImage = new ImageIcon("graphics/storyteller/satellite1.png").getImage(); 
    	     }
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
		isIn=true;
		this.repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn=false;
		this.repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(DataBase.passAlready>=3){
			DataBase.pass=3;
			Controller.changeTo(FrameGame.STORYPANEL);
			isIn=false;
			DataBase.Tech_Harper_TIME=0;
			}
	}
}
