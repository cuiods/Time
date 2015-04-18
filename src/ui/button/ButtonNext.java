package ui.button;
import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.PanelFight;
import ui.Panelstory2;
import ui.Panelstory3;
public class ButtonNext extends JLabel implements MouseListener{
     Image buttonImage;
     int flag;
     static boolean isIn = false;
     public ButtonNext(int f){
    	 buttonImage = new ImageIcon("graphics/button/next.png").getImage();
    	 this.setBounds(900, 500, 50, 50);
    	 this.flag=f;
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
		if(flag==1){
			Controller.gameframe.storyPlayer.first.setVisible(false);
			Controller.gameframe.storyPlayer.second = new Panelstory2();
			Controller.gameframe.setContentPane(Controller.gameframe.storyPlayer.second);
		}else if(flag==2){
			Controller.gameframe.storyPlayer.second.setVisible(false);
			Controller.gameframe.storyPlayer.third = new Panelstory3();
			Controller.gameframe.setContentPane(Controller.gameframe.storyPlayer.third);
		}else if(flag==3){
			Controller.gameframe.storyPlayer.third.setVisible(false);
			Controller.gameframe.fightPanel= new PanelFight();
			Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
			
			Thread fp = new Thread(Controller.gameframe.fightPanel);
			fp.start();
		}
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
