package ai;

import units.S_Unit;
import dataBase.DataBase;

public class simpleAI_STG4 extends AI implements Runnable{
	double AutoAtkRate = 0.9;
	public AIcommander AIC = new AIcommander();
	public int SendSoldierNum = 0;
	public simpleAI_STG4(){
		
	}
	@Override
	public void detect() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		execute(analyze(0),0);
		execute(analyze(1),1);
		
	}
	public int analyze(int path_num) {
		Threat = 0;
		for(int i=0;i<DataBase.playerList.size()&&DataBase.playerList.get(i).path==path_num;i++){
			S_Unit u = DataBase.playerList.get(i);
			if(u.getType()!=100&&u.getType()!=102){
				if(path_num==0){
				int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG4-u.getX())*(db.START_LOC_X_ENM_STG4-u.getX())+
						(db.START_LOC_Y_ENM_STG4-u.getY())*(db.START_LOC_Y_ENM_STG4-u.getY()));
				if (dis <=200) Threat +=100;
				}
				if(path_num==1){
					int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG4-u.getX())*(db.START_LOC_X_ENM_STG4-u.getX())+
							(db.START_LOC_Y_ENM_STG4+240-u.getY())*(db.START_LOC_Y_ENM_STG4+240-u.getY()));
					if (dis <=200) Threat +=100;
				}
			Threat+=u.getHp()*u.attack;
			}
		}
		for(int i=0;i<DataBase.enemyList.size()&&DataBase.enemyList.get(i).path==path_num;i++){
			S_Unit u = DataBase.enemyList.get(i); 
			if(u.getType()!=100&&u.getType()!=101&&u.getType()!=8){
				Threat-=u.getHp()*u.attack*1.5;
				}
		} 
//		for(int i=0;i<DataBase.playerList.size()&&DataBase.playerList.get(i).path==path_num;i++){
//			Unit u = DataBase.playerList.get(i); 
//			int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG3-u.getX())*(db.START_LOC_X_ENM_STG3-u.getX())+
//					(db.START_LOC_Y_ENM_STG3-u.getY())*(db.START_LOC_Y_ENM_STG3-u.getY()));
//			if (dis <=200) Threat +=100;
//
//		}
		System.out.println(Threat);
		return Threat;
	}

	public void execute(int Threat,int path_num) {
		AutoAtkRate-=0.001;
		if(Threat<=0&&Math.random()>AutoAtkRate){
			AIC.addDrone(path_num);
			this.SendSoldierNum++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			AIC.addRazerShip(path_num);
			this.SendSoldierNum++;
		}else if(Threat>0&&Threat<200&&Math.random()>0.3){
			AIC.addDrone(path_num);
			this.SendSoldierNum++;
			AIC.addRazerShip(path_num);
			this.SendSoldierNum++;
			AIC.KillerVirus();
			this.SendSoldierNum++;
			this.SendSoldierNum++;
		}else if(Threat>=200&&Threat<340&&Math.random()>0.2){
			AIC.addRobotWarrior(path_num);
			this.SendSoldierNum++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.GeneMissile();
			this.SendSoldierNum++;
			this.SendSoldierNum++;
			this.SendSoldierNum++;
		}else if(Threat>=340&&Threat<450&&Math.random()>0.4&&(DataBase.LockScience==false)){
			AIC.LockScience();
			this.SendSoldierNum++;
			AIC.addRazerShip(path_num);
			this.SendSoldierNum++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.KillerVirus();
			this.SendSoldierNum++;
			this.SendSoldierNum++;
		}else if(Threat>=450){
			AIC.GeneMissile();
			this.SendSoldierNum++;
			this.SendSoldierNum++;
			this.SendSoldierNum++;
			AIC.KillerVirus();
			this.SendSoldierNum++;
			this.SendSoldierNum++;
			AIC.addRobotWarrior(path_num);
			this.SendSoldierNum++;
		}
	}
	public void run() {
//		AIC.LockScience();
		AIC.addDrone(this.getRadomPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRobotWarrior(this.getRadomPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRazerShip(this.getRadomPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addDrone(this.getRadomPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRazerShip(this.getRadomPath());
		while(!DataBase.isPause&&DataBase.pass==4){
			System.out.println("have send"+this.SendSoldierNum);
			if(this.SendSoldierNum==30){
				DataBase.Wave ++;
				DataBase.WaveGap = true;
				this.SendSoldierNum = 0;
				try {
					Thread.sleep(15*1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				DataBase.WaveGap = false;
			}
			detect();
		}

	}
	@Override
	public int analyze() {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public void execute(int Threat) {
		// TODO 自动生成的方法存根
		
	}
	public int getRadomPath(){
		return (int) (Math.random()*2);
	}
}
