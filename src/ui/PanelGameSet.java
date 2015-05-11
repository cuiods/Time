package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonExit;
import ui.button.ButtonReturn;
import ui.button.ButtonSave;

public class PanelGameSet extends JPanel implements MouseListener{

	ButtonExit butExit = null;
	public PanelGameSet() {
		//set exit button
		butExit = new ButtonExit();
		butExit.type = 2;
		butExit.setBounds(60, 230, 250, 75);
		butExit.addMouseListener(butExit);
		this.add(butExit);
		//set save button
		ButtonSave saveButton = new ButtonSave();
		saveButton.addMouseListener(saveButton);
		ButtonReturn returnButton = new ButtonReturn();
		returnButton.addMouseListener(returnButton);
		this.add(returnButton);
		this.add(saveButton);
		//set size
		this.setBounds(290, 160, 360, 386);
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon("graphics/info/setpanel.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
