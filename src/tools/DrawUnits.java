package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.PanelFight;
import units.Cannon;
import units.Castle;
import units.Drone;
import units.Gunner;
import units.HydrogenBomb;
import units.MedicTeam;
import units.RazerShip;
import units.Rifle;
import units.RobotWarrior;
import units.SecondCastle;
import units.Sneaker;
import units.Sniper;
import units.SpaceCarrier;
import units.SpaceMan;
import units.SpaceShip;
import units.SwordMan;
import units.Truck;
import units.Unit;
import Tech.Object_BlackHole;
import dataBase.DataBase;

public class DrawUnits {
	static JPanel panel;
	static String[] pictures = new String[10];
	static String pictures6[]={"graphics/stunt/carrier1.png","graphics/stunt/carrier2.png","graphics/stunt/carrier3.png","graphics/stunt/carrier4.png","graphics/stunt/carrier5.png","graphics/stunt/carrier6.png","graphics/stunt/carrier7.png","graphics/stunt/carrier8.png","graphics/stunt/carrier9.png","graphics/stunt/carrier10.png"};
	public static void draw(Graphics g, JPanel p){
		     panel = p;
			/*
			 * draw player units
			 */

			
			for(int i = 0;i < DataBase.playerList.size();i++){
				switch(DataBase.playerList.get(i).getType()){
				case 0:
					drawSwordman(g,(SwordMan)DataBase.playerList.get(i));
					break;
				case 1:
					drawGunner(g,(Gunner)DataBase.playerList.get(i));
					break;
				case 2:
					drawCannon(g,(Cannon)DataBase.playerList.get(i));
					break;
				case 3:
					drawMedicTeam(g, (MedicTeam)DataBase.playerList.get(i));
					break;
				case 4:
					drawSniper(g,(Sniper)DataBase.playerList.get(i));
					break;
				case 5:
					drawTruck(g, (Truck)DataBase.playerList.get(i));
					break;
				case 6:
					drawRifle(g, (Rifle)DataBase.playerList.get(i));
					break;
				case 7:
					break;
				case 8:
					drawHydrogenBomb(g,(HydrogenBomb)DataBase.playerList.get(i));
					break;
				case 9:
					drawSpaceCarrier(g,(SpaceCarrier)DataBase.playerList.get(i));
					break;
				case 10:
					drawSpaceMan(g,(SpaceMan)DataBase.playerList.get(i));
					break;
				case 11:
					drawSpaceShip(g,(SpaceShip)DataBase.playerList.get(i));
					break;
				case 101:
					drawSecondCastle(g, (SecondCastle) DataBase.playerList.get(i));
					break;
				case 12:
					drawDrone(g, (Drone) DataBase.playerList.get(i));
					break;
				case 13:
					drawRazerShip(g, (RazerShip) DataBase.playerList.get(i));
					break;
				case 14:
					drawRobot(g, (RobotWarrior) DataBase.playerList.get(i));
					break;
				case 15:
					drawSneaker(g, (Sneaker) DataBase.playerList.get(i));
					break;
				case 102:
					drawBlackHole(g, (Object_BlackHole) DataBase.playerList.get(i));
					break;
				default:
					drawCastle(g, (Castle) DataBase.playerList.get(i));
					break;
				}
			}
			/*
			 * draw enemy units
			 */
			for(int i = 0;i < DataBase.enemyList.size();i++){
				switch(DataBase.enemyList.get(i).getType()){
				case 0:
					drawSwordman(g,(SwordMan)DataBase.enemyList.get(i));
					break;
				case 1:
					drawGunner(g,(Gunner)DataBase.enemyList.get(i));
					break;
				case 2:
					drawCannon(g,(Cannon)DataBase.enemyList.get(i));
					break;
				case 3:
					drawMedicTeam(g, (MedicTeam)DataBase.enemyList.get(i));
					break;
				case 4:
					drawSniper(g,(Sniper)DataBase.enemyList.get(i));
					break;
				case 5:
					drawTruck(g, (Truck)DataBase.enemyList.get(i));
					break;
				case 6:
					drawRifle(g, (Rifle)DataBase.enemyList.get(i));
					break;
				case 9:
					drawSpaceCarrier(g,(SpaceCarrier)DataBase.enemyList.get(i));
					break;
				case 10:
					drawSpaceMan(g,(SpaceMan)DataBase.enemyList.get(i));
					break;
				case 11:
					drawSpaceShip(g,(SpaceShip)DataBase.enemyList.get(i));
					break;
				case 12:
					drawDrone(g, (Drone) DataBase.enemyList.get(i));
					break;
				case 13:
					drawRazerShip(g, (RazerShip) DataBase.enemyList.get(i));
					break;
				case 14:
					drawRobot(g, (RobotWarrior) DataBase.enemyList.get(i));
					break;
				case 15:
					drawSneaker(g, (Sneaker) DataBase.enemyList.get(i));
					break;
				case 100:
					drawCastle(g, (Castle) DataBase.enemyList.get(i));
					break;
				}
			}
			//draw shadow  410 230
			if(DataBase.pass==3){
				if(DataBase.Tech_Harper_TIME==0){
				   g.drawImage(new ImageIcon("graphics/background/shadow1.png").getImage(),0, 0,1000, 600, null);
				}else if(DataBase.Tech_Harper_TIME==1)	
				   g.drawImage(new ImageIcon("graphics/background/shadow2.png").getImage(),0, 0,1000, 600, null);
				}
		}

