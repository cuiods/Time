package ui.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tools.Save;
import ui.PanelFight;
import Tech.Tech1;
import Tech.Tech2;
import Tech.Tech3;
import dataBase.DataBase;

public class ButtonScience extends JPanel implements MouseListener{
	
	private int kind;
	private boolean isIn = false;
	public ButtonScience(int kind) {
		this.kind = kind;
		this.setBounds(410+(kind-1)*70, 80, 60, 60);
	}
	
	@Override
	public void paintComponent(Graphics g){
		switch(DataBase.pass){
		case 1:
			if(!isIn){
				g.drawImage(new ImageIcon("graphics/info/tech"+kind+".png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
			}else{
				g.drawImage(new ImageIcon("graphics/info/tech"+kind+"_"+DataBase.pass+".png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
			}
			break;
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
		switch(DataBase.pass){
		case 1:
			switch(kind){
			case 1:
				if((!DataBase.Tech_1)&&(DataBase.Money-DataBase.Tech_1_P>=0)){
					new Tech1();
					DataBase.Money -= DataBase.Tech_1_P;
				}
				break;
			case 2:
				if((!DataBase.Tech_2)&&(e.getX()>40)&&(DataBase.Money-DataBase.Tech_2_P>=0)){
					new Tech2();
					DataBase.Money -= DataBase.Tech_2_P;
				}
				break;
			case 3:
				if((DataBase.Money-DataBase.Tech_3_p>=0)){
					PanelFight.enemy.addAll(DataBase.enemyList);
					PanelFight.enemy.remove(0);
					PanelFight.isTech_3 = true;
					new Tech3();
					DataBase.Money -= DataBase.Tech_3_p;
				}
				break;
			}
			break;
		}
		
	}

}
