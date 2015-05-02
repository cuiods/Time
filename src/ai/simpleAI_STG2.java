package ai;

import units.Unit;
import dataBase.DataBase;

public class simpleAI_STG2 extends AI implements Runnable{
	double AutoAtkRate = 0.7;
	AIcommander AIC = new AIcommander();
	public simpleAI_STG2(){
	}
	@Override
	public void detect() {
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		execute(analyze());
		}
	}

	@Override
	public int analyze() {
		Threat = 0;
		int atk=0;
		for(int i=0;i<DataBase.playerList.size();i++){
			Unit u = DataBase.playerList.get(i); 
			switch(u.getType()){
			case 3: atk=0;Threat+= 30; break;
			case 4: atk=db.SNIPER_ATK; break;
			case 5: atk=0;Threat+=150; break;
			case 6: atk=db.SWORDMAN_ATK;
			case 100:atk=0;
			}
			Threat+=u.getHp()*atk;
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			Unit u = DataBase.enemyList.get(i); 
			switch(u.getType()){
			case 3: atk=0;Threat+= 30; break;
			case 4: atk=db.SNIPER_ATK; break;
			case 5: atk=0;Threat+=150; break;
			case 6: atk=db.SWORDMAN_ATK;
			case 100:atk=0;
			}
			Threat-=u.getHp()*atk*1.2;
		} 
		for(int i=0;i<DataBase.playerList.size();i++){
			Unit u = DataBase.playerList.get(i); 
			int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG2-u.getX())*(db.START_LOC_X_ENM_STG2-u.getX())+
					(db.START_LOC_Y_ENM_STG2-u.getY())*(db.START_LOC_Y_ENM_STG2-u.getY()));
			if (dis <=200) Threat +=100;
			
		}
		System.out.println(Threat);
		return Threat;
	}

	public void execute(int Threat) {
		AutoAtkRate-=0.001;
		if(Threat<0&&Math.random()>AutoAtkRate){
			AIC.addRifle();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addTruck();
		}else if(Threat>0&&Threat<200&&Math.random()>0.4){
			AIC.addRifle();
			AIC.addTruck();
		}else if(Threat>=200&&Threat<340&&Math.random()>0.3){
			AIC.addRifle();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addTruck();
			AIC.addSniper();
		}else if(Threat>=340&&Threat<450&&Math.random()>0.4){
			AIC.addSniper();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addMedicTeam();
		}else if(Threat>=450&&Threat<900){
			AIC.addMedicTeam();
			AIC.addSniper();
			AIC.addTruck();
		}
	}
	@Override
	public void run() {
		AIC.addRifle();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRifle();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRifle();
		if(!DataBase.isPause)
		detect();
		
	}
}
