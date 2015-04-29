package ui.button;

import gamecontrol.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ui.*;


public class ButtonPass1 extends JLabel implements MouseListener{
	 Image buttonImage;
    
     static boolean isIn = false;
     public static boolean isClick=false;
   

 	public ButtonPass1(){
 		buttonImage = new ImageIcon("graphics/storyteller/sword.png").getImage();
 		this.setBounds(85, 450, 70, 70);
 	}
 	  

 	
 	 public void paintComponent(Graphics g){
    	 if(!isIn){
    		 buttonImage = new ImageIcon("graphics/storyteller/sword.png").getImage();
    	 }else{
    		 buttonImage = new ImageIcon("graphics/storyteller/sword2.png").getImage();
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
		
		Panelstory1.picNum=1;
		StoryPlayer.zero.setVisible(false);
		StoryPlayer.first= new Panelstory1();
		Controller.gameframe.setContentPane(StoryPlayer.first);
		isIn=false;
		isClick=true;
	}

}
