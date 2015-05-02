package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.PanelFight;
import Tech.Tech_CannonEnable_STG1;
import Tech.Tech_CastleReinforce_STG2;
import Tech.Tech_Destroy_STG1;
import Tech.Tech_Heal_STG2;
import Tech.Tech_LessTime_STG2;
import Tech.Tech_MedicEnable_STG2;
import Tech.Tech_MoneyBoom_STG1;
import Tech.Tech_TruckReinforce_STG2;
import dataBase.DataBase;

public class ButtonScience extends JPanel implements MouseListener{
	
	private int kind;
	private boolean isIn = false;
	public ButtonScience(int kind) {
		this.kind = kind;
		switch(DataBase.pass){
		case 1:this.setBounds(410+(kind-1)*70, 80, 60, 60);break;
		case 2:this.setBounds(410+(kind-4)*70, 80, 60, 60);break;
		}
	}
	
	@Override
	public void paintComponent(Graphics g){		
		if(!isIn){
			g.drawImage(new ImageIcon("graphics/info/tech"+kind+".png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
		}else{
			g.drawImage(new ImageIcon("graphics/info/tech"+kind+"_1.png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(kind){
		case 1:
			if((!DataBase.Tech_CannonEnable)&&(DataBase.Money-DataBase.Tech_CannonEnable_P>=0)){
				new Tech_CannonEnable_STG1();
				DataBase.Money -= DataBase.Tech_CannonEnable_P;
			}
			break;
		case 2:
			if((!DataBase.Tech_MoneyBoom)&&(e.getX()>40)&&(DataBase.Money-DataBase.Tech_MoneyBoom_P>=0)){
				new Tech_MoneyBoom_STG1();
				DataBase.Money -= DataBase.Tech_MoneyBoom_P;
			}
			break;
		case 3:
			if((DataBase.Money-DataBase.Tech_Destroy_P>=0)){
				PanelFight.enemy.addAll(DataBase.enemyList);
				PanelFight.enemy.remove(0);
				PanelFight.isTech_3 = true;
				new Tech_Destroy_STG1();
				DataBase.Money -= DataBase.Tech_Destroy_P;
			}
			break;
		case 4:
			if(!DataBase.Tech_MedicEnable&&(DataBase.Money-DataBase.Tech_MedicEnable_p>=0)){
				new Tech_MedicEnable_STG2();
				DataBase.Money -= DataBase.Tech_MedicEnable_p;
			}
			break;
		case 5:
			if(!DataBase.Tech_TruckReinforce&&(DataBase.Money-DataBase.Tech_TruckReinforce_P>=0)){
				new Tech_TruckReinforce_STG2();
				DataBase.Money -= DataBase.Tech_TruckReinforce_P;
			}
			break;
		case 6:
			if(!DataBase.Tech_LessTime&&(DataBase.Money-DataBase.Tech_LessTime_P>=0)){
				new Tech_LessTime_STG2();
				PanelFight.isTech_6 = true;
				DataBase.Money -= DataBase.Tech_LessTime_P;
			}
			break;
		case 7:
			if((DataBase.Money-DataBase.Tech_Heal_P>=0)){
				new Tech_Heal_STG2();
				PanelFight.isTech_7 = true;
				DataBase.Money -= DataBase.Tech_Heal_P;
			}
			break;
		case 8:
			if(!DataBase.Tech_CastleReinforce&&(DataBase.Money-DataBase.Tech_CastleReinforce_P>=0)){
				new Tech_CastleReinforce_STG2();
				PanelFight.isTech_8 = true;
				DataBase.Money -= DataBase.Tech_CastleReinforce_P;
			}
			break;	
		}
	}

}
