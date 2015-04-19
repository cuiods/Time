package ui;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelLoading extends JPanel{

	Image loadingPath = null;
	Image loading = null;
	Image background = null;
	int time = 1000;
	
	public PanelLoading(){
		background = new ImageIcon("graphics/progress bar/loading.png").getImage();
		loading = new ImageIcon("graphics/progress bar/loading.gif").getImage();
		this.setSize(1000, 600);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(time >= 700){
			loadingPath = new ImageIcon("graphics/progress bar/25%.png").getImage();
		}else if(time >= 500){
			loadingPath = new ImageIcon("graphics/progress bar/50%.png").getImage();
		}else if(time >= 300){
			loadingPath = new ImageIcon("graphics/progress bar/75%.png").getImage();
		}else if(time >= 20){
			loadingPath = new ImageIcon("graphics/progress bar/100%.png").getImage();
		}else{
			Controller.gameframe.getContentPane().setVisible(false);
			Controller.gameframe.fightPanel= new PanelFight();
			Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
			Thread fp = new Thread(Controller.gameframe.fightPanel);
			fp.start();
		}
		time-=2;
		this.repaint();
	//	g.drawImage(background,0, 0, this.getWidth(), this.getHeight(),this);
		g.drawImage(loading,0, 0,this.getWidth(), this.getHeight(),this);
		g.drawImage(loadingPath, 300, 500, 400,20,this);
		
	}
}
