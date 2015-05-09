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

public class ButtonPass5 extends JLabel implements MouseListener{

	private boolean isIn=false;
	Image buttonImage;
      public ButtonPass5(){
    	
    	  buttonImage = new ImageIcon("graphics/storyteller/head.png").getImage();
   		  this.setBounds(600, 60, 130, 130);
   		
      }
      public void paintComponent(Graphics g){
    	 if(DataBase.passAlready<5)
    		 
    			 buttonImage = new ImageIcon("graphics/storyteller/head2.png").getImage();
    		
    	 else{	 
    	
    		 if(!isIn){
    			 buttonImage = new ImageIcon("graphics/storyteller/head.png").getImage();
    		 }else{
    			 buttonImage = new ImageIcon("graphics/storyteller/head1.png").getImage(); 
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
		if(DataBase.passAlready>=5){
		DataBase.pass=5;
		PanelStory.picNum=3;
		Controller.changeTo(FrameGame.STORYPANEL);
		isIn=false;
		}
	}
}
