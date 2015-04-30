package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import dataBase.DataBase;
import units.*;

public class ButtonUnit extends JLabel implements MouseListener{
	
	private int kind;
	private boolean isIn = false;
	public ButtonUnit(int kind){
		this.kind = kind;
		this.setBounds(30, 250, 65, 60);
	}
	
	@Override
	public void paintComponent(Graphics g){
		switch(kind){
		case 1:
			if(!isIn){
				g.drawImage(new ImageIcon("graphics/info/units/s1_1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/info/units/s1_2.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}
			break;
		case 2:
			if(!isIn){
				g.drawImage(new ImageIcon("graphics/info/units/s2_1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/info/units/s2_2.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}
			break;
		case 3:
			if(!isIn){
				g.drawImage(new ImageIcon("graphics/info/units/s3_1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/info/units/s3_2.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
			}
			break;
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(kind){
		case 1:
			if(DataBase.Money-DataBase.SWORDMAN_P>=0){
				addSwordman();
			}
			break;
		case 2:
			if(DataBase.Money-DataBase.GUNNER_P>=0){
				addGunner();
			}
			break;
		case 3:
			if(DataBase.Tech_1&&DataBase.Money-DataBase.CANNON_P>=0){
				addCannon();
			}
			break;
		}
	}

	private void addCannon() {
		Cannon cannon = new Cannon();
		cannon.setKind(1);
		DataBase.playerList.add(cannon);
		//start thread
		Thread st = new Thread(cannon);
		st.start();
		//deduct money
		DataBase.Money-=DataBase.CANNON_P;
		
		Controller.gameframe.repaint();
		
	}

	private void addGunner() {
		Gunner gunner = new Gunner();
		gunner.setKind(1);
		DataBase.playerList.add(gunner);
		//start thread
		Thread st = new Thread(gunner);
		st.start();
		//deduct money
		DataBase.Money-=DataBase.GUNNER_P;
		
		Controller.gameframe.repaint();
		
	}

	private void addSwordman() {
		//create sword man
		SwordMan swordman = new SwordMan();
		// set player
		swordman.setKind(1);
		// add to player list
		DataBase.playerList.add(swordman);
		
		//start thread
		Thread st = new Thread(swordman);
		st.start();
		
		//deduct money
		DataBase.Money-=DataBase.SWORDMAN_P;
		
		Controller.gameframe.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
	}	
}
