package ai;

import units.S_Unit;
import dataBase.DataBase;

public class simpleAI_STG2 extends AI implements Runnable{
	double AutoAtkRate = 0.7;
	int Medic_Num = 0;
	int Sniper_Num = 0;
	AIcommander AIC = new AIcommander();
	public simpleAI_STG2(){
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
			case 3: atk=0;Threat+= 30; break;
			case 4: atk=db.SNIPER_ATK; break;
			case 5: atk=0;Threat+=50; break;
			case 6: atk=db.RIFLE_ATK;
			case 100:atk=0;
			}
			Threat+=u.getHp()*atk;
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit u = DataBase.enemyList.get(i); 
			switch(u.getType()){
			case 3: atk=0;Threat-= 30; break;
			case 4: atk=db.SNIPER_ATK; break;
			case 5: atk=0;Threat-=150; break;
			case 6: atk=db.RIFLE_ATK;
			case 100:atk=0;
			}
			Threat-=u.getHp()*atk*1.2;
		} 
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit u = DataBase.playerList.get(i); 
			int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG2-u.getX())*(db.START_LOC_X_ENM_STG2-u.getX())+
					(db.START_LOC_Y_ENM_STG2-u.getY())*(db.START_LOC_Y_ENM_STG2-u.getY()));
			if (dis <=200) Threat +=100;

		}
		System.out.println(Threat);
		return Threat;
	}

	public void execute(int Threat) {
		AutoAtkRate-=0.001;
		if(Threat<=0&&Math.random()>AutoAtkRate){
			AIC.addRifle(0);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addTruck(0);
		}else if(Threat>0&&Threat<200&&Math.random()>0.4){
			AIC.addRifle(0);
			AIC.addTruck(0);
		}else if(Threat>=200&&Threat<340&&Math.random()>0.3){
			AIC.addRifle(0);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addTruck(0);
			if(Sniper_Num<=2){
			AIC.addSniper(0);
			Sniper_Num++;
			}
		}else if(Threat>=340&&Threat<450&&Math.random()>0.4){
			if(Sniper_Num<=2){
			AIC.addSniper(0);
			Sniper_Num++;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(Medic_Num<=1){
			AIC.addMedicTeam(0);
			Medic_Num++;
			}
		}else if(Threat>=450){
			if(Medic_Num<=1){
				AIC.addMedicTeam(0);
				Medic_Num++;
				}
			if(Sniper_Num<=2){
				AIC.addSniper(0);
				Sniper_Num++;
				}

			AIC.addTruck(0);
		}
	}
	@Override
	public void run() {
		AIC.addRifle(0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRifle(0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRifle(0);
		while(!DataBase.isPause&&DataBase.pass==2){
			detect();
		}

	}
}
