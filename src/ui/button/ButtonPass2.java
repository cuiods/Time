package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import dataBase.DataBase;
import ui.PanelStory2;
import ui.Panelstory1;
import ui.StoryPlayer;

public class ButtonPass2 extends JLabel implements MouseListener {
	
	static boolean isIn=false;
	Image buttonImage;
      public ButtonPass2(){
    	
    	  buttonImage = new ImageIcon("graphics/storyteller/telescope.png").getImage();
   		  this.setBounds(245, 410, 70, 70);
   		
      }
      public void paintComponent(Graphics g){
    	 switch(DataBase.passAlready){
    	 case 1:
    		 
    			 buttonImage = new ImageIcon("graphics/storyteller/teles1.png").getImage();
    		
    		 break;
    	 case 2:
    		 if(!isIn){
    			 buttonImage = new ImageIcon("graphics/storyteller/telescope.png").getImage();
    		 }else{
    			 buttonImage = new ImageIcon("graphics/storyteller/telescope1.png").getImage(); 
    	     }
    		 break;
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
		if(DataBase.passAlready>1){
		DataBase.pass=2;
		StoryPlayer.picNum=3;
		StoryPlayer.zero.setVisible(false);
		StoryPlayer.second= new PanelStory2();
		Controller.gameframe.setContentPane(StoryPlayer.second);
		}
	}
}