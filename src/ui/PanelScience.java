package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dataBase.DataBase;
import units.Unit;
import Tech.Tech1;
import Tech.Tech2;
import Tech.Tech3;

public class PanelScience extends JPanel implements MouseListener{
	
	Image image1 = new ImageIcon("graphics/info/tech1.png").getImage();
	Image image2 = new ImageIcon("graphics/info/tech2.png").getImage();
	Image image3 = new ImageIcon("graphics/info/tech3.png").getImage();
	public PanelScience() {
		this.setBounds(430,90, 180, 50);
	}

	@Override
	public void paintComponent(Graphics g){
		g.drawImage(image1,0,0,50,50,this);
		g.drawImage(image2,60,0,50,50,this);
		g.drawImage(image3,120,0,50,50,this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX()<=50&&(!DataBase.Tech_1)&&(DataBase.Money-DataBase.Tech_1_P>=0)){
			new Tech1();
			DataBase.Money -= DataBase.Tech_1_P;
		}else if(e.getX()>=60&&e.getX()<=110&&(!DataBase.Tech_2)&&(e.getX()>40)&&(DataBase.Money-DataBase.Tech_2_P>=0)){
			new Tech2();
			DataBase.Money -= DataBase.Tech_2_P;
		}else if(e.getX()>=120&&e.getX()<=170&&(e.getX()>80)&&(DataBase.Money-DataBase.Tech_3_p>=0)){
			PanelFight.enemy.addAll(DataBase.enemyList);
			PanelFight.enemy.remove(0);
			PanelFight.isTech_3 = true;
			new Tech3();
			DataBase.Money -= DataBase.Tech_3_p;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
