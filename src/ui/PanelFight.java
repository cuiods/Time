package ui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import tools.*;
import ui.button.*;
import units.*;
import ai.*;
import dataBase.DataBase;



public class PanelFight extends JPanel implements Runnable{

	private Image fightBackGround = null;
	private Image money = null;
	private ButtonExit butExit = null;
	private ButtonScience tech1 = null;
	private ButtonScience tech2 = null;
	private ButtonScience tech3 = null;
	private ButtonGameSet gameSet = null;
	private ButtonPause pause = null;
	static PanelGameOver gameOverPanel = null;
	static boolean panelUnitExist = false;
	public static boolean isTech_3 = false;
	public static ArrayList<Unit> enemy = new ArrayList<Unit>();
	
	public PanelFight(){
		
		
		//set castles
		setCastle();
		
		//set buttons
		setButtons();
		
		//clear Layout
		setLayout(null);
		
		//set AI
		setAI();
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		drawBackground(g);

		drawUnits(g);
		
		drawEffects(g);
	
	}
	
	
	/**
	 * set technology according to pass
	 */
	private void setTech(){
		switch(DataBase.pass){
		case 1:
			tech1 = new ButtonScience(1);
			tech1.addMouseListener(tech1);
			tech2 = new ButtonScience(2);
			tech2.addMouseListener(tech2);
			tech3 = new ButtonScience(3);
			tech3.addMouseListener(tech3);
			this.add(tech1);
			this.add(tech2);
			this.add(tech3);
			break;
		}
	}
	
	/**
	 * set ai according to pass
	 */
	private void setAI(){
		//create and start AI
		switch(DataBase.pass){
		case 1:
			simpleAI ai = new simpleAI();
			Thread th = new Thread(ai);
			th.start();	
			break;
		case 2:
			//@niansong
			break;
		}
		
		//set money
		Money mon = new Money();
		Thread monTh = new Thread(mon);
		monTh.start();
	}
	
