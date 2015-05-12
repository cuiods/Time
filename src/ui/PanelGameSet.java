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

	public PanelGameSet() {
		this.setLayout(null);
		//set exit button
		ButtonExit butExit = new ButtonExit();
		butExit.type = 2;
		butExit.setBounds(730, 520, 250, 75);
		butExit.addMouseListener(butExit);
		this.add(butExit);
//		//set save button
//		for(int i = 1; i <= 3; i++){
//			ButtonSave saveButton = new ButtonSave(i);
//			saveButton.addMouseListener(saveButton);
//			this.add(saveButton);
//		}
		//set return button
		ButtonReturn returnButton = new ButtonReturn();
		returnButton.setType(0);
		returnButton.addMouseListener(returnButton);
		this.add(returnButton);
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
