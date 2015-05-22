package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dataBase.DataBase;
import net.ClientAI;
import net.ServerAI;
import ui.PanelClassic;

public class ButtonSend extends JLabel implements MouseListener{

	private boolean isIn = false;
	public ButtonSend() {
		setBounds(930,570,70,30);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/button/send.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/button/send1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
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
		PanelClassic.textarea.append("me: "+PanelClassic.textfield.getText()+"\n");
		if(ServerAI.socket.isConnected()){
			if(DataBase.isServer){
				ServerAI.sendData(0, PanelClassic.textfield.getText());
			}else{
				ClientAI.sendData(0, PanelClassic.textfield.getText());
			}
		}
		PanelClassic.textfield.setText("");
		PanelClassic.textfield.requestFocus();
	}

}
