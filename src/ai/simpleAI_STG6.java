package ai;

import units.S_Unit;
import dataBase.DataBase;

public class simpleAI_STG6 implements Runnable{
	AIcommander AIC = new AIcommander();
	@Override
	public void run(){
		while(DataBase.threadContinue){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		switch((int)(Math.random()*7)){
		case 0:AIC.addArtDesigner();break;
		case 1:AIC.addDataMan();break;
		case 2:AIC.addJobHunter();break;
		case 3:AIC.addCaptain();break;
		case 4:
		case 5:
		case 6:break;
		}
		}
	}
}
