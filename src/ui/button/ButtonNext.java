package ui.button;
import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;
import ui.PanelFight;
import ui.PanelLoading;
import ui.PanelStory2;
import ui.Panelstory1;
import ui.StoryPlayer;

public class ButtonNext extends JLabel implements MouseListener{
     Image buttonImage;

     static boolean isIn = false;
     //picture path
     String path1,path2,path3,path4;
   
     

	public ButtonNext(){
    	 buttonImage = new ImageIcon("graphics/button/next.png").getImage();
    	 this.setBounds(900, 530, 40, 40);
    
    	 path1="graphics/storyteller/pass1/story";
    	 path2="graphics/storyteller/pass2/story";
    	 path3="graphics/storyteller/pass3/story";
    	 path4="graphics/storyteller/pass4/story";
     }
     
     public void paintComponent(Graphics g){
    	 if(!isIn){
    		 buttonImage = new ImageIcon("graphics/button/next.png").getImage();
    	 }else{
    		 buttonImage = new ImageIcon("graphics/button/next1.png").getImage();
    	 }
    	 g.drawImage(buttonImage, 0,0,this.getWidth(), this.getHeight(),this);
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isIn = true;
		this.repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isIn = false;
		this.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(DataBase.pass==1){
			Panelstory1.picNum+=1;
			if(Panelstory1.picNum==2){
				StoryPlayer.first.story=new ImageIcon(path1+Panelstory1.picNum+".png").getImage();
				StoryPlayer.first.repaint();
			}
		
			if(Panelstory1.picNum==3){
				
				StoryPlayer.first.setVisible(false);

				
				Controller.gameframe.loadingPanel = new PanelLoading();
				Controller.gameframe.setContentPane(Controller.gameframe.loadingPanel);
				isIn = false;
               Panelstory1.picNum=0;
			}
		}else if(DataBase.pass==2){
			
			if(PanelStory2.picNum==0){
				    if(Panelstory1.picNum==2){
				    	Controller.gameframe.getContentPane().setVisible(false);
				    	Controller.gameframe.loadingPanel = new PanelLoading();
				    	Controller.gameframe.setContentPane(Controller.gameframe.loadingPanel);
				    }else{
				    Panelstory1.picNum+=1;
					StoryPlayer.first.story=new ImageIcon(path1+Panelstory1.picNum+".png").getImage();
					StoryPlayer.first.repaint();
				    }
			
			}else{
				PanelStory2.picNum+=1;
				if(PanelStory2.picNum<=3){
					StoryPlayer.second.story=new ImageIcon(path2+PanelStory2.picNum+".png").getImage();
					StoryPlayer.second.repaint();
				}else{
					Controller.gameframe.loadingPanel = new PanelLoading();
					Controller.gameframe.setContentPane(Controller.gameframe.loadingPanel);
					isIn = false;
					PanelStory2.picNum=0;
				}
			}
		
			
		}else if(DataBase.pass==3){
			
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

}
