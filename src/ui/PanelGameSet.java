package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dataBase.DataBase;
import tools.Save;
import ui.button.ButtonExit;
import ui.button.ButtonReturn;
import ui.button.ButtonSave;

public class PanelGameSet extends JPanel implements MouseListener{

	String time1,time2,time3="";
	public PanelGameSet() {
		this.setLayout(null);
		//set exit button
		ButtonExit butExit = new ButtonExit();
		if(DataBase.pass<10){
			butExit.type = 2;
		}else{
			butExit.type = 4;
		}
		butExit.setBounds(730, 520, 250, 75);
		butExit.addMouseListener(butExit);
		this.add(butExit);
		//set save button
		for(int i = 1; i <= 3; i++){
			ButtonSave saveButton = new ButtonSave(i);
			saveButton.addMouseListener(saveButton);
			this.add(saveButton);
		}
		//set return button
		ButtonReturn returnButton = new ButtonReturn();
		returnButton.setType(0);
		returnButton.addMouseListener(returnButton);
		this.add(returnButton);
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon("graphics/info/setpanel.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		getTime();
		Font my = new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28);
    	g.setColor(Color.BLACK);
    	g.setFont(my);
    	g.drawString(time1, 380, 230);
    	g.drawString(time2, 380, 330);
    	g.drawString(time3, 380, 430);
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
	
	private void getTime() {
		time1 = Save.getSaveTime(1);
		time2 = Save.getSaveTime(2);
		time3 = Save.getSaveTime(3);
	}

}
