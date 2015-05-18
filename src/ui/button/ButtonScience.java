package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.PanelFight;
import ui.PanelTechInfor;
import Tech.*;
import dataBase.DataBase;

public class ButtonScience extends JPanel implements MouseListener{
	
	protected int kind;
	public boolean isIn = false;
	public PanelTechInfor techInfor;

	/**
	 * different kind represents different science
	 * the kind and the pass determine its location
	 * @param kind
	 */
	public ButtonScience(int kind) {
		this.kind = kind;
		switch(DataBase.pass){
		case 1:this.setBounds(410+(kind-1)*70, 80, 60, 60);break;
		case 2:this.setBounds(410+(kind-4)*70, 80, 60, 60);break;
		case 3:this.setBounds(410+(kind-9)*70, 80, 60, 60);break;
		case 4:this.setBounds(410+(kind-13)*70, 80, 60, 60);break;
		case 5:this.setBounds(410+(kind-16)*70, 80, 60, 60);break;
		case 6:this.setBounds(410+(kind-19)*70, 80, 60, 60);break;
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		//when you name a picture,care for the name, or it can't be shown
		if(!isIn){
			if(DataBase.LockScience){
				g.drawImage(new ImageIcon("graphics/info/tech"+kind+"_2.png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/info/tech"+kind+".png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
			}
		}else{
			if(DataBase.LockScience){
				g.drawImage(new ImageIcon("graphics/info/tech"+kind+"_2.png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/info/tech"+kind+"_1.png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		techInfor = new PanelTechInfor(kind);
		Controller.gameframe.fightPanel.add(techInfor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		this.techInfor.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/*
		 * here you set what will happen when user clicked the button
		 * different tech will have different effect
		 */
		switch(kind){
		case 1:
			if((!DataBase.Tech_CannonEnable)//this means the tech can only be used once
					&&(DataBase.Money-DataBase.Tech_CannonEnable_P>=0)){//this means money is enough
				new Tech_STG1_CannonEnable();
				//remenber money
				DataBase.Money -= DataBase.Tech_CannonEnable_P;
			}
			break;
		case 2:
			if((!DataBase.Tech_MoneyBoom)&&(DataBase.Money-DataBase.Tech_MoneyBoom_P>=0)){
				new Tech_STG1_MoneyBoom();
				DataBase.Money -= DataBase.Tech_MoneyBoom_P;
			}
			break;
		case 3:
			if((DataBase.Money-DataBase.Tech_Destroy_P>=0)){
				//you can ignore something like this, it only used for effects
				PanelFight.enemy.addAll(DataBase.enemyList);
				PanelFight.enemy.remove(0);
				PanelFight.isTech_3 = true;
				
				new Tech_STG1_Destroy();
				DataBase.Money -= DataBase.Tech_Destroy_P;
			}
			break;
		case 4:
			if(!DataBase.Tech_MedicEnable&&(DataBase.Money-DataBase.Tech_MedicEnable_p>=0)){
				new Tech_STG2_MedicEnable();
				DataBase.Money -= DataBase.Tech_MedicEnable_p;
			}
			break;
		case 5:
			if(!DataBase.Tech_TruckReinforce&&(DataBase.Money-DataBase.Tech_TruckReinforce_P>=0)){
				new Tech_STG2_TruckReinforce();
				DataBase.Money -= DataBase.Tech_TruckReinforce_P;
			}
			break;
		case 6:
			if(!DataBase.Tech_LessTime&&(DataBase.Money-DataBase.Tech_LessTime_P>=0)){
				new Tech_STG2_LessTime();
				PanelFight.isTech_6 = true;
				DataBase.Money -= DataBase.Tech_LessTime_P;
			}
			break;
		case 7:
			if((DataBase.Money-DataBase.Tech_Heal_P>=0)){
				new Tech_STG2_Heal();
				PanelFight.isTech_7 = true;
				DataBase.Money -= DataBase.Tech_Heal_P;
			}
			break;
		case 8:
			if(!DataBase.Tech_CastleReinforce&&(DataBase.Money-DataBase.Tech_CastleReinforce_P>=0)){
				new Tech_STG2_CastleReinforce();
				PanelFight.isTech_8 = true;
				DataBase.Money -= DataBase.Tech_CastleReinforce_P;
			}
			break;
		case 9:
			if((DataBase.Money-DataBase.Tech_Harper_P>=0)&&(DataBase.Tech_Harper_TIME<3)&&(!DataBase.LockScience)){
				new Tech_STG3_Hubble();
				//considering the lock science,we shouldn't cut the money while player
				//can't use the tech,so i move the act to tech classes
			}
			break;
		case 10:
			if(!DataBase.Tech_SuperComputer&&(DataBase.Money-DataBase.Tech_SuperComputer_P>=0)&&(!DataBase.LockScience)){
				new Tech_STG3_SuperComputer();
			}
			break;
		case 11:
			if(!DataBase.Tech_SecondCastle&&(DataBase.Money-DataBase.Tech_SecondCastle_P>=0)&&(!DataBase.LockScience)){
				new Tech_STG3_SecondCastle();
			}
			break;
		case 12:
			if(!DataBase.Tech_HydrogenBomb&&(DataBase.Money-DataBase.Tech_HydrogenBomb_P>=0)&&(!DataBase.LockScience)){
				new Tech_STG3_HydrogenBomb();
			}
	
			break;
			/**
			 * WARNING :I don't know the price!!
			 */
		case 15:
			if(!DataBase.Tech_BlackHoleProject&&(DataBase.Money-DataBase.Tech_BlackHoleProject_P>=0)){
				new Tech_STG4_BlackHoleProject();
				DataBase.Money -= DataBase.Tech_BlackHoleProject_P;
			}
			break;
		case 13:
			if(!DataBase.Tech_Faith&&(DataBase.Money-DataBase.Tech_Faith_P>=0)){
				new Tech_STG4_Faith();
				DataBase.Money -= DataBase.Tech_Faith_P;
			}
			break;
		case 14:
			if(!DataBase.Tech_FourthTechRevolution&&(DataBase.Money-DataBase.Tech_FourthTechRevolution_P>=0)){
				new Tech_STG4_FourthTechRevolution();
				DataBase.Money -= DataBase.Tech_FourthTechRevolution_P;
			}
			break;
		case 16:
			if(!DataBase.Tech_CoverProject&&(DataBase.Money-DataBase.Tech_CoverProject_P>=0)){
				new Tech_STG5_CoverProject();
				PanelFight.isTech_9 = true;
				DataBase.Money -= DataBase.Tech_CoverProject_P;
			}
			break;
		case 17:
			if(!DataBase.Tech_Escape&&(DataBase.Money-DataBase.Tech_Escape_P>=0)){
				new Tech_STG5_Escape();
				DataBase.Money -= DataBase.Tech_Escape_P;
			}
			break;
		case 18:
			if((DataBase.Money-DataBase.Tech_HaltScience_P>=0)){
				new Tech_STG5_HaltScience();
				DataBase.Money -= DataBase.Tech_HaltScience_P;
			}
			break;
		case 19:
			if((!DataBase.Tech_QINLIU)&&(DataBase.Money-DataBase.Tech_QINLIU_P>=0)){
				new Tech_STG6_QinLiu();
				DataBase.Money-=DataBase.Tech_QINLIU_P;
			}
			break;
		case 20:
			if((DataBase.Money-DataBase.Tech_REN_P>=0)){
				new Tech_STG6_Ren();
				DataBase.Money-=DataBase.Tech_REN_P;
				PanelFight.isTech_20=true;
			}
			break;
		}
	}

}
