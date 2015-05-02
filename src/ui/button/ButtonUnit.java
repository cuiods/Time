package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import units.Cannon;
import units.Gunner;
import units.MedicTeam;
import units.Rifle;
import units.Sniper;
import units.SwordMan;
import units.Truck;
import dataBase.DataBase;

public class ButtonUnit extends JLabel implements MouseListener{
	
	private int kind;
	private boolean isIn = false;
	public ButtonUnit(int kind){
		this.kind = kind;
		this.setBounds(30, 250, 65, 60);
	}
	
	@Override
	public void paintComponent(Graphics g){	
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/info/units/s"+this.kind+"_1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/info/units/s"+this.kind+"_2.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
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
		case 0:
			if(DataBase.Money-DataBase.SWORDMAN_P>=0){
				addSwordman();
			}
			break;
		case 1:
			if(DataBase.Money-DataBase.GUNNER_P>=0){
				addGunner();
			}
			break;
		case 2:
			if(DataBase.Tech_CannonEnable&&DataBase.Money-DataBase.CANNON_P>=0){
				addCannon();
			}
			break;
		case 3:
			if(DataBase.Money-DataBase.MEDICTEAM_P>=0){
				addMedicTeam();
			}
			break;
		case 4:
			if(DataBase.Money-DataBase.SNIPER_P>=0){
				addSniper();
			}
			break;
		case 5:
			if(DataBase.Money-DataBase.TRUCK_P>=0){
				addTruck();
			}
			break;
		case 6:
			if(DataBase.Money-DataBase.SWORDMAN_P>=0){
				addRifle();
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
	
	private void addMedicTeam(){
		//create sniper
		MedicTeam medic = new MedicTeam();
		// set player
		medic.setKind(1);
		// add to player list
		DataBase.playerList.add(medic);
						
		//start thread
		Thread st = new Thread(medic);
		st.start();
						
		//deduct money
		DataBase.Money-=DataBase.MEDICTEAM_P;
						
		Controller.gameframe.repaint();
	}
	
	private void addSniper(){
		//create sniper
		Sniper sniper = new Sniper();
		// set player
		sniper.setKind(1);
		// add to player list
		DataBase.playerList.add(sniper);
				
		//start thread
		Thread st = new Thread(sniper);
		st.start();
				
		//deduct money
		DataBase.Money-=DataBase.SNIPER_P;
				
		Controller.gameframe.repaint();
	}
	
	private void addTruck(){
		//create truck
		Truck truck = new Truck();
		// set player
		truck.setKind(1);
		// add to player list
		DataBase.playerList.add(truck);
				
		//start thread
		Thread st = new Thread(truck);
		st.start();
				
		//deduct money
		DataBase.Money-=DataBase.TRUCK_P;
				
		Controller.gameframe.repaint();
	}
	
	private void addRifle(){
		//create rifle
		Rifle rifle = new Rifle();
		// set player
		rifle.setKind(1);
		// add to player list
		DataBase.playerList.add(rifle);
						
		//start thread
		Thread st = new Thread(rifle);
		st.start();
						
		//deduct money
		DataBase.Money-=DataBase.RIFLE_P;
						
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
