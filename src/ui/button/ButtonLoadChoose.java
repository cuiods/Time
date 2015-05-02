package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.Save;
import ui.PanelFight;

public class ButtonLoadChoose extends JLabel implements MouseListener{

	private int kind;
	Image image = null;
	Image imagem = null;
	private boolean isIn = false;
	public ButtonLoadChoose(int kind) {
		this.kind = kind;
		this.setBounds(380, 195+kind*70, 200, 50);
		image = new ImageIcon("graphics/info/save/save"+kind+".png").getImage();
		imagem = new ImageIcon("graphics/info/save/save"+kind+"m.png").getImage();
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(!isIn){
			g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		switch(kind){
		case 0:
			Save sv = new Save();
			try {
				sv.Recover();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			Controller.gameframe.getContentPane().setVisible(false);
			Controller.gameframe.fightPanel = new PanelFight();
			Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
			Thread fp = new Thread(Controller.gameframe.fightPanel);
			fp.start();
			break;
		}
		
	}

}