	/**
	 * set all the buttons in the fight panel
	 */
	private void setButtons(){
		//set science panel
		setTech();
		
		gameSet = new ButtonGameSet();
		gameSet.addMouseListener(gameSet);
		pause = new ButtonPause();
		pause.addMouseListener(pause);
		
		butExit = new ButtonExit();
		butExit.type = 1;
		butExit.setBounds(960, 10, 30, 30);
		butExit.addMouseListener(butExit);
		
		ButtonUnit butUnit = null;
		switch(DataBase.pass){
		case 1:
			for(int i = 0; i < 3;i++){
				butUnit = new ButtonUnit(i);
				butUnit.setBounds(30+i*70, 80, 65, 60);
				butUnit.addMouseListener(butUnit);
				this.add(butUnit);
			}
			break;
		case 2:
			for(int i = 0; i < 4;i++){
				butUnit = new ButtonUnit(i+3);
				butUnit.setBounds(30+i*70, 80, 65, 60);
				butUnit.addMouseListener(butUnit);
				this.add(butUnit);
			}
			break;
		}
		
		this.add(butExit);
		this.add(gameSet);
		this.add(pause);
		
	}
	
	
	/**
	 * draw solders, and so on 
	 */
	private void drawUnits(Graphics g){
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
	private void drawSwordman(Graphics g,SwordMan o){
		switch(o.getKind()){
		case 1:
			Image swordman1 = null;	
			if(o.moving){
				if(!DataBase.isPause){
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
			g.drawImage(swordman1,o.getX(), o.getY()+o.ran, 40, 62, this);
			break;
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
			g.drawImage(swordman0,o.getX(), o.getY()+o.ran, 40, 62, this);
			break;
		}
		//draw life
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
	private void drawGunner(Graphics g,Gunner o){
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
			g.drawImage(gunner1,o.getX(), o.getY()+o.ran, 40, 81, this);
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
			g.drawImage(gunner0,o.getX(), o.getY()+o.ran, 40, 81, this);
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
	private void drawCannon(Graphics g,Cannon o){  	
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
			g.drawImage(cannon1,o.getX(), o.getY()+o.ran, 40, 64, this);
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
			g.drawImage(cannon0,o.getX(), o.getY()+o.ran, 40, 64, this);
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
	private void drawMedicTeam(Graphics g,MedicTeam o){
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
			g.drawImage(medic,o.getX(), o.getY()+o.ran-200, 50,50, this);
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
			g.drawImage(medic0,o.getX(), o.getY()+o.ran+200,50, 50, this);
		}
		
		//draw life
		switch(o.getKind()){
		case 1:
			int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.MEDICTEAM_HP));
			g.setColor(Color.GREEN);
			g.fill3DRect(o.getX(), o.getY()-10-150+o.ran, lifePercentage, 3, false);
			if(lifePercentage!=40){
				g.setColor(Color.RED);		
				g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10-200, 40-lifePercentage, 3, false);		
			}
			break;
		case 0:
			int lifePercentage0 = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.MEDICTEAM_HP));
			g.setColor(Color.GREEN);
			g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage0, 3, false);
			if(lifePercentage0!=40){
				g.setColor(Color.RED);		
				g.fill3DRect(o.getX()+lifePercentage0, o.getY()+o.ran-10+200, 40-lifePercentage0, 3, false);		
			}
		}
	}
	
	/**
	 * draw snooper
	 */
	private void drawSniper(Graphics g,Sniper o){
		switch(o.getKind()){
		case 1:
			Image sniper = new ImageIcon("graphics/soldiers/s2/sniper.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					sniper = new ImageIcon("graphics/soldiers/s2/sniper.png").getImage();
				}else{
					sniper = new ImageIcon("graphics/soldiers/s2/sniper.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					sniper = new ImageIcon("graphics/soldiers/s2/sniper.png").getImage();
				}else{
					sniper = new ImageIcon("graphics/soldiers/s2/sniper.png").getImage();
				}
			}
			g.drawImage(sniper,o.getX(), o.getY()+o.ran, 50, 50, this);
			break;
		case 0:
			Image sniper0 = new ImageIcon("graphics/soldiers/en2/sniper0.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					sniper0 = new ImageIcon("graphics/soldiers/en2/sniper0.png").getImage();
				}else{
					sniper0 = new ImageIcon("graphics/soldiers/en2/sniper0.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					sniper0 = new ImageIcon("graphics/soldiers/en2/sniper0.png").getImage();
				}else{
					sniper0 = new ImageIcon("graphics/soldiers/en2/sniper0.png").getImage();
				}
			}
			g.drawImage(sniper0,o.getX(), o.getY()+o.ran, 50, 50, this);
			break;
			
		}
		
		//draw life
		int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.SNIPER_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
		}
	}
	
	/**
	 * draw truck
	 */
	private void drawTruck(Graphics g, Truck o){
		switch(o.getKind()){
		case 1:
			Image truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
				}else{
					truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
				}else{
					truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
				}
			}
			g.drawImage(truck,o.getX(), o.getY()+o.ran, 96, 78, this);
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
			g.drawImage(truck0,o.getX(), o.getY()+o.ran, 96, 78, this);
			break;
			
		}
		
		//draw life 
		int lifePercentage = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.TRUCK_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-10+o.ran, lifePercentage, 3, false);
		if(lifePercentage!=40){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10, 40-lifePercentage, 3, false);
		}
	}
	
	/**
	 * draw rifle soldier
	 */
	private void drawRifle(Graphics g,Rifle o){
		switch(o.getKind()){
		case 1:
			Image rifle = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					rifle = new ImageIcon("graphics/soldiers/s2/s4walk1.gif").getImage();
				}else{
					rifle = new ImageIcon("graphics/soldiers/s2/s4walk1.gif").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					rifle = new ImageIcon("graphics/soldiers/s2/s4walk1.gif").getImage();
				}else{
					rifle = new ImageIcon("graphics/soldiers/s2/s4walk1.gif").getImage();
				}
			}
			g.drawImage(rifle,o.getX(), o.getY()+o.ran, 48, 83, this);
			break;
		case 0:
			Image rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4.png").getImage();
			if(o.moving){
				if(!DataBase.isPause){
					rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4.png").getImage();
				}else{
					rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4.png").getImage();
				}
			}else if(o.attacking){
				if(!DataBase.isPause){
					rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4.png").getImage();
				}else{
					rifle0 = new ImageIcon("graphics/soldiers/en2/soldier4.png").getImage();
				}
			}
			g.drawImage(rifle0,o.getX(), o.getY()+o.ran, 48, 83, this);
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
	
	/**
	 * draw castle
	 */
	private void drawCastle(Graphics g,Castle o){
		
		//show life
		if(o.getKind() == 0){
			Image ecastle = new ImageIcon("graphics/soldiers/ecastle.png").getImage();
			g.drawImage(ecastle,o.getX()-50, o.getY()-50, 200, 200, this);
			int lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_ENM));
			g.setColor(Color.GREEN);
			g.fill3DRect(625, 32, lifePercent, 10, false);
			if(lifePercent!=200){
				g.setColor(Color.RED);
				g.fill3DRect(625+lifePercent, 32, 200-lifePercent, 10, false);			
				
			}
		}else if(o.getKind() == 1){
			Image castle = new ImageIcon("graphics/soldiers/castle.png").getImage();
			g.drawImage(castle,o.getX()-60, o.getY()-150, 150, 150, this);
			g.drawImage(new ImageIcon("graphics/soldiers/castle1_2.png").getImage(), 20, 460, 100, 150, this);
			//g.drawImage(new ImageIcon("graphics/soldiers/castle1_1.png").getImage(), 150, 480, 100, 150, this);
			int lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_STG1));
			g.setColor(Color.GREEN);
			g.fill3DRect(340-lifePercent, 32, lifePercent, 10, false);
			if(lifePercent!=200){
				g.setColor(Color.RED);
				g.fill3DRect(140, 32, 200-lifePercent, 10, false);			
				
			}
		}
	}
	
	/**
	 * draw background
	 */
	private void drawBackground(Graphics g){
		//load background image
		switch(DataBase.pass){
		case 1:
			fightBackGround = new ImageIcon("graphics/background/fightbackground1.png").getImage();
			break;
		case 2:
			fightBackGround = new ImageIcon("graphics/background/fightbackground2.png").getImage();
			break;
		}
		money = new ImageIcon("graphics/info/money1.png").getImage();
		Image tech = new ImageIcon("graphics/info/tech.png").getImage();
		//show background image
		g.drawImage(fightBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
		g.drawImage(new ImageIcon("graphics/info/life.png").getImage(), 120, 15, 240, 45, this);
		g.drawImage(new ImageIcon("graphics/info/life.png").getImage(), 605, 15, 240, 45, this);
		g.drawImage(tech, 330, 95, 60, 30, this);

		//show money
		g.drawImage(money, 355, 0,260, 80, this);
		g.setColor(Color.YELLOW);
		Font myFont = new Font("华文隶书",Font.BOLD,24);
		g.setFont(myFont);
		g.drawString(DataBase.Money+"", 450, 65);
		/*
		 * 调试用 @Anthony
		 */
//		for(int i=0;i<DataBase.enemyList.size();i++){
//		g.drawString(DataBase.enemyList.get(i).getHp()+"", 900, 20+40*i);
//		}
//		for(int i=0;i<DataBase.playerList.size();i++){
//			g.drawString(DataBase.playerList.get(i).getHp()+"", 900, 400+40*i);
//			}
		
	}
	
	private void drawEffects(Graphics g){
		if(isTech_3){
			String[] pictures = {"graphics/stunt/tech3_1.png","graphics/stunt/tech3_2.png","graphics/stunt/tech3_3.png","graphics/stunt/tech3_4.png","graphics/stunt/tech3_5.png","graphics/stunt/tech3_6.png","graphics/stunt/tech3_7.png","graphics/stunt/tech3_8.png","graphics/stunt/tech3_9.png","graphics/stunt/tech3_10.png"};
			for(int i = 0; i <enemy.size();i++){
				if(PicturePlayer.time0>=30){
					PicturePlayer pic1 = new PicturePlayer(pictures, false, 30);
					pic1.panelPlay(enemy.get(i).getX()-15, enemy.get(i).getY(), g, this,0);
				}else{
					isTech_3 = false;
					PicturePlayer.time0 = 1000;
					enemy.removeAll(enemy);
				}
			}
		}
	}

	private void setCastle(){
		Castle mycastle = new Castle();
		mycastle.setKind(1);
		
		Thread cp1 = new Thread(mycastle);
		cp1.start();
		DataBase.playerList.add(mycastle);
		
		Castle enemycastle = new Castle();
		enemycastle.setHp(DataBase.CASTLE_HP_ENM);
		Thread cp2 = new Thread(enemycastle);
		cp2.start();
		enemycastle.setX(DataBase.START_LOC_X_ENM_STG1-80);
		enemycastle.setY(DataBase.START_LOC_Y_ENM_STG1+50);
		DataBase.enemyList.add(enemycastle);
	}

	/**
	 * keep refreshing the panel
	 */
	@Override
	public void run() {
		while(true){
			if(DataBase.playerList.size() == 0||((DataBase.playerList.size()>0)&&(DataBase.playerList.get(0).getType()!=100))){
				gameOverPanel = new PanelGameOver(false);
				gameOverPanel.addMouseListener(gameOverPanel);
				this.add(gameOverPanel);
				this.repaint();
				break;
//				Thread gf = new Thread(gameOverPanel);
//				gf.start();
			}
			if(DataBase.enemyList.size() == 0||((DataBase.enemyList.size()>0)&&(DataBase.enemyList.get(0).getType()!=100))){
				gameOverPanel = new PanelGameOver(true);
				gameOverPanel.addMouseListener(gameOverPanel);
				this.add(gameOverPanel);
				this.repaint();
				break;
			}
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			this.repaint();
		}
		
	}
}
