package tools;

import ui.PanelFight;
import dataBase.DataBase;

public class Big2Small implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			while(PanelFight.computer_w>=0&&DataBase.threadContinue){
				PanelFight.computer_w-=5;
				PanelFight.computer_h-=3;
				PanelFight.computer_x+=3;
				PanelFight.computer_y+=2;
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	}

}
