package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.FrameGame;
import ui.PanelStory;
import dataBase.DataBase;

public class ButtonPass6 extends JLabel implements MouseListener{

	private boolean isIn=false;
	Image buttonImage;
      public ButtonPass6(){
    	
    	  buttonImage = new ImageIcon("graphics/storyteller/fist.png").getImage();
   		  this.setBounds(870, 220, 80, 120);
   		
      }
      public void paintComponent(Graphics g){
    	 if(DataBase.passAlready<6)
    		 
    			 buttonImage = new ImageIcon("graphics/storyteller/fist2.png").getImage();
    		
    	 else{	 
    	
    		 if(!isIn){
    			 buttonImage = new ImageIcon("graphics/storyteller/fist.png").getImage();
    		 }else{
    			 buttonImage = new ImageIcon("graphics/storyteller/fist1.png").getImage(); 
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
		if(DataBase.passAlready>=6){
		DataBase.pass=6;
		PanelStory.picNum=3;
		Controller.changeTo(FrameGame.STORYPANEL);
		isIn=false;
		}
	}
}
