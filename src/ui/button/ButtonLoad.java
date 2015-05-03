package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.MusicPlayer;
import tools.Save;
import ui.PanelFight;
import ui.PanelLoad;
import ui.Panelstory1;
import ui.StoryPlayer;

public class ButtonLoad extends JLabel implements MouseListener{
	Image load=null;
	Image ButtonImage = null;
	String filepath = null;
	static boolean isIn = false;
	
	public ButtonLoad(){
		filepath = "graphics/button/loadbutton1.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(180, 400, 140, 140);
	}
	
	public void paintComponent(Graphics g){
		if(!isIn){
			filepath = "graphics/button/loadgame1.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}else{
			filepath = "graphics/button/loadButtonMoveIn.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}
		g.drawImage(ButtonImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		try {
			new MusicPlayer().play("music/effects/clicked.wav", false);
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Controller.gameframe.getContentPane().setVisible(false);
		Controller.gameframe.loadPanel = new PanelLoad();
		Controller.gameframe.setContentPane(Controller.gameframe.loadPanel);
		Controller.gameframe.repaint();
		isIn = false;
//		Save sv = new Save();
//		try {
//			sv.Recover();
//		} catch (ClassNotFoundException | IOException e1) {
//			e1.printStackTrace();
//		}
//		Controller.gameframe.getContentPane().setVisible(false);
//		Controller.gameframe.fightPanel = new PanelFight();
//		Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
//		Thread fp = new Thread(Controller.gameframe.fightPanel);
//		fp.start();
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		this.repaint();
		
		try {
			new MusicPlayer().play("music/effects/moveIn.wav", false);
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		this.repaint();
		
	}

}
