package ai;

import dataBase.DataBase;
import units.S_Unit;

public class simpleAI_STG1 extends AI implements Runnable{
	double AutoAtkRate = 0.9;
	AIcommander AIC = new AIcommander();
	public simpleAI_STG1(){
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
		int atk=0;
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit u = DataBase.playerList.get(i); 
			switch(u.getType()){
			case 0: atk=db.SWORDMAN_ATK; break;
			case 1: atk=db.GUNNER_ATK; break;
			case 2: atk=db.CANNON_ATK; break;
			case 100:atk=0;
			}
			Threat+=u.getHp()*atk;
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit u = DataBase.enemyList.get(i); 
			switch(u.getType()){
			case 0: atk=db.SWORDMAN_ATK; break;
			case 1: atk=db.GUNNER_ATK; break;
			case 2: atk=db.CANNON_ATK; break;
			case 100:atk=0;
			}
			Threat-=u.getHp()*atk*1.1;
		} 
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit u = DataBase.playerList.get(i); 
			int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG1-u.getX())*(db.START_LOC_X_ENM_STG1-u.getX())+
					(db.START_LOC_Y_ENM_STG1-u.getY())*(db.START_LOC_Y_ENM_STG1-u.getY()));
			if (dis <=200) Threat +=100;

		}
		return Threat;
	}

	public void execute(int Threat) {
		AutoAtkRate-=0.001;
		if(Threat>-30&&Threat<0&&Math.random()>0.9){
			AIC.addSwordMan();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addSwordMan();
		}else if(Threat>0&&Threat<200&&Math.random()>0.4){
			AIC.addSwordMan();
		}else if(Threat>=200&&Threat<340&&Math.random()>0.3){
			AIC.addSwordMan();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addSwordMan();
		}else if(Threat>=340&&Threat<450&&Math.random()>0.4){
			AIC.addGunner();
		}else if(Threat>=450&&Threat<900){
			AIC.addCannon();
		}
	}
	@Override
	public void run() {
		AIC.addSwordMan();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addSwordMan();
		while(!DataBase.isPause&&DataBase.pass==1){
			detect();
		}

	}

}
