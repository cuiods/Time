package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGameOver extends JPanel{

	Image gameover = null;
	Image win = null;
	Image exit = null;
	Image next = null;
	boolean isWin = false;
	
	public PanelGameOver(boolean iswin){
		this.setBounds(320, 100, 400, 300);
		gameover = new ImageIcon("graphics/info/gameover.png").getImage();
		if(isWin){
			win = new ImageIcon("graphics/info/win.png").getImage();
		}else{
			win = new ImageIcon("graphics/info/lose.png").getImage();
			exit = new ImageIcon("graphics/button/exitgame.png").getImage();
			next = new ImageIcon("graphics/button/again.png").getImage();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(gameover, 0, 0, this.getWidth(),this.getHeight(),this);
		g.drawImage(win, 80, 80, 240,100,this);
		g.drawImage(exit, 220, 200, 120, 50, this);
		g.drawImage(next, 50, 200, 120, 50, this);
	}
}
