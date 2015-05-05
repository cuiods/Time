package ui.button;

import gamecontrol.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.PanelStory2;
import ui.PanelStory3;
import ui.StoryPlayer;
import dataBase.DataBase;

public class ButtonPass3 extends JLabel implements MouseListener {
        Image buttonImage;
        static boolean isIn = false;
        
     public ButtonPass3(){
    	 buttonImage = new ImageIcon("graphics/storyteller/satellite2.png").getImage();
  		 this.setBounds(360, 350, 90, 90);
     }
     
     public void paintComponent(Graphics g){
    	 if(DataBase.passAlready<2)
    			 buttonImage = new ImageIcon("graphics/storyteller/satellite2.png").getImage();
    		
    	
    	 else{
    		 if(!isIn){
    			 buttonImage = new ImageIcon("graphics/storyteller/satellite1.png").getImage();
    		 }else{
    			 buttonImage = new ImageIcon("graphics/storyteller/satellite3.png").getImage(); 
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
			DataBase.pass=3;
			PanelStory3.picNum=1;
			StoryPlayer.zero.setVisible(false);
			StoryPlayer.third= new PanelStory3();
			Controller.gameframe.setContentPane(StoryPlayer.third);
			isIn=false;
			}
	}
}
