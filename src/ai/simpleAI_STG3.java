package ai;

import units.Unit;
import dataBase.DataBase;

public class simpleAI_STG3 extends AI implements Runnable{

	double AutoAtkRate = 0.9;
	AIcommander AIC = new AIcommander();
	public simpleAI_STG3(){
	}
	@Override
	public void detect() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		execute(analyze());
	}

	@Override
	public int analyze() {
		Threat = 0;
		for(int i=0;i<DataBase.playerList.size();i++){
			Unit u = DataBase.playerList.get(i); 
			Threat+=u.getHp()*u.attack;
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			Unit u = DataBase.enemyList.get(i); 
			Threat-=u.getHp()*u.attack;
		} 
		for(int i=0;i<DataBase.playerList.size();i++){
			Unit u = DataBase.playerList.get(i); 
			int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG3-u.getX())*(db.START_LOC_X_ENM_STG3-u.getX())+
					(db.START_LOC_Y_ENM_STG3-u.getY())*(db.START_LOC_Y_ENM_STG3-u.getY()));
			if (dis <=200) Threat +=100;

		}
		System.out.println(Threat);
		return Threat;
	}

	public void execute(int Threat) {
		AutoAtkRate-=0.001;
		if(Threat<=0&&Math.random()>AutoAtkRate){
			AIC.addSpaceMan();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			AIC.addSpaceShip();
		}else if(Threat>0&&Threat<200&&Math.random()>0.4){
			AIC.addSpaceMan();
			AIC.addSpaceShip();
		}else if(Threat>=200&&Threat<340&&Math.random()>0.3){
			AIC.addSpaceMan();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addSpaceCarrier();
			AIC.addSpaceShip();
		}else if(Threat>=340&&Threat<450&&Math.random()>0.4){
			AIC.LockScience();
			System.out.println("LockScience");
			AIC.addSpaceShip();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addSpaceShip();
		}else if(Threat>=450){
			AIC.LockScience();
			AIC.addSpaceShip();
			AIC.addSpaceCarrier();
		}
	}
	@Override
	public void run() {
		AIC.addSpaceMan();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addSpaceMan();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addSpaceShip();
		while(!DataBase.isPause&&DataBase.pass==3){
			detect();
		}

	}

}
