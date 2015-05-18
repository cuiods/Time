package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import ui.PanelTechInfor;
import dataBase.DataBase;

public class ButtonClassicScience extends ButtonScience implements Runnable{

	private int type=0;
	public ButtonClassicScience(int kind,int type) {
		super(kind);
		this.type = type;
		this.setBounds(410+(type-1)*70, 80, 60, 60);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
//		techInfor = new PanelTechInfor(kind);
//		Controller.gameframe.fightPanel.add(techInfor);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		//this.techInfor.setVisible(false);
	}

	@Override
	public void run() {
		while(true){
			switch(DataBase.pass){
			case 11:
				switch(type){
				case 1:kind = 4;break;
				case 2:kind = 5;break;
				case 3:kind = 7;break;
				case 4:kind = 8;break;
				}break;
			case 12:
				switch(type){
				case 1:kind = 10;break;
				case 2:kind = 11;break;
				case 3:kind = 12;break;
				case 4:kind = 13;break;
				}break;
			case 13:
				switch(type){
				case 1:kind = 14;break;
				case 2:kind = 15;break;
				case 3:kind = 17;break;
				case 4:kind = 18;break;
				}break;
			}
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
