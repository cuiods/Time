package ui;

import java.awt.Graphics;

import javax.swing.*;

import dataBase.DataBase;

public class PanelTechInfor extends JPanel {
   private int kind;
   public PanelTechInfor(int kind){
	   this.kind=kind;
	   switch(DataBase.pass){
		case 1:this.setBounds(410+(kind-1)*49, 130, 293, 226);break;
			
		case 2:this.setBounds(410+(kind-4)*49, 130, 293, 226);break;
		
		case 3:this.setBounds(410+(kind-9)*49, 130, 293, 226);break;
			
		}
   }
   public void paintComponent(Graphics g){
	  g.drawImage(new ImageIcon("graphics/info/techInfor"+kind+".png").getImage(), 0,0,this.getWidth(), this.getHeight(),this);
   }
}
