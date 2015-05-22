package ui;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonGameSet;
import ui.button.ButtonGiveup;
import ui.button.ButtonOK;
import ui.button.ButtonRestart;
import dataBase.DataBase;

public class PanelGameOver extends JPanel {

	private Image gameover = null;
    private ButtonGiveup give=null;
	private ButtonRestart restart=null;
	private boolean isWin;
	/**
	 * if win, the param is true,otherwise, false
	 * @param iswin
	 */
	public PanelGameOver(boolean iswin){
		this.isWin = iswin;
		this.setBounds(320, 180, 375, 204);
		setLayout(null);
		if(DataBase.pass<10){
			Controller.gameframe.remove(Controller.gameframe.fightPanel);
		}else{
			Controller.gameframe.remove(Controller.gameframe.classicPanel);
		}
		give = new ButtonGiveup();
		give.addMouseListener(give);
		give.setBounds(30, 130, 152,34);
		this.add(give);
		if(iswin){
			//System.out.println("yes");
			restart = new ButtonRestart(0);
			restart.addMouseListener(restart);
			restart.setBounds(200, 130, 152,34);
			this.add(restart);
			gameover =new ImageIcon("graphics/info/youwin.png").getImage();
		}else{
			restart = new ButtonRestart(1);
			restart.addMouseListener(restart);
			restart.setBounds(200, 130, 152,34);
			this.add(restart);
			gameover =new ImageIcon("graphics/info/gameover.png").getImage();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(gameover, 0, 0, 375,204,this);
	}
}

	
		
		
	

