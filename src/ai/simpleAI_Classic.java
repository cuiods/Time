package ai;

import units.S_Unit;
import dataBase.DataBase;

public class simpleAI_Classic extends AI implements Runnable{
	public int Threat = 0;
	public int Pass = 11;
	public int Money = 0;
	AIMoney m;
	AIcommander AIC;
	public simpleAI_Classic(){
		AIC = new AIcommander();
		this.Pass = AIMoney.AIPass;
		this.Money = AIMoney.Money;
		m = new AIMoney();
		Thread th = new Thread(m);
		th.start();
	}
	@Override
	public void detect() {
		this.Pass = AIMoney.AIPass;
		this.Money = AIMoney.Money;
		System.out.println(this.Pass);
		System.out.println(this.Money);
		System.out.println(AIMoney.Money_Increment);
		execute(analyzeThreat(0),analyzeThreat(1),analyzeThreat(2),analyzeDevelop(),
				analyzeAttackPotential(analyzeThreat(0),analyzeThreat(1),analyzeThreat(2)));

	}

	private void execute(int ThreatResult0, int ThreatResult1, int ThreatResult2,
			int DevelopResult, int AttackPotentialResult ) {
		System.out.printf("\nThreats are : %d %d %d \n",ThreatResult0,ThreatResult1,ThreatResult2);
	}
	//analyze the Threat to our site
	private int analyzeThreat(int path_num) {
		int result = 0;
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getType()!=101){
				if(ce.path==path_num)
					result+=ce.attack*ce.getHp();
			}
			else{
				result+=60;
			}
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit ce = DataBase.enemyList.get(i);
			if(ce.path==path_num)
				result-=ce.attack*ce.getHp();
		}
		return balanceByLevel(result);
	}
	private int analyzeAttackPotential(int ThreatResult0,int ThreatResult1,int ThreatResult2){
		int weakThreat = Math.min(Math.min(ThreatResult0, ThreatResult1), ThreatResult2);

		return 0;
	}
	private int analyzeDevelop(){

		return 0;
	}
	private int balanceByLevel(int prudentData){
		int result = (int) (prudentData/(Math.pow(2.25, this.Pass-11)));
		return (int) (result/(Math.pow(2.25, this.Pass-DataBase.pass)));
	}
	private int getFullCastleHP(int Kind){
		if(Kind==0){
			switch(Pass){
			case 11: return DataBase.CASTLE_HP_CLASSIC_LV1;
			case 12: return DataBase.CASTLE_HP_CLASSIC_LV2;
			case 13: return DataBase.CASTLE_HP_CLASSIC_LV3;
			default:return -1;
			}
		}
		else{
			switch(DataBase.pass){
			case 11: return DataBase.CASTLE_HP_CLASSIC_LV1;
			case 12: return DataBase.CASTLE_HP_CLASSIC_LV2;
			case 13: return DataBase.CASTLE_HP_CLASSIC_LV3;
			default:return -1;
			}
		}
	}
	public void CheckAndAdd(AIAction action,int path_num){
		switch(action){
		case MedicTeam: if(this.Money>=DataBase.MEDICTEAM_P){
			AIC.addMedicTeam(path_num);
		}break;
		case Sniper: if(this.Money>=DataBase.SNIPER_P){
			AIC.addSniper(path_num);
		}break;
		case Truck: if(this.Money>=DataBase.TRUCK_P){
			AIC.addTruck(path_num);
		}break;
		case Rifle: if(this.Money>=DataBase.RIFLE_P){
			AIC.addRifle(path_num);
		}break;
		case SpaceCarrier: if(this.Money>=DataBase.SPACECARRIER_P&&this.Pass==12){
			AIC.addSpaceCarrier(path_num);
		}break;
		case SpaceMan: if(this.Money>=DataBase.SPACEMAN_P&&this.Pass==12){
			AIC.addSpaceMan(path_num);
		}break;
		case SpaceShip: if(this.Money>=DataBase.SPACESHIP_P&&this.Pass==12){
			AIC.addSpaceShip(path_num);
		}break;
		case Drone: if(this.Money>=DataBase.DRONE_P&&this.Pass==13){
			AIC.addDrone(path_num);
		}break;
		case RazerShip: if(this.Money>=DataBase.RAZERSHIP_P&&this.Pass==13){
			AIC.addRazerShip(path_num);
		}break;
		case RobotWarrior: if(this.Money>=DataBase.ROBOTWARRIOR_P&&this.Pass==13){
			AIC.addRobotWarrior(path_num);
		}break;
		case Sneaker: if(this.Money>=DataBase.SNEAKER_P&&this.Pass==13){
			AIC.addSneaker(path_num);
		}break;
		case LockScience: if(this.Money>=DataBase.TECH_LOCKSCIENCE_P&&this.Pass==12){
			AIC.LockScience();
		}break;
		case GeneMissile: if(this.Money>=DataBase.TECH_GENEMISSILE_P&&this.Pass==13){
			AIC.GeneMissile();
		}break;
		case KillerVirus: if(this.Money>=DataBase.TECH_KILLERVIRUS_P&&this.Pass==13){
			AIC.KillerVirus();
		}break;
		case PhotonStrike: if(this.Money>=DataBase.TECH_PHOTONSTRIKE_P&&this.Pass==13){
			AIC.PhotonStrike();
		}break;
		}
	}
	@Override
	public void run() {
		while(DataBase.threadContinue){
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

}
