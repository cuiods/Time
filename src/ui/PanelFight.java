package ui;

import gamecontrol.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tools.PicturePlayer;
import ui.button.ButtonExit;
import ui.button.ButtonUnit;

import ai.simpleAI;
import dataBase.DataBase;
import ui.button.*;

import units.Cannon;
import units.Gunner;
import units.SwordMan;
import units.Unit;

import tools.Money;



public class PanelFight extends JPanel implements Runnable{

	Image fightBackGround = null;
	Image money = null;
	ButtonExit butExit = null;
	ButtonUnit butUnit = null;
	static PanelUnit unitPanel = null;
	
	static boolean panelUnitExist = false;
	
	public PanelFight(){
		
		//load background image
		fightBackGround = new ImageIcon("graphics/background/fightbackground1.jpg").getImage();
		money = new ImageIcon("graphics/info/money.png").getImage();
		
		//set buttons
		this.setExitButton();
		this.setUnitButton();
		
		//clear Layout
		this.setLayout(null);
		
		//add buttons
		this.add(butExit);
		this.add(butUnit);
		
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
	public void drawUnits(Graphics g){
		/*
		 * draw player units
		 */
		for(Unit o:DataBase.playerList){
			switch(o.getType()){
			case 0:
				drawSwordman(g,(SwordMan)o);
				break;
			case 1:
				drawGunner(g,(Gunner)o);
				break;
			case 2:
				drawCannon(g,(Cannon)o);
				break;
			}
		}
		/*
		 * draw enemy units
		 */
		for(Unit o:DataBase.enemyList){
			switch(o.getType()){
			case 0:
				drawSwordman(g,(SwordMan)o);
				break;
			case 1:
				drawGunner(g,(Gunner)o);
				break;
			case 2:
				drawCannon(g,(Cannon)o);
				break;
			}
		}
	}
	
	/**
	 * draw sword man
	 */
	public void drawSwordman(Graphics g,SwordMan o){
		switch(o.getKind()){
		case 1:
			Image swordman1 = new ImageIcon("graphics/soldiers/s1.png").getImage();
			g.drawImage(swordman1,o.getX(), o.getY(), 50, 80, this);
			break;
		case 0:
			Image swordman0 = new ImageIcon("graphics/soldiers/soldier1.png").getImage();
			g.drawImage(swordman0,o.getX(), o.getY(), 50, 80, this);
			break;
		}
		//draw life
		int lifePercentage = (int)(50 * (o.getHp()/DataBase.SWORDMAN_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-20, lifePercentage, 5, false);
		if(lifePercentage!=50){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()-20, 50-lifePercentage, 5, false);
		}
		
	}
	
	/**
	 * draw gunner
	 */
	public void drawGunner(Graphics g,Gunner o){
		switch(o.getKind()){
		case 1:
			Image gunner1 = new ImageIcon("graphics/soldiers/s3.png").getImage();
			g.drawImage(gunner1,o.getX(), o.getY(), 50, 80, this);
			break;
		case 0:
			Image gunner0 = new ImageIcon("graphics/soldiers/soldier2.png").getImage();
			g.drawImage(gunner0,o.getX(), o.getY(), 50, 80, this);
		}
		//draw life
		int lifePercentage = (int)(50 * (o.getHp()/DataBase.GUNNER_HP));
		g.setColor(Color.GREEN);
		g.fill3DRect(o.getX(), o.getY()-20, lifePercentage, 5, false);
		if(lifePercentage!=50){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()-20, 50-lifePercentage, 5, false);
		}
	}
	
	/**
	 * draw cannon
	 */
	public void drawCannon(Graphics g,Cannon o){
		switch(o.getKind()){
		case 1:
			Image cannon1 = new ImageIcon("graphics/soldiers/s2.png").getImage();
			g.drawImage(cannon1,o.getX(), o.getY(), 50, 80, this);
			break;
		case 0:
			Image cannon0 = new ImageIcon("graphics/soldiers/soldier3.png").getImage();
			g.drawImage(cannon0,o.getX(), o.getY(), 50, 80, this);
		}
		//draw life
	    int lifePercentage = (int)(50 * (o.getHp()/DataBase.CANNON_HP));
		g.setColor(Color.GREEN);
	    g.fill3DRect(o.getX(), o.getY()-20, lifePercentage, 5, false);
		if(lifePercentage!=50){
			g.setColor(Color.RED);
			g.fill3DRect(o.getX()+lifePercentage, o.getY()-20, 50-lifePercentage, 5, false);
		}
	}
	
	/**
	 * draw background
	 */
	public void drawBackground(Graphics g){
		//show background image
		g.drawImage(fightBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
		//show money
		g.drawImage(money, 360, 0, money.getWidth(this), money.getHeight(this), this);
		g.setColor(Color.YELLOW);
		Font myFont = new Font("",Font.BOLD,26);
		g.setFont(myFont);
		g.drawString(DataBase.Money+"", 480, 25);
		/*
		 * µ˜ ‘”√ @Anthony
		 */
//		for(int i=0;i<DataBase.enemyList.size();i++){
//		g.drawString(DataBase.enemyList.get(i).getHp()+"", 900, 20+40*i);
//		}
//		for(int i=0;i<DataBase.playerList.size();i++){
//			g.drawString(DataBase.playerList.get(i).getHp()+"", 900, 400+40*i);
//			}
		
	}

	/**
	 * keep refreshing the panel
	 */
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			this.repaint();
		}
		
	}
}
