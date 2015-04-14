package ui.button;

import gameControl.Controller;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.PanelFight;

public class ButtonStart extends JLabel implements MouseListener{

	ImageIcon ButtonImage = null;
	String filepath = "graphics/button/startButton.png";
	public ButtonStart(){
		ButtonImage = new ImageIcon(filepath);
		this.setIcon(ButtonImage);
		this.setBounds(400,400,170,170);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		Controller.gameframe.startPanel.setVisible(false);
		Controller.gameframe.fightPanel = new PanelFight();
		Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
		
		//full screen (if needed)
//		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
//		gd.setFullScreenWindow(Controller.gameframe);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
}
