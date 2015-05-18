package tools;

import dataBase.DataBase;

public class ChangeShadow implements Runnable {

	@Override
	public void run() {
		if(DataBase.Tech_Harper_TIME==1){
			while(DrawUnits.shadow_x<=200&&DataBase.threadContinue){
				DrawUnits.shadow_x+=5;
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(DataBase.Tech_Harper_TIME==2){
			while(DrawUnits.shadow_x<=900&&DataBase.threadContinue){
				DrawUnits.shadow_x+=5;
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
	}

}
