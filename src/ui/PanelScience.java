package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dataBase.DataBase;
import Tech.Tech1;
import Tech.Tech2;
import Tech.Tech3;

public class PanelScience extends JPanel implements MouseListener{
	
	Image image = new ImageIcon("graphics/info/tech.png").getImage();
	public PanelScience() {
		this.setBounds(20,0, 120, 40);
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
		if(e.getX()<=40&&(!DataBase.Tech_1)){
			new Tech1();
			DataBase.Money -= DataBase.Tech_1_P;
		}else if(e.getX()<=80&&(!DataBase.Tech_2)){
			new Tech2();
			DataBase.Money -= DataBase.Tech_2_P;
		}else if(e.getX()<=120){
			new Tech3();
			DataBase.Money -= DataBase.Tech_3_p;
		}
		
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
		// TODO Auto-generated method stub
		
	}

}
