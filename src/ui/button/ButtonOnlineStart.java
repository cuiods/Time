package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import net.ClientAI;
import net.ServerAI;
import ui.FrameGame;
import ui.PanelNetSet;
import dataBase.DataBase;

public class ButtonOnlineStart extends JLabel implements MouseListener{

	private boolean isIn = false;
	public ButtonOnlineStart() {
		setBounds(720, 145, 100,100);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/net/start1.png").getImage(), 0, 0,this.getWidth(),this.getHeight(), this);
		}else{
			g.drawImage(new ImageIcon("graphics/net/start.png").getImage(), 0, 0,this.getWidth(),this.getHeight(), this);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		DataBase.isNet = true;
		if(DataBase.isServer){
			new ServerAI();
			while(true){
				if(ServerAI.socket.isConnected()){
					Controller.changeTo(FrameGame.CLASSICPANEL);
					break;
				}
			}
		}else{
			new ClientAI(PanelNetSet.textIP.getText());
			while(true){
				if(ClientAI.socket.isConnected()){
					Controller.changeTo(FrameGame.CLASSICPANEL);
					break;
				}
			}
		}
		
	}

}
