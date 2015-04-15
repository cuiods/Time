package ui;

import gamecontrol.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ui.button.ButtonUnit;
import units.*;
import dataBase.DataBase;


public class PanelUnit extends JPanel implements MouseListener{
	
	Image image = new ImageIcon("graphics/soldiers/unit.png").getImage();
	public PanelUnit(){
		this.setBounds(70, 50, 150, 60);
	}

	@Override
	public void paintComponent(Graphics g){
		g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX()<=50){
			this.addSwordman();
		}
		
		ButtonUnit.pressTime = 0;
		ButtonUnit.canRemove = true;
		PanelFight.removeUnitPanel();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	/**
	 * add sword man to enemyList
	 */
	public void addSwordman(){
		SwordMan swordman = new SwordMan();
		DataBase.enemyList.add(swordman);
		
		Thread st = new Thread(swordman);
		st.start();
		
		Controller.gameframe.repaint();
	}
	
}