	/**
	 * draw sword man
	 */
	private static void drawSwordman(Graphics g,SwordMan o){
		switch(o.getKind()){
		//this is player
		case 1:
			//define a picture
			Image swordman1 = null;	
			//if it's moving
			if(o.moving){
				if(!DataBase.isPause){
					//if it's pause,just use a picture,else,use a gif
					swordman1 = new ImageIcon("graphics/soldiers/s/s1walk.gif").getImage();
				}else{
					swordman1 = new ImageIcon("graphics/soldiers/s/s1.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					swordman1 = new ImageIcon("graphics/soldiers/s/s1fight.gif").getImage();
				}else{
					swordman1 = new ImageIcon("graphics/soldiers/s/s1fight.png").getImage();
				}
			}
			g.drawImage(swordman1,o.getX(), o.getY()+o.ran, 40, 62,panel );
			break;
		//this is enemy
		case 0:
			Image swordman0 = new ImageIcon("graphics/soldiers/en/en1.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					swordman0 = new ImageIcon("graphics/soldiers/en/en1walk.gif").getImage();
				}else{
					swordman0 = new ImageIcon("graphics/soldiers/en/en1.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					swordman0 = new ImageIcon("graphics/soldiers/en/en1fight.gif").getImage();
				}else{
					swordman0 = new ImageIcon("graphics/soldiers/en/en1fight.png").getImage();
				}
			}
			g.drawImage(swordman0,o.getX(), o.getY()+o.ran, 40, 62, panel);
			break;
		}
		//draw life,show the life of the unit
		int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.SWORDMAN_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
		}
		
	}
	
	/**
	 * draw gunner
	 */
	private static void drawGunner(Graphics g,Gunner o){
		switch(o.getKind()){
		case 1:
			Image gunner1 = new ImageIcon("graphics/soldiers/s/s3.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					gunner1 = new ImageIcon("graphics/soldiers/s/s2walk.gif").getImage();
				}else{
					gunner1 = new ImageIcon("graphics/soldiers/s/s3.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					gunner1 = new ImageIcon("graphics/soldiers/s/s3fight.gif").getImage();
				}else{
					gunner1 = new ImageIcon("graphics/soldiers/s/s2(fight).png").getImage();
				}
			}
			g.drawImage(gunner1,o.getX(), o.getY()+o.ran, 40, 81, panel);
			break;
		case 0:
			Image gunner0 = new ImageIcon("graphics/soldiers/en/en2.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					gunner0 = new ImageIcon("graphics/soldiers/en/en2walk.gif").getImage();
				}else{
					gunner0 = new ImageIcon("graphics/soldiers/en/en3.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					gunner0 = new ImageIcon("graphics/soldiers/en/en2fight.gif").getImage();
				}else{
					gunner0 = new ImageIcon("graphics/soldiers/en/en2(fight).png").getImage();
				}
			}
			g.drawImage(gunner0,o.getX(), o.getY()+o.ran, 40, 81, panel);
		}
		//draw life
		int lifePercentage = (int)(40 *1.0* (o.getHp()*1.00/DataBase.GUNNER_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()-10+o.ran, 40-lifePercentage, 3, false);
		}
	}
	
