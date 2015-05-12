package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import units.Cannon;
import units.Castle;
import units.Gunner;
import units.HydrogenBomb;
import units.MedicTeam;
import units.Rifle;
import units.SecondCastle;
import units.Sniper;
import units.SpaceCarrier;
import units.SpaceMan;
import units.SpaceShip;
import units.SwordMan;
import units.Truck;
import dataBase.DataBase;

public class DrawUnits {
	static JPanel panel;
	static String[] pictures = new String[10];
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
				case 100:
					drawCastle(g, (Castle) DataBase.enemyList.get(i));
					break;
				}
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
	private static void drawHydrogenBomb(Graphics g,HydrogenBomb o){
		switch(o.getKind()){
		case 1:
			Image hbomb = new ImageIcon("graphics/soldiers/s3/HydrogenBomb.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					hbomb = new ImageIcon("graphics/soldiers/s3/HydrogenBomb.png").getImage();
				}else{
					hbomb = new ImageIcon("graphics/soldiers/s3/HydrogenBomb.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					for(int i=1;i<11;i++){
						pictures[i-1]="graphics/stunt/tech3_"+i+".png";
					}
					PicturePlayer player = new PicturePlayer(pictures,false,500);
					player.panelPlay(o.getX()+20, o.getY()+10, g, panel, 0);
					DataBase.playerList.remove(o);
				}else{
					hbomb = new ImageIcon("graphics/soldiers/s3/HydrogenBomb.png").getImage();
				}
			}
			g.drawImage(hbomb,o.getX(), o.getY()+o.ran, 137, 62, panel);
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
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
	    }
	}
    private static void drawSpaceCarrier(Graphics g,SpaceCarrier o){
    	switch(o.getKind()){
		case 1:
			Image carrier = new ImageIcon("graphics/soldiers/s3/carrier.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					carrier = new ImageIcon("graphics/soldiers/s3/carrier.gif").getImage();
				}else{
					carrier = new ImageIcon("graphics/soldiers/s3/carrier.gif").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					carrier = new ImageIcon("graphics/soldiers/s3/carrier.gif").getImage();
				}else{
					carrier = new ImageIcon("graphics/soldiers/s3/carrier.gif").getImage();
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
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
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

					spaceman = new ImageIcon("graphics/soldiers/s3/spaceman1.png").getImage();
				}else{
					spaceman = new ImageIcon("graphics/soldiers/s3/spaceman1.png").getImage();

				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					spaceman = new ImageIcon("graphics/soldiers/s3/spaceman1.png").getImage();
				}else{
					spaceman = new ImageIcon("graphics/soldiers/s3/spaceman1.png").getImage();
				}
			}
			g.drawImage(spaceman,o.getX(), o.getY()+o.ran, 180, 120, panel);
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
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
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
			g.drawImage(spaceship,o.getX(), o.getY()+o.ran, 1020, 709, panel);
			break;
		case 0:
			Image spaceship0 = new ImageIcon("graphics/soldiers/en3/ufo.png").getImage();
			if(o.moving){
				
					spaceship0 = new ImageIcon("graphics/soldiers/en3/soldier4.png").getImage();
				
			}else if(o.attacking){
				if(!DataBase.isPause){
					spaceship0 = new ImageIcon("graphics/soldiers/en3/ufo_attack.png").getImage();
				}else{
					spaceship0 = new ImageIcon("graphics/soldiers/en3/ufo.png").getImage();
				}
			}
			g.drawImage(spaceship0,o.getX(), o.getY()+o.ran, 1020, 709, panel);
			break;
    	}
    	int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.SPACESHIP_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
	    }
    	
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
				g.drawImage(drop,o.getX()-150,o.getY(),180,270,panel);
				int lifePercent3 = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_ENM_STG3));
				g.setColor(Color.GREEN);
				g.fill3DRect(625, 32, lifePercent3, 10, false);
				if(lifePercent3!=200){
					g.setColor(Color.RED);
					g.fill3DRect(625+lifePercent3, 32, 200-lifePercent3, 10, false);			
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
				g.drawImage(new ImageIcon("graphics/soldiers/spacestation.png").getImage(),o.getX(), o.getY()+300, 300, 200, panel);
				lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_STG3));
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
	
	
  
}
