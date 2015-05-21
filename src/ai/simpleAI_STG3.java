package ai;

import units.S_Unit;
import dataBase.DataBase;

public class simpleAI_STG3 extends AI implements Runnable{

	double AutoAtkRate = 0.9;
	public AIcommander AIC = new AIcommander();
	public simpleAI_STG3(){
	}
	@Override
	public void detect() {
		try {
			Thread.sleep(4000);
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
			S_Unit u = DataBase.playerList.get(i);
			if(u.getType()!=100&&u.getType()!=101){
			Threat+=u.getHp()*u.attack;
			}
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit u = DataBase.enemyList.get(i); 
			if(u.getType()!=100&&u.getType()!=101&&u.getType()!=8){
				Threat-=u.getHp()*u.attack*1.5;
				}
		} 
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit u = DataBase.playerList.get(i); 
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
			AIC.addSpaceMan(0);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			AIC.addSpaceShip(0);
		}else if(Threat>0&&Threat<200&&Math.random()>0.4){
			AIC.addSpaceMan(0);
			AIC.addSpaceShip(0);
		}else if(Threat>=200&&Threat<340&&Math.random()>0.3){
			AIC.addSpaceMan(0);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addSpaceCarrier(0);
			AIC.addSpaceShip(0);
		}else if(Threat>=340&&Threat<450&&Math.random()>0.4&&(DataBase.LockScience==false)){
			AIC.LockScience();
			System.out.println("LockScience");
			AIC.addSpaceShip(0);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addSpaceShip(0);
		}else if(Threat>=450&&(!DataBase.LockScience)){
			AIC.LockScience();
			AIC.addSpaceShip(0);
			AIC.addSpaceCarrier(0);
		}
	}
	@Override
	public void run() {
		AIC.addSpaceMan(0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addSpaceMan(0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addSpaceShip(0);
		while(!DataBase.isPause&&DataBase.pass==3){
			detect();
		}

	}

}
