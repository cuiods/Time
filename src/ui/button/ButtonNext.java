package ui.button;
import gamecontrol.Controller;

import javax.swing.*;

import ui.*;

import java.awt.*;
import java.awt.event.*;
public class ButtonNext extends JLabel implements MouseListener{
     Image buttonImage;
     int flag;
     public ButtonNext(int f){
    	 buttonImage = new ImageIcon("graphics/button/nextButton.png").getImage();
    	 this.setBounds(900, 500, 50, 50);
    	 this.flag=f;
     }
     
     public void paintComponent(Graphics g){
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
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
