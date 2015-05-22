package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.net.Socket;

import javax.swing.ImageIcon;

import net.ClientAI;
import net.ServerAI;
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
			case 11:addMedicTeam();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+3);
				}else{
					ClientAI.sendData(1, path+"_"+3);
				}
			}break;
			case 12:addSniper();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+4);
				}else{
					ClientAI.sendData(1, path+"_"+4);
				}
			}break;
			case 13:addTruck();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+5);
				}else{
					ClientAI.sendData(1, path+"_"+5);
				}
			}break;
			case 14:addRifle();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+6);
				}else{
					ClientAI.sendData(1, path+"_"+6);
				}
			}break;
			}break;
		case 12:
			switch(kind){
			case 11:addHydrogenBomb();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+8);
				}else{
					ClientAI.sendData(1, path+"_"+8);
				}
			}break;
			case 12:addSpacecarrier();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+9);
				}else{
					ClientAI.sendData(1, path+"_"+9);
				}
			}break;
			case 13:addSpaceman();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+10);
				}else{
					ClientAI.sendData(1, path+"_"+10);
				}
			}break;
			case 14:addSpaceship();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+11);
				}else{
					ClientAI.sendData(1, path+"_"+11);
				}
			}break;
			}break;
		case 13:
			switch(kind){
			case 11:addDrone();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+12);
				}else{
					ClientAI.sendData(1, path+"_"+12);
				}
			}break;
			case 12:addRazership();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+13);
				}else{
					ClientAI.sendData(1, path+"_"+13);
				}
			}break;
			case 13:addRobotWarrior();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+14);
				}else{
					ClientAI.sendData(1, path+"_"+14);
				}
			}break;
			case 14:addSneaker();
			if(DataBase.isNet){
				if(DataBase.isServer){
					ServerAI.sendData(1, path+"_"+15);
				}else{
					ClientAI.sendData(1, path+"_"+15);
				}
			}break;
			}break;
		}
	} 

}
