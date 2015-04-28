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
import ui.Panelstory1;
import ui.StoryPlayer;

public class ButtonNext extends JLabel implements MouseListener{
     Image buttonImage;

     static boolean isIn = false;
     //picture path
     String path;
   
     

	public ButtonNext(){
    	 buttonImage = new ImageIcon("graphics/button/next.png").getImage();
    	 this.setBounds(900, 530, 40, 40);
    
    	 path="graphics/storyteller/story";
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
			int chanNum=StoryPlayer.picNum+=1;
			if(chanNum==2){
				StoryPlayer.first.story=new ImageIcon(path+StoryPlayer.picNum+".png").getImage();
				StoryPlayer.first.repaint();
			}
		
			if(chanNum==3){
				
				StoryPlayer.first.setVisible(false);
//				Controller.gameframe.fightPanel= new PanelFight();
//				Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
//				Thread fp = new Thread(Controller.gameframe.fightPanel);
//				fp.start();
				
				Controller.gameframe.loadingPanel = new PanelLoading();
				Controller.gameframe.setContentPane(Controller.gameframe.loadingPanel);
				isIn = false;

			}
		}else if(DataBase.pass==2){
			StoryPlayer.picNum+=1;
			if(StoryPlayer.picNum<=5){
				StoryPlayer.second.story=new ImageIcon(path+StoryPlayer.picNum+".png").getImage();
				StoryPlayer.second.repaint();
			}else{
				Controller.gameframe.loadingPanel = new PanelLoading();
				Controller.gameframe.setContentPane(Controller.gameframe.loadingPanel);
				isIn = false;
			}
		
			
		}else if(DataBase.pass==3){
			
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

}
