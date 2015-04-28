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
import ui.PanelStart;
import ui.PanelStory0;
import ui.Panelstory1;
import ui.StoryPlayer;
public class ButtonLast extends JLabel implements MouseListener{
	 Image buttonImage;

     static boolean isIn = false;
 
   //picture path
     String path;

 	public ButtonLast(){
 		buttonImage = new ImageIcon("graphics/button/last.png").getImage();
 		this.setBounds(30, 530, 40, 40);
 	
 		path="graphics/storyteller/story";
    }
 	
 	 public void paintComponent(Graphics g){
    	 if(!isIn){
    		 buttonImage = new ImageIcon("graphics/button/last.png").getImage();
    	 }else{
    		 buttonImage = new ImageIcon("graphics/button/last1.png").getImage();
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
		isIn = true;
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn = false;
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
			
		
		if(DataBase.pass==1){
			StoryPlayer.picNum-=1;
			if(StoryPlayer.picNum>=1){
				
				StoryPlayer.first.story=new ImageIcon(path+StoryPlayer.picNum+".png").getImage();
				StoryPlayer.first.repaint();
			}else if(StoryPlayer.picNum==0){
			
				StoryPlayer.first.setVisible(false);
				StoryPlayer.zero = new PanelStory0();
				Controller.gameframe.setContentPane(StoryPlayer.zero);
			}else{
				StoryPlayer.picNum=0;
				StoryPlayer.zero.setVisible(false);
				Controller.gameframe.startPanel= new PanelStart();
				Controller.gameframe.setContentPane(Controller.gameframe.startPanel);
			}
		}else if(DataBase.pass==2){
			StoryPlayer.picNum-=1;
			if(StoryPlayer.picNum>=3){
				
				StoryPlayer.second.story=new ImageIcon(path+StoryPlayer.picNum+".png").getImage();
				StoryPlayer.second.repaint();
			}else if(StoryPlayer.picNum==2){
				
				StoryPlayer.second.setVisible(false);
				StoryPlayer.zero=new PanelStory0();
				Controller.gameframe.setContentPane(StoryPlayer.zero);
			}else{
				StoryPlayer.picNum=0;
				StoryPlayer.zero.setVisible(false);
				Controller.gameframe.startPanel= new PanelStart();
				Controller.gameframe.setContentPane(Controller.gameframe.startPanel);
			}
		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
