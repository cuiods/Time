package ui;

import gamecontrol.Controller;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dataBase.DataBase;
import ui.button.*;
import units.SwordMan;
import units.Unit;


public class PanelFight extends JPanel implements Runnable{

	Image fightBackGround = null;
	ButtonExit butExit = null;
	ButtonUnit butUnit = null;
	static PanelUnit unitPanel = null;
	
	static boolean panelUnitExist = false;
	
	public PanelFight(){
		
		//load background image
		fightBackGround = new ImageIcon("graphics/background/fightbackground1.jpg").getImage();
		
		//set buttons
		this.setExitButton();
		this.setUnitButton();
		
		//clear Layout
		this.setLayout(null);
		
		//add buttons
		this.add(butExit);
		this.add(butUnit);

	}
	
	@Override
	public void paintComponent(Graphics g){
		
		//draw background
		g.drawImage(fightBackGround, 0, 0,this.getWidth(),this.getHeight(), this);
		
		/*
		 * draw units
		 */
		this.drawUnits(g);
		
	}
	
	/**
	 * set the exit button
	 */
	private void setExitButton(){
		butExit = new ButtonExit();
		butExit.setIcon(new ImageIcon("graphics/button/close.png"));
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
		for(Unit o:DataBase.enemyList){
			switch(o.getType()){
			case 0:
				drawSwordman(g,(SwordMan)o);
				break;
			}
		}
	}
	
	/**
	 * draw sword man
	 */
	public void drawSwordman(Graphics g,SwordMan o){
		Image swordman = new ImageIcon("graphics/soldiers/s1.png").getImage();
		g.drawImage(swordman,o.getX(), o.getY(), 50, 80, this);
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
