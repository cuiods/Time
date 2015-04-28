package ui;

import gamecontrol.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tools.Money;
import tools.PicturePlayer;
import ui.button.ButtonExit;
import ui.button.ButtonScience;
import ui.button.ButtonUnit;
import units.Cannon;
import units.Castle;
import units.Gunner;
import units.SwordMan;
import units.Unit;
import ai.cleverAI;
import ai.simpleAI;
import dataBase.DataBase;



public class PanelFight extends JPanel implements Runnable{

	private Image fightBackGround = null;
	private Image money = null;
	private ButtonExit butExit = null;
	private ButtonUnit butUnit = null;
	private ButtonScience tech1 = null;
	private ButtonScience tech2 = null;
	private ButtonScience tech3 = null;
	static PanelUnit unitPanel = null;
	static PanelGameOver gameOverPanel = null;
	static boolean panelUnitExist = false;
	public static boolean isTech_3 = false;
	public static ArrayList<Unit> enemy = new ArrayList<Unit>();
	
	public PanelFight(){
		
		
		//set castles
		this.setCastle();
		
		//set buttons
		this.setExitButton();
		this.setUnitButton();
		
		//set science panel
		tech1 = new ButtonScience(1);
		tech1.addMouseListener(tech1);
		tech2 = new ButtonScience(2);
		tech2.addMouseListener(tech2);
		tech3 = new ButtonScience(3);
		tech3.addMouseListener(tech3);
		
		//clear Layout
		this.setLayout(null);
		
		//add components
		this.add(butExit);
		this.add(butUnit);
		this.add(tech1);
		this.add(tech2);
		this.add(tech3);
		
		//create and start AI  @niansong1996
		/*
		 * Test by Anthony
		 */
		simpleAI ai = new simpleAI();
		Thread th = new Thread(ai);
		th.start();
		
		Money mon = new Money();
		Thread monTh = new Thread(mon);
		monTh.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		drawBackground(g);

		drawUnits(g);
		
		drawEffects(g);
	
	}
	
	/**
	 * set the exit button
	 */
	private void setExitButton(){
		butExit = new ButtonExit();
		butExit.type = 1;
		butExit.setBounds(920, 10, 50, 50);
		butExit.addMouseListener(butExit);
	}
	
	/**
	 * set unit button
	 */
	private void setUnitButton(){
		butUnit = new ButtonUnit();
		butUnit.addMouseListener(butUnit);
	}
	
	/**
	 * add a panel showing all the units that can be built
	 */
	public static void addUnitPanel(){
		if(!panelUnitExist){
			//create new unit panel
			unitPanel = new PanelUnit();
			//add unit panel
			Controller.gameframe.fightPanel.add(unitPanel);
			//repaint panel
			Controller.gameframe.fightPanel.repaint();			
			//unit panel has existed, in case add new unit panel
			panelUnitExist = true;
			//add mouseListener
			unitPanel.addMouseListener(unitPanel);
		}
	}
	
	/**
	 * remove unit panel
	 */
	public static void removeUnitPanel(){
		if(panelUnitExist){
			Controller.gameframe.fightPanel.remove(unitPanel);
			Controller.gameframe.fightPanel.repaint();
			panelUnitExist = false;
		}
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
			Image swordman1 = new ImageIcon("graphics/soldiers/s1walk.gif").getImage();
			if(o.moving){
				swordman1 = new ImageIcon("graphics/soldiers/s1walk.gif").getImage();
			}else if(o.attacking){
				swordman1 = new ImageIcon("graphics/soldiers/s1fight.gif").getImage();
			}
			
			g.drawImage(swordman1,o.getX(), o.getY()+o.ran, 50, 80, this);
			break;
		case 0:
			Image swordman0 = new ImageIcon("graphics/soldiers/soldier1.png").getImage();
			g.drawImage(swordman0,o.getX(), o.getY()+o.ran, 50, 80, this);
			break;
		}
		//draw life
		int lifePercentage = (int)(50 * 1.0*(o.getHp()*1.00/DataBase.SWORDMAN_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-20+o.ran, lifePercentage, 5, false);
		if(lifePercentage!=50){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()+o.ran-20, 50-lifePercentage, 5, false);
		}
		
	}
	
	/**
	 * draw gunner
	 */
	private void drawGunner(Graphics g,Gunner o){
		switch(o.getKind()){
		case 1:
			Image gunner1 = new ImageIcon("graphics/soldiers/s3.png").getImage();
			if(o.moving){
				gunner1 = new ImageIcon("graphics/soldiers/s3walk.gif").getImage();
			}else if(o.attacking){
				gunner1 = new ImageIcon("graphics/soldiers/s3fight.gif").getImage();
			}
			g.drawImage(gunner1,o.getX(), o.getY()+o.ran, 50, 80, this);
			break;
		case 0:
			Image gunner0 = new ImageIcon("graphics/soldiers/soldier2.png").getImage();
			g.drawImage(gunner0,o.getX(), o.getY()+o.ran, 50, 80, this);
		}
		//draw life
		int lifePercentage = (int)(50 *1.0* (o.getHp()*1.00/DataBase.GUNNER_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-20+o.ran, lifePercentage, 5, false);
		if(lifePercentage!=50){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()-20+o.ran, 50-lifePercentage, 5, false);
		}
	}
	
	/**
	 * draw cannon
	 */
	private void drawCannon(Graphics g,Cannon o){  	
		switch(o.getKind()){
		case 1:
			Image cannon1 = new ImageIcon("graphics/soldiers/s2.png").getImage();
			if(o.moving){
				cannon1 = new ImageIcon("graphics/soldiers/s2walk.gif").getImage();
			}else if(o.attacking){
				cannon1 = new ImageIcon("graphics/soldiers/s2fight.gif").getImage();
			}
			g.drawImage(cannon1,o.getX(), o.getY()+o.ran, 50, 80, this);
			break;
		case 0:
			Image cannon0 = new ImageIcon("graphics/soldiers/soldier3.png").getImage();
			g.drawImage(cannon0,o.getX(), o.getY()+o.ran, 50, 80, this);
		}
		//draw life
	    int lifePercentage = (int)(50 * 1.0*(o.getHp()*1.0/DataBase.CANNON_HP));
		g.setColor(Color.GREEN);
	    g.fill3DRect(o.getX(), o.getY()-20+o.ran, lifePercentage, 5, false);
		if(lifePercentage!=50){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()-20+o.ran, 50-lifePercentage, 5, false);
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
			g.drawImage(new ImageIcon("graphics/soldiers/castle1_1.png").getImage(), 150, 480, 100, 150, this);
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
		fightBackGround = new ImageIcon("graphics/background/fightbackground1.png").getImage();
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
		enemycastle.setX(DataBase.START_LOC_X_ENM-80);
		enemycastle.setY(DataBase.START_LOC_Y_ENM+50);
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
