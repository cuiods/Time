package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import dataBase.DataBase;
import ui.FrameGame;
import ui.PanelStory;



public class ButtonPass2 extends JLabel implements MouseListener {
	
	static boolean isIn=false;
	Image buttonImage;
      public ButtonPass2(){
    	
    	  buttonImage = new ImageIcon("graphics/storyteller/leida.png").getImage();
   		  this.setBounds(215, 345, 120, 120);
   		
      }
      public void paintComponent(Graphics g){
    	 if(DataBase.passAlready<2)
    		 
    			 buttonImage = new ImageIcon("graphics/storyteller/leida2.png").getImage();
    		
    	 else{	 
    	
    		 if(!isIn){
    			 buttonImage = new ImageIcon("graphics/storyteller/leida.png").getImage();
    		 }else{
    			 buttonImage = new ImageIcon("graphics/storyteller/leida1.png").getImage(); 
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
		if(DataBase.passAlready>=2){
		DataBase.pass=2;
		Controller.changeTo(FrameGame.STORYPANEL);
		isIn=false;
		}
	}
}
