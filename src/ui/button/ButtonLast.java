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
import ui.PanelStory2;
import ui.Panelstory1;
import ui.StoryPlayer;
public class ButtonLast extends JLabel implements MouseListener{
	 Image buttonImage;

     static boolean isIn = false;
 
   //picture path
     String path1,path2,path3,path4;

 	public ButtonLast(){
 		buttonImage = new ImageIcon("graphics/button/last.png").getImage();
 		this.setBounds(30, 530, 40, 40);
 	
 		 path1="graphics/storyteller/pass1/story";
    	 path2="graphics/storyteller/pass2/story";
    	 path3="graphics/storyteller/pass3/story";
    	 path4="graphics/storyteller/pass4/story";
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(DataBase.pass==1){
			if(Panelstory1.picNum>0){
				Panelstory1.picNum=0;
				StoryPlayer.first.setVisible(false);
				StoryPlayer.zero = new PanelStory0();
				Controller.gameframe.setContentPane(StoryPlayer.zero);
			}else{
				StoryPlayer.zero.setVisible(false);
				Controller.gameframe.startPanel= new PanelStart();
				Controller.gameframe.setContentPane(Controller.gameframe.startPanel);
			}

		}else if(DataBase.pass==2){
			if(Panelstory1.picNum>0){
				Panelstory1.picNum=0;
				StoryPlayer.first.setVisible(false);
				StoryPlayer.zero = new PanelStory0();
				Controller.gameframe.setContentPane(StoryPlayer.zero);
			}else if(PanelStory2.picNum>0){
				PanelStory2.picNum=0;
				Panelstory1.picNum=0;
				StoryPlayer.second.setVisible(false);
				StoryPlayer.zero = new PanelStory0();
				Controller.gameframe.setContentPane(StoryPlayer.zero);
			}else{
				StoryPlayer.zero.setVisible(false);
				Controller.gameframe.startPanel= new PanelStart();
				Controller.gameframe.setContentPane(Controller.gameframe.startPanel);
			}

        }
		isIn=false;
	}

}
