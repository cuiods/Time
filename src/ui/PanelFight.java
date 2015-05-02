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
	private ButtonExit butExit = null;
	private ButtonGameSet gameSet = null;
	private ButtonPause pause = null;
	private Time time = null;
	static PanelGameOver gameOverPanel = null;
	static boolean panelUnitExist = false;
	public static boolean isTech_3 = false;
	public static boolean isTech_6 = false;
	public static boolean isTech_7 = false;
	public static boolean isTech_8 = false;
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
		ButtonScience tech = null;
		int begin = 1, end = 4;
		switch(DataBase.pass){
		case 1:break;	
		case 2:begin = 4; end = 9; break;
		}
		for(int i = begin; i < end; i++){
			tech = new ButtonScience(i);
			tech.addMouseListener(tech);
			this.add(tech);
		}
	}
	
	/**
	 * set ai according to pass
	 */
	private void setAI(){
		//create and start AI
		switch(DataBase.pass){
		case 1:
			simpleAI_STG1 ai1 = new simpleAI_STG1();
			Thread th1 = new Thread(ai1);
			th1.start();	
			break;
		case 2:
			time = new Time();
			simpleAI_STG2 ai2 = new simpleAI_STG2();
			Thread th2 = new Thread(ai2);
			th2.start();
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
			g.fill3DRect(o.getX(), o.getY()-10-200+o.ran, lifePercentage, 3, false);
			if(lifePercentage!=40){
				g.setColor(Color.RED);		
				g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-10-200, 40-lifePercentage, 3, false);		
			}
			break;
		case 0:
			int lifePercentage0 = (int)(40 * 1.0*(o.getHp()*1.00/DataBase.MEDICTEAM_HP));
			g.setColor(Color.GREEN);
			g.fill3DRect(o.getX(), o.getY()-10+o.ran+200, lifePercentage0, 3, false);
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
			if(!DataBase.isPause){
				if(DataBase.Tech_TruckReinforce){
					truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
				}else{
					truck = new ImageIcon("graphics/soldiers/s2/truck1.png").getImage();
				}
			}else{
				truck = new ImageIcon("graphics/soldiers/s2/truck.png").getImage();
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
			int lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_ENM_STG1));
			g.setColor(Color.GREEN);
			g.fill3DRect(625, 32, lifePercent, 10, false);
			if(lifePercent!=200){
				g.setColor(Color.RED);
				g.fill3DRect(625+lifePercent, 32, 200-lifePercent, 10, false);			
				
			}
		}else if(o.getKind() == 1){
			int lifePercent = 0;
			switch(DataBase.pass){
			case 1:
				g.drawImage(new ImageIcon("graphics/soldiers/castle.png").getImage(),o.getX()-60, o.getY()-150, 150, 150, this);
				g.drawImage(new ImageIcon("graphics/soldiers/castle1_2.png").getImage(), 20, 460, 100, 150, this);
				lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_STG1));
				break;
			case 2:
				g.drawImage(new ImageIcon("graphics/soldiers/castle2.png").getImage(), 10,250 , 106, 147, this);
				lifePercent = (int)(200*(o.getHp()*1.0/DataBase.CASTLE_HP_STG2));
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
		Image money = new ImageIcon("graphics/info/money1.png").getImage();
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
	}
	
	/**
	 * draw special effects
	 * @param graphics g
	 * @see PicturePlayer
	 */
	private void drawEffects(Graphics g){
		/*
		 * draw tech 3 effects
		 */
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
		
		/*
		 * show time left
		 */
		if(time!=null){
			int min = time.getRemainTime()/60;
			int second = time.getRemainTime()%60;
			g.setColor(Color.red);
			Font myFont = new Font("华文隶书",Font.BOLD,28);
			g.setFont(myFont);
			g.drawString(min+"", 680, 80);
			g.drawString(":", 700, 80);
			g.drawString(second+"", 720, 80);			
		}
		
		/*
		 * draw pass2 castle animation
		 */
		if(DataBase.pass == 2){
			String[] pictures2 = {"graphics/stunt/castle2_1.png","graphics/stunt/castle2_2.png","graphics/stunt/castle2_3.png","graphics/stunt/castle2_4.png","graphics/stunt/castle2_5.png","graphics/stunt/castle2_6.png","graphics/stunt/castle2_7.png","graphics/stunt/castle2_8.png","graphics/stunt/castle2_9.png","graphics/stunt/castle2_10.png"};
			PicturePlayer pic2 = new PicturePlayer(pictures2, true, 40);
			pic2.panelPlay(2, 215, g, this, 0);
		}
		
		/*
		 * draw pass2 tech6 effects
		 */
		if(isTech_6){
			String[] pictures3 = {"graphics/stunt/clock1.png","graphics/stunt/clock2.png","graphics/stunt/clock3.png","graphics/stunt/clock4.png","graphics/stunt/clock5.png","graphics/stunt/clock4.png","graphics/stunt/clock3.png","graphics/stunt/clock2.png","graphics/stunt/clock1.png","graphics/stunt/clock3.png"};
			PicturePlayer pic3 = new PicturePlayer(pictures3, false, 30);
			pic3.panelPlay(400, 250, g, this, 1);
			if(PicturePlayer.time1 < 20){
				isTech_6 = false;
				PicturePlayer.time1 = 1000;
			}
		}
		
		/*
		 * draw pass2 tech7 effects
		 */
		if(isTech_7){
			String[] pictures4 = {"graphics/stunt/tech7_1.png","graphics/stunt/tech7_2.png","graphics/stunt/tech7_3.png","graphics/stunt/tech7_4.png","graphics/stunt/tech7_5.png","graphics/stunt/tech7_6.png","graphics/stunt/tech7_7.png","graphics/stunt/tech7_8.png","graphics/stunt/tech7_9.png","graphics/stunt/tech7_10.png"};
			for(int i = 1; i <DataBase.playerList.size(); i ++){
				PicturePlayer pic4 = new PicturePlayer(pictures4, false,30);
				int xchange = 0,ychange = 0;
				switch(DataBase.playerList.get(i).getType()){
				case 6:xchange = -22;ychange = 20;break;
				case 5:ychange = 18;break;
				case 4:xchange = -20;break;
				case 3:xchange = -24;ychange = -200;break;
				}
				pic4.panelPlay(DataBase.playerList.get(i).getX()+xchange, DataBase.playerList.get(i).getY()+DataBase.playerList.get(i).ran+ychange, g, this, 2);
			}
			if(PicturePlayer.time2 < 30){
				isTech_7 = false;
				PicturePlayer.time2 = 1000;
			}
		}
		
		/*
		 * draw pass2 tech8 effects
		 */
		if(isTech_8){
			String pictures5[] = {"graphics/stunt/rcastle1.png","graphics/stunt/rcastle2.png","graphics/stunt/rcastle3.png","graphics/stunt/rcastle4.png","graphics/stunt/rcastle5.png","graphics/stunt/rcastle6.png","graphics/stunt/rcastle7.png","graphics/stunt/rcastle8.png","graphics/stunt/rcastle9.png","graphics/stunt/rcastle10.png"};
			PicturePlayer pic = new PicturePlayer(pictures5, false,30);
			pic.panelPlay(-120, 160, g, this, 3);
			if(PicturePlayer.time3 < 31){
				isTech_8 = false;
				PicturePlayer.time3 = 1000;
			}
		}
		
	}

	/**
	 * add unit castle and set location and start thread
	 * @see Castle
	 */
	private void setCastle(){
		switch(DataBase.pass){
		case 1:
			Castle mycastle = new Castle();
			mycastle.setKind(1);
			
			Thread cp11 = new Thread(mycastle);
			cp11.start();
			DataBase.playerList.add(mycastle);
			
			Castle enemycastle = new Castle();
			enemycastle.setHp(DataBase.CASTLE_HP_ENM_STG1);
			Thread cp21 = new Thread(enemycastle);
			cp21.start();
			enemycastle.setX(DataBase.START_LOC_X_ENM_STG1-80);
			enemycastle.setY(DataBase.START_LOC_Y_ENM_STG1+50);
			DataBase.enemyList.add(enemycastle);
			break;
		case 2:
			Castle mycastle2 = new Castle();
			mycastle2.setKind(1);
			
			Thread cp12 = new Thread(mycastle2);
			cp12.start();
			DataBase.playerList.add(mycastle2);
			break;
		}
	}

	/**
	 * keep refreshing the panel
	 */
	@Override
	public void run() {
		while(true){
			if(win()<0){
				DataBase.isPause = true;
				gameOverPanel = new PanelGameOver(false);
				gameOverPanel.addMouseListener(gameOverPanel);
				this.add(gameOverPanel);
				this.repaint();
				break;
//				Thread gf = new Thread(gameOverPanel);
//				gf.start();
			}
			if(win()>0){
				DataBase.isPause = true;
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
	
	/**
	 * whether win or lose
	 * @return 1 if win; -1 if lose ; 0 neither
	 */
	private int win(){
		switch(DataBase.pass){
		case 1:
			if(DataBase.playerList.size() == 0||((DataBase.playerList.size()>0)&&(DataBase.playerList.get(0).getType()!=100))){
				return -1;
			}
			if(DataBase.enemyList.size() == 0||((DataBase.enemyList.size()>0)&&(DataBase.enemyList.get(0).getType()!=100))){
				return 1;
			}
			break;
		case 2:
			if(DataBase.playerList.size() == 0||((DataBase.playerList.size()>0)&&(DataBase.playerList.get(0).getType()!=100))){
				return -1;
			}
			if(time.getRemainTime()<=0){
				return 1;
			}
			break;
		}
		return 0;
	}
}
