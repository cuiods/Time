package ui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.button.ButtonOK;
import dataBase.DataBase;

public class PanelAim extends JPanel{
	public PanelAim(){
		setLayout(null);
		ButtonOK okButton = new ButtonOK();
		okButton.addMouseListener(okButton);
		okButton.setBounds(380, 340, 150, 60);
		add(okButton);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon("graphics/background/fightbackground"+DataBase.pass+".png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawImage(new ImageIcon("graphics/aim/aim"+DataBase.pass+".png").getImage(), 250,100,420,324,this);
	}
}
