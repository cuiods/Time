package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.PanelStory3;
import ui.PanelStory4;
import ui.StoryPlayer;
import dataBase.DataBase;

public class ButtonPass4 extends JLabel implements MouseListener{
	 Image buttonImage;
     static boolean isIn = false;
     
      public ButtonPass4(){
    	  buttonImage = new ImageIcon("graphics/storyteller/satellite2.png").getImage();
   		  this.setBounds(452, 295, 200, 70);
      }
      public void paintComponent(Graphics g){
     	   if(DataBase.passAlready<3)
     			 buttonImage = new ImageIcon("graphics/storyteller/ship2.png").getImage();
     		
     		
     	   else{
     		 if(!isIn){
     			 buttonImage = new ImageIcon("graphics/storyteller/ship1.png").getImage();
     		 }else{
     			 buttonImage = new ImageIcon("graphics/storyteller/ship3.png").getImage(); 
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
		if(DataBase.passAlready>3){
			DataBase.pass=4;
			PanelStory4.picNum=1;
			StoryPlayer.zero.setVisible(false);
			StoryPlayer.four= new PanelStory4();
			Controller.gameframe.setContentPane(StoryPlayer.four);
			isIn=false;
			}
	}
}
