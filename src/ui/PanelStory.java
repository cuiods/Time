package ui;

import gamecontrol.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import dataBase.DataBase;
import ui.button.*;

public class PanelStory extends JPanel implements MouseListener {
      public static int picNum=0;
      String path="graphics/storyteller/story";
      Image story=null;
      ButtonLast last;
      
      public PanelStory(){
    	
    	  last = new ButtonLast();
   
    	  this.setLayout(null);
  		
  		  this.add(last);
  		  last.addMouseListener(last);
  		  this.addMouseListener(this);
  		  switch (DataBase.pass){
  			  case 1:  story=new ImageIcon("graphics/storyteller/story1.png").getImage();
  			  break;
  			  case 2:  story=new ImageIcon("graphics/storyteller/story3.png").getImage();
  			  break;
  			  case 3:  story=new ImageIcon("graphics/storyteller/story6.png").getImage();
  			  break;
  			  case 4:  story=new ImageIcon("graphics/storyteller/story11.png").getImage();
  			  break;
  		  }
      }
      public void paintComponent(Graphics g){
    		
    		g.drawImage(story, 0, 0, this.getWidth(),this.getHeight(),this);
    	  
    	 }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(DataBase.pass==1){
			
			if(picNum<2){
				picNum+=1;
				story=new ImageIcon(path+picNum+".png").getImage();
				this.repaint();
			}else{
				Controller.gameframe.loadingPanel = new PanelLoading();
				Controller.gameframe.setContentPane(Controller.gameframe.loadingPanel);
				picNum=0;
			}
		}else if(DataBase.pass==2){
			if(picNum<5){
				picNum+=1;
				story=new ImageIcon(path+picNum+".png").getImage();
				this.repaint();
			}else{
				Controller.gameframe.loadingPanel = new PanelLoading();
				Controller.gameframe.setContentPane(Controller.gameframe.loadingPanel);
				picNum=0;
			}
		}else if(DataBase.pass==3){
			if(picNum<10){
				picNum+=1;
				story=new ImageIcon(path+picNum+".png").getImage();
				this.repaint();
			}else{
				Controller.gameframe.loadingPanel = new PanelLoading();
				Controller.gameframe.setContentPane(Controller.gameframe.loadingPanel);
				picNum=0;
			}
		}
		
	}
     
}
