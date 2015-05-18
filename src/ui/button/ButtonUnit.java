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
	
	protected int kind;
	protected boolean isIn = false;
	public int path = 0;
	public ButtonUnit(int kind,int path){
		this.kind = kind;
		this.path = path;
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
		case 16:
			if(DataBase.Money-DataBase.CAPTAIN_P>=0){
				addCaptain();
			}
			break;
		case 17:
			if(DataBase.Money-DataBase.JOBHUNTER_P>=0){
				addJobHunter();
			}
			break;
		case 18:
			if(DataBase.Money-DataBase.ARTDESIGNER_P>=0){
				addArtDesigner();
			}
			break;
		case 19:
			if(DataBase.Money-DataBase.DATAMAN_P>=0){
				addDataMan();
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


	protected void addSneaker() {
		STG4_Sneaker sneaker = new STG4_Sneaker();
		sneaker.setKind(1);
		sneaker.path = path;
		switch(DataBase.pass){
		case 4:sneaker.y += 240*path;break;
		default:sneaker.y += 160*path;sneaker.x = DataBase.START_LOC_X_STG5;break;
		}
		
		DataBase.playerList.add(sneaker);
		
		Thread t = new Thread(sneaker);
		t.start();
		
		DataBase.Money-=DataBase.SNEAKER_P;
		
		Controller.gameframe.repaint();
		
	}

	protected void addRobotWarrior() {
		STG4_RobotWarrior robot = new STG4_RobotWarrior();
		robot.setKind(1);
		robot.path = path;
		switch(DataBase.pass){
		case 4:robot.y += 240*path;break;
		default:robot.y += 160*path;robot.x = DataBase.START_LOC_X_STG5;break;
		}
		
		DataBase.playerList.add(robot);
		
		Thread t = new Thread(robot);
		t.start();
		
		DataBase.Money-=DataBase.ROBOTWARRIOR_P;
		
		Controller.gameframe.repaint();
		
	}

	protected void addRazership() {
		STG4_RazerShip ship = new STG4_RazerShip();
		ship.setKind(1);
		ship.path = path;
		switch(DataBase.pass){
		case 4:ship.y += 240*path;break;
		default:ship.y += 160*path;ship.x = DataBase.START_LOC_X_STG5;break;
		}
		
		DataBase.playerList.add(ship);
		
		Thread t = new Thread(ship);
		t.start();
		
		DataBase.Money-=DataBase.RAZERSHIP_P;
		
		Controller.gameframe.repaint();
		
	}

	protected void addDrone() {
		STG4_Drone drone = new STG4_Drone();
		drone.setKind(1);
		drone.path = path;
		switch(DataBase.pass){
		case 4:drone.y += 240*path;break;
		default:drone.y += 160*path;drone.x = DataBase.START_LOC_X_STG5;break;
		}
		
		DataBase.playerList.add(drone);
		
		Thread t = new Thread(drone);
		t.start();
		
		DataBase.Money-=DataBase.DRONE_P;
		
		Controller.gameframe.repaint();
		
	}

	protected void addSpaceship() {
		
		STG3_SpaceShip spaceship = new STG3_SpaceShip();
		spaceship.setKind(1);
		spaceship.path = path;
		switch(DataBase.pass){
		case 3:break;
		default:spaceship.y = DataBase.START_LOC_Y_STG5+160*path;
		spaceship.x = DataBase.START_LOC_X_STG5;
		}
			
		DataBase.playerList.add(spaceship);
				
				
		Thread st = new Thread(spaceship);
		st.start();
				
				
		DataBase.Money-=DataBase.SPACESHIP_P;
				
		Controller.gameframe.repaint();
	}

	protected void addSpaceman() {
		STG3_SpaceMan spaceman = new STG3_SpaceMan();
		spaceman.setKind(1);
		spaceman.path = path;
		switch(DataBase.pass){
		case 3:break;
		default:spaceman.y = DataBase.START_LOC_Y_STG5+160*path;
		spaceman.x = DataBase.START_LOC_X_STG5;
		}
			
		DataBase.playerList.add(spaceman);
				
				
		Thread st = new Thread(spaceman);
		st.start();
				
				
		DataBase.Money-=DataBase.SPACEMAN_P;
				
		Controller.gameframe.repaint();
		
	}

	protected void addSpacecarrier() {
		STG3_SpaceCarrier spacecarrier = new STG3_SpaceCarrier();
		spacecarrier.setKind(1);
		spacecarrier.path = path;
		switch(DataBase.pass){
		case 3:break;
		default:spacecarrier.y = DataBase.START_LOC_Y_STG5+160*path;
		spacecarrier.x = DataBase.START_LOC_X_STG5;
		}
			
		DataBase.playerList.add(spacecarrier);
				
				
		Thread st = new Thread(spacecarrier);
		st.start();
				
				
		DataBase.Money-=DataBase.SPACECARRIER_P;
				
		Controller.gameframe.repaint();
		
	}

	protected void addHydrogenBomb() {
		STG3_HydrogenBomb bomb = new STG3_HydrogenBomb();
		bomb.setKind(1);
		bomb.path = path;
		switch(DataBase.pass){
		case 3:break;
		default:bomb.y = DataBase.START_LOC_Y_STG5+160*path;
		bomb.x = DataBase.START_LOC_X_STG5;
		}
			
		DataBase.playerList.add(bomb);
				
				
		Thread st = new Thread(bomb);
		st.start();
				
				
		DataBase.Money-=DataBase.HYDROGENBOMB_P;
				
		Controller.gameframe.repaint();
		
	}

	protected void addCannon() {
		//new a unit
		STG1_Cannon cannon = new STG1_Cannon();
		//set kind, enemy don't need to do this
		cannon.setKind(1);
		cannon.path = path;
		switch(DataBase.pass){
		case 1:break;
		default:cannon.y = DataBase.START_LOC_Y_STG5+160*path;
		cannon.x = DataBase.START_LOC_X_STG5;
		}
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

	protected void addGunner() {
		STG1_Gunner gunner = new STG1_Gunner();
		gunner.setKind(1);
		gunner.path = path;
		switch(DataBase.pass){
		case 1:break;
		default:gunner.y = DataBase.START_LOC_Y_STG5+160*path;
		gunner.x = DataBase.START_LOC_X_STG5;
		}
		DataBase.playerList.add(gunner);
		//start thread
		Thread st = new Thread(gunner);
		st.start();
		//deduct money
		DataBase.Money-=DataBase.GUNNER_P;
		
		Controller.gameframe.repaint();
		
	}

	protected void addSwordman() {
		//create sword man
		STG1_SwordMan swordman = new STG1_SwordMan();
		// set player
		swordman.setKind(1);
		swordman.path = path;
		switch(DataBase.pass){
		case 1:break;
		default:swordman.y = DataBase.START_LOC_Y_STG5+160*path;
		swordman.x = DataBase.START_LOC_X_STG5;
		}
		// add to player list
		DataBase.playerList.add(swordman);
		
		//start thread
		Thread st = new Thread(swordman);
		st.start();
		
		//deduct money
		DataBase.Money-=DataBase.SWORDMAN_P;
		
		Controller.gameframe.repaint();
		
	}
	
	protected void addMedicTeam(){
		if(STG2_MedicTeam.MedicTeam_Num<=3){
			STG2_MedicTeam.MedicTeam_Num++;
		//create medic team
		STG2_MedicTeam medic = new STG2_MedicTeam();
		// set player
		medic.setKind(1);
		medic.path = path;
		switch(DataBase.pass){
		case 2:break;
		default:medic.y = DataBase.START_LOC_Y_STG5+160*path;
		medic.x = DataBase.START_LOC_X_STG5;
		}
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
	
	protected void addSniper(){
		if(STG2_Sniper.Sniper_Num<=4){
			STG2_Sniper.Sniper_Num++;
		//create sniper
		STG2_Sniper sniper = new STG2_Sniper();
		// set player
		sniper.setKind(1);
		sniper.path = path;
		switch(DataBase.pass){
		case 2:break;
		default:sniper.y = DataBase.START_LOC_Y_STG5+160*path;
		sniper.x = DataBase.START_LOC_X_STG5;
		}
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
	
	protected void addTruck(){
		//create truck
		STG2_Truck truck = new STG2_Truck();
		// set player
		truck.setKind(1);
		truck.path= path;
		switch(DataBase.pass){
		case 2:break;
		default:truck.y = DataBase.START_LOC_Y_STG5+160*path;
		truck.x = DataBase.START_LOC_X_STG5;
		}
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
	
	protected void addRifle(){
		//create rifle
		STG2_Rifle rifle = new STG2_Rifle();
		// set player
		rifle.setKind(1);
		rifle.path = path;
		switch(DataBase.pass){
		case 2:break;
		default:rifle.y = DataBase.START_LOC_Y_STG5+160*path-40;
		rifle.x = DataBase.START_LOC_X_STG5;
		}
		// add to player list
		DataBase.playerList.add(rifle);
						
		//start thread
		Thread st = new Thread(rifle);
		st.start();
						
		//deduct money
		DataBase.Money-=DataBase.RIFLE_P;
						
		Controller.gameframe.repaint();
	}
	protected void addCaptain(){
		STG6_Captain cui = new STG6_Captain();
		cui.setKind(1);
		cui.path = path;
	
		DataBase.playerList.add(cui);
		Thread st = new Thread(cui);
		st.start();
		DataBase.Money-=DataBase.CAPTAIN_P;
		
		Controller.gameframe.repaint();
	}
	protected void addJobHunter(){
		STG6_JobHunter du = new STG6_JobHunter();
		du.setKind(1);
		du.path = path;
	
		DataBase.playerList.add(du);
		Thread st = new Thread(du);
		st.start();
		DataBase.Money-=DataBase.JOBHUNTER_P;
		
		Controller.gameframe.repaint();
	}
	protected void addArtDesigner(){
		STG6_Artdesigner gao = new STG6_Artdesigner();
		gao.setKind(1);
		gao.path = path;
	
		DataBase.playerList.add(gao);
		Thread st = new Thread(gao);
		st.start();
		DataBase.Money-=DataBase.ARTDESIGNER_P;
		
		Controller.gameframe.repaint();
	}
	protected void addDataMan(){
		STG6_DataMan nian = new STG6_DataMan();
		nian.setKind(1);
		nian.path = path;
	
		DataBase.playerList.add(nian);
		Thread st = new Thread(nian);
		st.start();
		DataBase.Money-=DataBase.DATAMAN_P;
		
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
