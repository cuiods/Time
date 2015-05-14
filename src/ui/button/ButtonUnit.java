package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import units.*;
import dataBase.DataBase;

public class ButtonUnit extends JLabel implements MouseListener{
	
	private int kind;
	private boolean isIn = false;
	public int path = 0;
	public ButtonUnit(int kind,int path){
		this.kind = kind;
		this.path = path;
		//it's not important, location will be reset
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
		//don't need to care about pass
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
			if(DataBase.Money-DataBase.MEDICTEAM_P>=0&&DataBase.Tech_MedicEnable){
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
			if(DataBase.Money-DataBase.RIFLE_P>=0){
				addRifle();
			}
			break;
		case 7:break;
		case 8:
			if(DataBase.Tech_HydrogenBomb&&DataBase.Money-DataBase.HYDROGENBOMB_P>=0){
				addHydrogenBomb();
			}
			break;
		case 9:
			if(DataBase.Money-DataBase.SPACECARRIER_P>=0){
				addSpacecarrier();
			}
			break;
		case 10:
			if(DataBase.Money-DataBase.SPACEMAN_P>=0){
				addSpaceman();
			}
			break;
		case 11:
			if(DataBase.Money-DataBase.SPACESHIP_P>=0){
				addSpaceship();
			}
			break;
		case 12:
			if(DataBase.Money-DataBase.DRONE_P>=0){
				addDrone();
			}
			break;
		case 13:
			if(DataBase.Money-DataBase.RAZERSHIP_P>=0){
				addRazership();
			}
			break;
		case 14:
			if(DataBase.Money-DataBase.ROBOTWARRIOR_P>=0){
				addRobotWarrior();
			}
			break;
		case 15:
			if(DataBase.Money-DataBase.SNEAKER_P>=0){
				addSneaker();
			}
			break;
			
		}
		/**
		 * attention:what's this mean?
		 * what will never happen? a soldiers foot will never cover another's head
		 * @see Unit
		 */
		Collections.sort(DataBase.playerList);
	}


	private void addSneaker() {
		Sneaker sneaker = new Sneaker();
		sneaker.setKind(1);
		sneaker.path = path;
		sneaker.y += 200*path;
		
		DataBase.playerList.add(sneaker);
		
		Thread t = new Thread(sneaker);
		t.start();
		
		DataBase.Money-=DataBase.SNEAKER_P;
		
		Controller.gameframe.repaint();
		
	}

	private void addRobotWarrior() {
		RobotWarrior robot = new RobotWarrior();
		robot.setKind(1);
		robot.path = path;
		robot.y += 200*path;
		
		DataBase.playerList.add(robot);
		
		Thread t = new Thread(robot);
		t.start();
		
		DataBase.Money-=DataBase.ROBOTWARRIOR_P;
		
		Controller.gameframe.repaint();
		
	}

	private void addRazership() {
		RazerShip ship = new RazerShip();
		ship.setKind(1);
		ship.path = path;
		ship.y += 200*path;
		
		DataBase.playerList.add(ship);
		
		Thread t = new Thread(ship);
		t.start();
		
		DataBase.Money-=DataBase.RAZERSHIP_P;
		
		Controller.gameframe.repaint();
		
	}

	private void addDrone() {
		Drone drone = new Drone();
		drone.setKind(1);
		drone.path = path;
		drone.y += 200*path;
		
		DataBase.playerList.add(drone);
		
		Thread t = new Thread(drone);
		t.start();
		
		DataBase.Money-=DataBase.DRONE_P;
		
		Controller.gameframe.repaint();
		
	}

	private void addSpaceship() {
		
		SpaceShip spaceship = new SpaceShip();
		spaceship.setKind(1);
		spaceship.path = path;
		spaceship.y += 200*path;
			
		DataBase.playerList.add(spaceship);
				
				
		Thread st = new Thread(spaceship);
		st.start();
				
				
		DataBase.Money-=DataBase.SPACESHIP_P;
				
		Controller.gameframe.repaint();
	}

	private void addSpaceman() {
		SpaceMan spaceman = new SpaceMan();
		spaceman.setKind(1);
		spaceman.path = path;
		spaceman.y += 200*path;
			
		DataBase.playerList.add(spaceman);
				
				
		Thread st = new Thread(spaceman);
		st.start();
				
				
		DataBase.Money-=DataBase.SPACEMAN_P;
				
		Controller.gameframe.repaint();
		
	}

	private void addSpacecarrier() {
		SpaceCarrier spacecarrier = new SpaceCarrier();
		spacecarrier.setKind(1);
		spacecarrier.path = path;
		spacecarrier.y += 200*path;
			
		DataBase.playerList.add(spacecarrier);
				
				
		Thread st = new Thread(spacecarrier);
		st.start();
				
				
		DataBase.Money-=DataBase.SPACECARRIER_P;
				
		Controller.gameframe.repaint();
		
	}

	private void addHydrogenBomb() {
		HydrogenBomb bomb = new HydrogenBomb();
		bomb.setKind(1);
		bomb.path = path;
		bomb.y += 200*path;
			
		DataBase.playerList.add(bomb);
				
				
		Thread st = new Thread(bomb);
		st.start();
				
				
		DataBase.Money-=DataBase.HYDROGENBOMB_P;
				
		Controller.gameframe.repaint();
		
	}

	private void addCannon() {
		//new a unit
		Cannon cannon = new Cannon();
		//set kind, enemy don't need to do this
		cannon.setKind(1);
		cannon.path = path;
		cannon.y += 200*path;
		//add  to list 
		DataBase.playerList.add(cannon);
		//start thread
		Thread st = new Thread(cannon);
		st.start();
		//remember this:deduct money
		DataBase.Money-=DataBase.CANNON_P;
		//not necessary
		Controller.gameframe.repaint();
		
	}

	private void addGunner() {
		Gunner gunner = new Gunner();
		gunner.setKind(1);
		gunner.path = path;
		gunner.y += 200*path;
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
		swordman.path = path;
		swordman.y += 200*path;
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
		if(MedicTeam.MedicTeam_Num<=3){
			MedicTeam.MedicTeam_Num++;
		//create medic team
		MedicTeam medic = new MedicTeam();
		// set player
		medic.setKind(1);
		medic.path = path;
		medic.y += 200*path;
		// add to player list
		DataBase.playerList.add(medic);
						
		//start thread
		Thread st = new Thread(medic);
		st.start();
						
		//deduct money
		DataBase.Money-=DataBase.MEDICTEAM_P;
		}
		Controller.gameframe.repaint();
	}
	
	private void addSniper(){
		if(Sniper.Sniper_Num<=4){
			Sniper.Sniper_Num++;
		//create sniper
		Sniper sniper = new Sniper();
		// set player
		sniper.setKind(1);
		sniper.path = path;
		sniper.y += 200*path;
		// add to player list
		DataBase.playerList.add(sniper);
				
		//start thread
		Thread st = new Thread(sniper);
		st.start();
				
		//deduct money
		DataBase.Money-=DataBase.SNIPER_P;
		}
		Controller.gameframe.repaint();
	}
	
	private void addTruck(){
		//create truck
		Truck truck = new Truck();
		// set player
		truck.setKind(1);
		truck.path= path;
		truck.y += 200*path;
		// add to player list
		DataBase.playerList.add(truck);
		if(DataBase.Tech_TruckReinforce){
			truck.setHp(DataBase.TRUCK_HP*2);
		}
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
		rifle.path = path;
		rifle.y += 200*path;
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
