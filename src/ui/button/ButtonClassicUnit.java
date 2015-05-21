package ui.button;

import java.awt.Graphics;
import java.net.*;
import java.io.*;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import dataBase.DataBase;

public class ButtonClassicUnit extends ButtonUnit{

	Socket socket ;
	public ButtonClassicUnit(int kind, int path) {
		super(kind,path);
	}
	
	@Override
	public void paintComponent(Graphics g){
		int addNum = 0;
		switch(DataBase.pass){
		case 11:addNum = 2;break;
		case 12:addNum = 7;break;
		case 13:addNum = 11;break;
		}
		
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/info/units/s"+(kind+addNum-10)+"_1.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/info/units/s"+(kind+addNum-10)+"_2.png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		switch(DataBase.pass){
		case 11:
			switch(kind){
			case 11:addMedicTeam();break;
			case 12:addSniper();break;
			case 13:addTruck();break;
			case 14:addRifle();break;
			}break;
		case 12:
			switch(kind){
			case 11:addHydrogenBomb();break;
			case 12:addSpacecarrier();break;
			case 13:addSpaceman();break;
			case 14:addSpaceship();break;
			}break;
		case 13:
			switch(kind){
			case 11:addDrone();break;
			case 12:addRazership();break;
			case 13:addRobotWarrior();break;
			case 14:addSneaker();break;
			}break;
		}
	} 

}