	/**
	 * draw cannon
	 */
	private static void drawCannon(Graphics g,Cannon o){  	
		switch(o.getKind()){
		case 1:
			Image cannon1 = new ImageIcon("graphics/soldiers/s/s2.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					cannon1 = new ImageIcon("graphics/soldiers/s/s3walk.gif").getImage();
				}else{
					cannon1 = new ImageIcon("graphics/soldiers/s/s2.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					cannon1 = new ImageIcon("graphics/soldiers/s/s2fight.gif").getImage();
				}else{
					cannon1 = new ImageIcon("graphics/soldiers/s/s2fight.png").getImage();
				}
			}
			g.drawImage(cannon1,o.getX(), o.getY()+o.ran, 40, 64, panel);
			break;
		case 0:
			Image cannon0 = new ImageIcon("graphics/soldiers/en/en2.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					cannon0 = new ImageIcon("graphics/soldiers/en/en3walk.gif").getImage();
				}else{
					cannon0 = new ImageIcon("graphics/soldiers/en/en2.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					cannon0 = new ImageIcon("graphics/soldiers/en/en3fight.gif").getImage();
				}else{
					cannon0 = new ImageIcon("graphics/soldiers/en/en2fight.png").getImage();
				}
			}
			g.drawImage(cannon0,o.getX(), o.getY()+o.ran, 40, 64, panel);
		}
		//draw life
	    int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.0/DataBase.CANNON_HP));
		g.setColor(Color.GREEN);
	    g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()-10+o.ran, 40-lifePercentage, 3, false);
		}
	}
	
	/**
	 * draw medic team
	 */
	private static void drawMedicTeam(Graphics g,MedicTeam o){
		switch(o.getKind()){
		case 1:
			Image medic = new ImageIcon("graphics/soldiers/s2/medic.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					medic = new ImageIcon("graphics/soldiers/s2/medic.png").getImage();
				}else{
					medic = new ImageIcon("graphics/soldiers/s2/medic.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					medic = new ImageIcon("graphics/soldiers/s2/medic.png").getImage();
				}else{
					medic = new ImageIcon("graphics/soldiers/s2/medic.png").getImage();
				}
			}
			g.drawImage(medic,o.getX()+100, o.getY()+o.ran-200, 100,56, panel);
			break;
		case 0:
			Image medic0 = new ImageIcon("graphics/soldiers/en2/medic0.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					medic0 = new ImageIcon("graphics/soldiers/en2/medic0.png").getImage();
				}else{
					medic0 = new ImageIcon("graphics/soldiers/en2/medic0.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					medic0 = new ImageIcon("graphics/soldiers/en2/medic0.png").getImage();
				}else{
					medic0 = new ImageIcon("graphics/soldiers/en2/medic0.png").getImage();
				}
			}
			g.drawImage(medic0,o.getX()-30, o.getY()+o.ran+20,75, 42, panel);
		}
		
//		//draw life
//		switch(o.getKind()){
//		case 1:
//			int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.MEDICTEAM_HP));
//			g.setColor(Color.GREEN);
//			g.fill3DRect(o.getX(), o.getY()-10-200+o.ran, lifePercentage, 3, false);
//			if(lifePercentage!=40){
//				g.setColor(Color.RED);		
//				g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10-200, 40-lifePercentage, 3, false);		
//			}
//			break;
//		case 0:
//			int lifePercentage0 = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.MEDICTEAM_HP));
//			g.setColor(Color.GREEN);
//			g.fill3DRect(o.getX(), o.getY()-10+o.ran-50, lifePercentage0, 3, false);
//			if(lifePercentage0!=40){
//				g.setColor(Color.RED);		
//				g.fill3DRect(o.getX()+lifePercentage0, o.getY()+o.ran-10-50, 40-lifePercentage0, 3, false);		
//			}
//		}
	}
	
	/**
	 * draw snooper
	 */
	private static void drawSniper(Graphics g,Sniper o){
		switch(o.getKind()){
		case 1:
			Image sniper = new ImageIcon("graphics/soldiers/s2/sniper1.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					sniper = new ImageIcon("graphics/soldiers/s2/sniper1.png").getImage();
				}else{
					sniper = new ImageIcon("graphics/soldiers/s2/sniper1.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					sniper = new ImageIcon("graphics/soldiers/s2/sniper1.gif").getImage();
				}else{
					sniper = new ImageIcon("graphics/soldiers/s2/sniper1.png").getImage();
				}
			}
			g.drawImage(sniper,o.getX(), o.getY()+o.ran, 50, 50, panel);
			break;
		case 0:
			Image sniper0 = new ImageIcon("graphics/soldiers/en2/sniper1.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					sniper0 = new ImageIcon("graphics/soldiers/en2/sniper1.png").getImage();
				}else{
					sniper0 = new ImageIcon("graphics/soldiers/en2/sniper1.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					sniper0 = new ImageIcon("graphics/soldiers/en2/ensniper.gif").getImage();
				}else{
					sniper0 = new ImageIcon("graphics/soldiers/en2/sniper1.png").getImage();
				}
			}
			g.drawImage(sniper0,o.getX(), o.getY()+o.ran, 50, 50, panel);
			break;
			
		}
		
//		//draw life
//		int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.SNIPER_HP));
//		g.setColor(Color.GREEN);
//		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
//		if(lifePercentage!=40){
//			g.setColor(Color.RED);
//			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
//		}
	}
	
	/**
	 * draw truck
	 */
	private static void drawTruck(Graphics g, Truck o){
		switch(o.getKind()){
		case 1:
			Image truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
			if(!DataBase.isPause){
				if(DataBase.Tech_TruckReinforce){
					truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
				}else{
					truck = new ImageIcon("graphics/soldiers/s2/truck1.png").getImage();
				}
			}else{
				truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
			}
			g.drawImage(truck,o.getX(), o.getY()+o.ran, 96, 78, panel);
			break;
		case 0:
			Image truck0 = new ImageIcon("graphics/soldiers/en2/truck0.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					truck0 = new ImageIcon("graphics/soldiers/en2/truck0.png").getImage();
				}else{
					truck0 = new ImageIcon("graphics/soldiers/en2/truck0.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					truck0 = new ImageIcon("graphics/soldiers/en2/truck0.png").getImage();
				}else{
					truck0 = new ImageIcon("graphics/soldiers/en2/truck0.png").getImage();
				}
			}
			g.drawImage(truck0,o.getX(), o.getY()+o.ran, 96, 78, panel);
			break;
			
		}
		
		int lifePercentage = 0;
		if(!DataBase.Tech_TruckReinforce){
			lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.TRUCK_HP));
		}else{
			lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/(2*DataBase.TRUCK_HP)));
		}
		//draw life 
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX()+20, o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+20+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
		}
	}
	
	/**
	 * draw rifle soldier
	 */
	private static void drawRifle(Graphics g,Rifle o){
		switch(o.getKind()){
		case 1:
			Image rifle = new ImageIcon("graphics/soldiers/s2/s1.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					rifle = new ImageIcon("graphics/soldiers/s2/s4walk1.gif").getImage();
				}else{
					rifle = new ImageIcon("graphics/soldiers/s2/s1.png").getImage();
				}
				g.drawImage(rifle,o.getX(), o.getY()+o.ran, 41 , 80, panel);
			}else if(o.attacking){
				if(!DataBase.isPause){
					rifle = new ImageIcon("graphics/soldiers/s2/s1fight.gif").getImage();
				}else{
					rifle = new ImageIcon("graphics/soldiers/s2/s1.png").getImage();
				}
				g.drawImage(rifle,o.getX(), o.getY()+o.ran, 60, 80, panel);
			}
			break;
		case 0:
			Image rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4walk1.gif").getImage();
				}else{
					rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4.png").getImage();
				}
				g.drawImage(rifle0,o.getX(), o.getY()+o.ran, 41, 80, panel);
			}else if(o.attacking){
				if(!DataBase.isPause){
					rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4fight.png").getImage();
				}else{
					rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4.png").getImage();
				}
				g.drawImage(rifle0,o.getX(), o.getY()+o.ran, 60, 80, panel);
			}
			break;
		}
		
		//draw life
		int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.RIFLE_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
		}
	}
	private static  void drawHydrogenBomb(Graphics g,HydrogenBomb o){
		switch(o.getKind()){
		case 1:
			
			Image hbomb = new ImageIcon("graphics/soldiers/s3/HydrogenBomb.png").getImage();
			g.drawImage(hbomb, o.getX(), o.getY()+o.ran,176,80,panel);
			
			if(o.starting){
				
				for(int i=1;i<11;i++){
					pictures[i-1]="graphics/stunt/tech3_"+i+".png";
				}
				if(o.time > 900){
					g.drawImage(new ImageIcon(pictures[0]).getImage(), o.getX(), o.getY(), panel);
					
				}else if(o.time > 800){
					g.drawImage(new ImageIcon(pictures[1]).getImage(), o.getX(), o.getY(), panel);
				}else if(o.time > 700){
					g.drawImage(new ImageIcon(pictures[2]).getImage(), o.getX(), o.getY(), panel);
				}else if(o.time > 600){
					g.drawImage(new ImageIcon(pictures[3]).getImage(), o.getX(), o.getY(), panel);
				}else if(o.time > 500){
					g.drawImage(new ImageIcon(pictures[4]).getImage(), o.getX(), o.getY(), panel);
				}else if(o.time > 400){
					g.drawImage(new ImageIcon(pictures[5]).getImage(), o.getX(), o.getY(), panel);
				}else if(o.time > 300){
					g.drawImage(new ImageIcon(pictures[6]).getImage(), o.getX(), o.getY(), panel);
				}else if(o.time > 200){
					g.drawImage(new ImageIcon(pictures[7]).getImage(), o.getX(), o.getY(), panel);
				}else if(o.time > 100){
					g.drawImage(new ImageIcon(pictures[8]).getImage(), o.getX(), o.getY(), panel);
				}else{
					g.drawImage(new ImageIcon(pictures[9]).getImage(), o.getX(), o.getY(), panel);
					o.starting=false;
					DataBase.playerList.remove(o);
			    }
				if(o.time-100>=0){
					o.time-=100;
				}
			}
					
				
			break;
		case 0:
			Image hbomb0 = new ImageIcon("graphics/soldiers/en3/HydrogenBomb.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					hbomb0 = new ImageIcon("graphics/soldiers/en3/HydrogenBomb.gif").getImage();
				}else{
					hbomb0 = new ImageIcon("graphics/soldiers/en3/HydrogenBomb.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					hbomb0 = new ImageIcon("graphics/soldiers/en3/HydrogenBomb.gif").getImage();
				}else{
					hbomb0 = new ImageIcon("graphics/soldiers/en3/HydrogenBomb.png").getImage();
				}
			}
			g.drawImage(hbomb0,o.getX(), o.getY()+o.ran, 1020, 709, panel);
			break;
    	}
    	int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.HYDROGENBOMB_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX()+50, o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage+50, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
	    }
	}
    private static void drawSpaceCarrier(Graphics g,SpaceCarrier o){
    	switch(o.getKind()){
		case 1:
			Image carrier = new ImageIcon("graphics/soldiers/s3/carrier.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					carrier = new ImageIcon("graphics/soldiers/s3/carrier.png").getImage();
				}else{
					carrier = new ImageIcon("graphics/soldiers/s3/carrier.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					carrier = new ImageIcon("graphics/soldiers/s3/carrier.png").getImage();
				}else{
					carrier = new ImageIcon("graphics/soldiers/s3/carrier.png").getImage();
				}
			}
			
			g.drawImage(carrier,o.getX(), o.getY()+o.ran, 180, 120, panel);
			break;
		case 0:
			Image carrier0 = new ImageIcon("graphics/soldiers/en3/carrier.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					carrier0 = new ImageIcon("graphics/soldiers/en3/carrier.png").getImage();
				}else{
					carrier0 = new ImageIcon("graphics/soldiers/en3/carrier.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					carrier0 = new ImageIcon("graphics/soldiers/en3/carrier.png").getImage();
				}else{
					carrier0 = new ImageIcon("graphics/soldiers/en3/carrier.png").getImage();
				}
			}
			g.drawImage(carrier0,o.getX(), o.getY()+o.ran, 180, 120, panel);
			break;
    	}
    	int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.SPACECARRIER_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX()+50, o.getY()+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage+50, o.getY()+o.ran, 40-lifePercentage, 3, false);
	    }
   }
    private static void drawSpaceMan(Graphics g,SpaceMan o){
    	switch(o.getKind()){
		case 1:
			Image spaceman = new ImageIcon("graphics/soldiers/s3/spaceman.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					spaceman = new ImageIcon("graphics/soldiers/s3/spaceman.png").getImage();
				}else{
					spaceman = new ImageIcon("graphics/soldiers/s3/spaceman.png").getImage();

				}
				g.drawImage(spaceman,o.getX(), o.getY()+o.ran,72,112, panel);
			}else if(o.attacking){
				if(!DataBase.isPause){
					spaceman = new ImageIcon("graphics/soldiers/s3/spaceman.gif").getImage();
				}else{
					spaceman = new ImageIcon("graphics/soldiers/s3/spaceman1.png").getImage();
				}
				g.drawImage(spaceman,o.getX()-50, o.getY()+o.ran,160,120, panel);
			}
			
			break;
		case 0:
			Image spaceman0 = new ImageIcon("graphics/soldiers/en3/soldier4.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					spaceman0 = new ImageIcon("graphics/soldiers/en3/soldier4.gif").getImage();
				}else{
					spaceman0 = new ImageIcon("graphics/soldiers/en3/soldier4.gif").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					spaceman0 = new ImageIcon("graphics/soldiers/en3/soldier4.gif").getImage();
				}else{
					spaceman0 = new ImageIcon("graphics/soldiers/en3/soldier4.gif").getImage();
				}
			}
			g.drawImage(spaceman0,o.getX(), o.getY()+o.ran, 180, 120, panel);
			break;
    	}
    	int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.SPACEMAN_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX()+10+(1-o.getKind())*70, o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage+10+(1-o.getKind())*70, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
	    }
	}
    private static void drawSpaceShip(Graphics g,SpaceShip o){
    	switch(o.getKind()){
		case 1:
			Image spaceship = new ImageIcon("graphics/soldiers/s3/spaceship.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					spaceship = new ImageIcon("graphics/soldiers/s3/spaceship.png").getImage();
				}else{
					spaceship = new ImageIcon("graphics/soldiers/s3/spaceship.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					spaceship = new ImageIcon("graphics/soldiers/s3/spaceship.png").getImage();
				}else{
					spaceship = new ImageIcon("graphics/soldiers/s3/spaceship.png").getImage();
				}
			}
			g.drawImage(spaceship,o.getX(), o.getY()+o.ran-100, 144,85, panel);
			break;
		case 0:
			Image spaceship0 = new ImageIcon("graphics/soldiers/en3/ufo.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					spaceship0 = new ImageIcon("graphics/soldiers/en3/ufo.png").getImage();
				}else{
					spaceship0 = new ImageIcon("graphics/soldiers/en3/ufo.png").getImage();
				}
				
			}else if(o.attacking){
				if(!DataBase.isPause){
					spaceship0 = new ImageIcon("graphics/soldiers/en3/ufo_attack.png").getImage();
				}else{
					spaceship0 = new ImageIcon("graphics/soldiers/en3/ufo.png").getImage();
				}
			}
			g.drawImage(spaceship0,o.getX(), o.getY()+o.ran,144, 72, panel);
			break;
    	}
    	int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.SPACESHIP_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX()+80, o.getY()-110+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage+80, o.getY()+o.ran-110, 40-lifePercentage, 3, false);
	    }
    	
	}
    /**
     * draw drone
     */
    private static void drawDrone(Graphics g,Drone o){
    	switch(o.getKind()){
		case 1:
			Image drone = new ImageIcon("graphics/soldiers/s4/drone.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					drone = new ImageIcon("graphics/soldiers/s4/drone.png").getImage();
				}else{
					drone = new ImageIcon("graphics/soldiers/s4/drone.png").getImage();
				}
				g.drawImage(drone,o.getX(), o.getY()+o.ran, 59, 36, panel);
			}else if(o.attacking){
				if(!DataBase.isPause){
					drone = new ImageIcon("graphics/soldiers/s4/droneattack.gif").getImage();
					g.drawImage(drone,o.getX(), o.getY()+o.ran, 135, 36, panel);
				}else{
					drone = new ImageIcon("graphics/soldiers/s4/drone.png").getImage();
					g.drawImage(drone,o.getX(), o.getY()+o.ran, 59, 36, panel);
				}
			}
			break;
		case 0:
			Image drone1 = new ImageIcon("graphics/soldiers/en4/drone.png").getImage();
			if(o.moving){
				
					drone1 = new ImageIcon("graphics/soldiers/en4/drone.png").getImage();
				
			}else if(o.attacking){
				if(!DataBase.isPause){
					drone1 = new ImageIcon("graphics/soldiers/en4/drone.png").getImage();
				}else{
					drone1 = new ImageIcon("graphics/soldiers/en4/drone.png").getImage();
				}
			}
			g.drawImage(drone1,o.getX(), o.getY()+o.ran, 50, 50, panel);
			break;
    	}
    	int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.DRONE_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
	    }
    }
    /**
     * draw razer ship
     */
    private static void drawRazerShip(Graphics g,RazerShip o){
    	switch(o.getKind()){
		case 1:
			Image ship = new ImageIcon("graphics/soldiers/s4/razership.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					ship = new ImageIcon("graphics/soldiers/s4/razership.png").getImage();
				}else{
					ship = new ImageIcon("graphics/soldiers/s4/razership.png").getImage();
				}
				g.drawImage(ship,o.getX(), o.getY()+o.ran, 200, 94, panel);
			}else if(o.attacking){
				if(!DataBase.isPause){
					ship = new ImageIcon("graphics/soldiers/s4/razership.png").getImage();
					g.setColor(Color.red);
					Unit e = DataBase.enemyList.get(o.detect());
					g.drawLine(o.x+64, o.y+o.ran+31, e.x+25, e.y+30);
					g.drawImage(ship,o.getX(), o.getY()+o.ran, 200, 94, panel);
					g.drawLine(o.x+65, o.y+o.ran+32, e.x+25, e.y+30);
					g.drawLine(o.x+66, o.y+o.ran+33, e.x+25, e.y+30);
					g.drawImage(new ImageIcon("graphics/soldiers/s4/razerattac.gif").getImage(),o.getX()+50, o.getY()+o.ran+16, 30, 30, panel);
				}else{
					ship = new ImageIcon("graphics/soldiers/s4/razership.png").getImage();
					g.drawImage(ship,o.getX(), o.getY()+o.ran, 200, 94, panel);
				}
			}
			break;
		case 0:
			Image ship1 = new ImageIcon("graphics/soldiers/en4/razership.png").getImage();
			if(o.moving){
				
					ship1 = new ImageIcon("graphics/soldiers/en4/razership.png").getImage();
				
			}else if(o.attacking){
				if(!DataBase.isPause){
					ship1 = new ImageIcon("graphics/soldiers/en4/razership.png").getImage();
				}else{
					ship1 = new ImageIcon("graphics/soldiers/en4/razership.png").getImage();
				}
			}
			g.drawImage(ship1,o.getX(), o.getY()+o.ran, 200, 94, panel);
			break;
    	}
    	int lifePercentage = (int)(160 * 1.0*(o.getHp()*1.00/DataBase.RAZERSHIP_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX()+20, o.getY()+o.ran+5, lifePercentage, 2, false);
		if(lifePercentage!=160){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage+20, o.getY()+o.ran+5, 160-lifePercentage, 2, false);
	    }
    }
    /**
     * draw robot
     */
    private static void drawRobot(Graphics g,RobotWarrior o){
    	switch(o.getKind()){
		case 1:
			Image robot = new ImageIcon("graphics/soldiers/s4/robot.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					robot = new ImageIcon("graphics/soldiers/s4/robot.png").getImage();
				}else{
					robot = new ImageIcon("graphics/soldiers/s4/robot.png").getImage();
				}
				g.drawImage(robot,o.getX(), o.getY()+o.ran, 31, 50, panel);
			}else if(o.attacking){
				if(!DataBase.isPause){
					robot = new ImageIcon("graphics/soldiers/s4/robotattack.gif").getImage();
					g.drawImage(robot,o.getX(), o.getY()+o.ran, 95, 50, panel);
				}else{
					robot = new ImageIcon("graphics/soldiers/s4/robot.png").getImage();
					g.drawImage(robot,o.getX(), o.getY()+o.ran, 31, 50, panel);
				}
			}
			break;
		case 0:
			Image robot1 = new ImageIcon("graphics/soldiers/en4/robot.png").getImage();
			if(o.moving){
				
					robot1 = new ImageIcon("graphics/soldiers/en4/robot.png").getImage();
				
			}else if(o.attacking){
				if(!DataBase.isPause){
					robot1 = new ImageIcon("graphics/soldiers/en4/robot.png").getImage();
				}else{
					robot1 = new ImageIcon("graphics/soldiers/en4/robot.png").getImage();
				}
			}
			g.drawImage(robot1,o.getX(), o.getY()+o.ran, 31, 50, panel);
			break;
    	}
    	int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.ROBOTWARRIOR_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
	    }
    	
    }
    /**
     * draw sneaker
     */
    private static void drawSneaker(Graphics g,Sneaker o){
    	switch(o.getKind()){
		case 1:
			Image sneaker = new ImageIcon("graphics/soldiers/s4/sneaker.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					if(o.invisible){
						sneaker = new ImageIcon("graphics/soldiers/s4/sneakerInvisible.png").getImage();
					}else{
						sneaker = new ImageIcon("graphics/soldiers/s4/sneaker.png").getImage();
					}
				}else{
					sneaker = new ImageIcon("graphics/soldiers/s4/sneaker.png").getImage();
				}
				g.drawImage(sneaker,o.getX(), o.getY()+o.ran, 100, 54, panel);
			}else if(o.attacking){
				if(!DataBase.isPause){
					sneaker = new ImageIcon("graphics/soldiers/s4/sneaker.png").getImage();
					g.drawImage(sneaker,o.getX(), o.getY()+o.ran, 100, 54, panel);
					g.drawImage(new ImageIcon("graphics/soldiers/s4/sneakerattack.gif").getImage(),o.getX()+55, o.getY()+5+o.ran, 48, 42, panel);
				}else{
					sneaker = new ImageIcon("graphics/soldiers/s4/sneaker.png").getImage();
					g.drawImage(sneaker,o.getX(), o.getY()+o.ran, 100, 54, panel);
					
				}
			}
			break;
		case 0:
			Image sneaker1 = new ImageIcon("graphics/soldiers/en4/sneaker.png").getImage();
			if(o.moving){
				
					sneaker1 = new ImageIcon("graphics/soldiers/en4/sneaker.png").getImage();
				
			}else if(o.attacking){
				if(!DataBase.isPause){
					sneaker1 = new ImageIcon("graphics/soldiers/en4/sneaker.png").getImage();
				}else{
					sneaker1 = new ImageIcon("graphics/soldiers/en4/sneaker.png").getImage();
				}
			}
			g.drawImage(sneaker1,o.getX(), o.getY()+o.ran, 100, 54, panel);
			break;
    	}
    	if(!o.invisible){
    		int lifePercentage = (int)(100 * 1.0*(o.getHp()*1.00/DataBase.SNEAKER_HP));
    		g.setColor(Color.GREEN);
    		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
    		if(lifePercentage!=100){
    			g.setColor(Color.RED);
    			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 100-lifePercentage, 3, false);
    	    }
    	}
    }
    /**
     * draw black hole
     */
    private static void drawBlackHole(Graphics g,Object_BlackHole o){
    	Image hole = new ImageIcon("graphics/soldiers/s4/blackhole.png").getImage();
		if(o.moving){
			if(!DataBase.isPause){
				hole = new ImageIcon("graphics/soldiers/s4/blackhole.png").getImage();
			}else{
				hole = new ImageIcon("graphics/soldiers/s4/blackhole.png").getImage();
			}
		}else if(o.attacking){
			if(!DataBase.isPause){
				hole = new ImageIcon("graphics/soldiers/s4/blackhole.png").getImage();
			}else{
				hole = new ImageIcon("graphics/soldiers/s4/blackhole.png").getImage();
			}
		}
		g.drawImage(hole,o.getX(), o.getY()+o.ran, 200, 200, panel);
    }
    /**
	 * draw castle
	 */
	private static void drawCastle(Graphics g,Castle o){
		
		//show life
		if(o.getKind() == 0){
			switch(DataBase.pass){
			case 1: 
				Image ecastle = new ImageIcon("graphics/soldiers/ecastle.png").getImage();
				g.drawImage(ecastle,o.getX()-50, o.getY()-50, 200, 200, panel);
				int lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_ENM_STG1));
				g.setColor(Color.GREEN);
				g.fill3DRect(625, 32, lifePercent, 10, false);
				if(lifePercent!=200){
					g.setColor(Color.RED);
					g.fill3DRect(625+lifePercent, 32, 200-lifePercent, 10, false);			
				}	
			      break;
			case 3:
				Image drop = new ImageIcon("graphics/soldiers/drop.png").getImage();
				g.drawImage(drop,o.getX()+100,o.getY(),180,270,panel);
				int lifePercent3 = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_ENM_STG3));
				g.setColor(Color.GREEN);
				g.fill3DRect(625, 32, lifePercent3, 10, false);
				if(lifePercent3!=200){
					g.setColor(Color.RED);
					g.fill3DRect(625+lifePercent3, 32, 200-lifePercent3, 10, false);			
				}
				break;
			case 4:
				int lifePercent4 = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_ENM_STG4));
				g.setColor(Color.GREEN);
				g.fill3DRect(625, 32, lifePercent4, 10, false);
				if(lifePercent4!=200){
					g.setColor(Color.RED);
					g.fill3DRect(625+lifePercent4, 32, 200-lifePercent4, 10, false);			
				}
				break;
			}
		}else if(o.getKind() == 1){
			int lifePercent = 0;
			switch(DataBase.pass){
			case 1:
				g.drawImage(new ImageIcon("graphics/soldiers/castle.png").getImage(),o.getX()-60, o.getY()-150, 150, 150, panel);
				g.drawImage(new ImageIcon("graphics/soldiers/castle1_2.png").getImage(), 20, 460, 100, 150, panel);
				lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_STG1));
				break;
			case 2:
				g.drawImage(new ImageIcon("graphics/soldiers/castle2.png").getImage(), 10,250 , 106, 147, panel);
				lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_STG2));
				break;
			case 3:
				lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_STG3));
				break;
			case 4:
				lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_STG4));
				break;
			}
			
				g.setColor(Color.GREEN);
				g.fill3DRect(340-lifePercent, 32, lifePercent, 10, false);
				if(lifePercent!=200){
					g.setColor(Color.RED);
					g.fill3DRect(140, 32, 200-lifePercent, 10, false);		
			
				
			}
		}
	}	
	private static void drawSecondCastle(Graphics g,SecondCastle o){
		if(o.getKind() == 1){
			int lifePercent = 0;
			switch(DataBase.pass){
			case 3:
				if(DataBase.Tech_SecondCastle){
					g.drawImage(new ImageIcon("graphics/soldiers/s3/spacestation.png").getImage(),o.getX()-150, o.getY()+200, 300, 200, panel);
					lifePercent = (int)(200*(o.getHp()*1.0/DataBase.SECONDCASTLE_HP));
					g.setColor(Color.GREEN);
					g.fill3DRect(o.getX()-150, o.getY()+180, lifePercent, 3, false);
					if(lifePercent!=200){
						g.setColor(Color.RED);
						g.fill3DRect(o.getX()+lifePercent-150, o.getY()+180, 40-lifePercent, 3, false);
				    }
					//if secondcastle die,its effects will not draw
					if(o.attacking){
						PanelFight.isTech_9=true;
					}else{
						PanelFight.isTech_9=false;
					}
				}
				break;
			   
			
		
		}
	}	
	}	
  
}
