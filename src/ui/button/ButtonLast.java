package ui.button;
import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.PanelFight;
import ui.PanelStart;
import ui.Panelstory1;
import ui.StoryPlayer;
public class ButtonLast extends JLabel implements MouseListener{
	 Image buttonImage;
     int flag;
     static boolean isIn = false;
     //ͼƬ�л�����
     static private int chanNum=0;
   //picture path
     String path;

 	public ButtonLast(int f){
 		buttonImage = new ImageIcon("graphics/button/last.png").getImage();
 		this.setBounds(100, 500, 50, 50);
 		this.flag=f;
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
		if(flag==1){
			if(Panelstory1.picNum>1){
				Panelstory1.picNum-=1;
				StoryPlayer.first.story=new ImageIcon(path+Panelstory1.picNum+".png").getImage();
				StoryPlayer.first.repaint();
			}else {
				Panelstory1.picNum=1;
				StoryPlayer.first.setVisible(false);
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
