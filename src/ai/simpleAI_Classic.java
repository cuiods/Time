package ai;

import units.S_Unit;
import dataBase.DataBase;

public class simpleAI_Classic extends AI implements Runnable{
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
		// System.out.println(this.Pass);
		// System.out.println(DataBase.pass);
		// System.out.println(this.Money);
		// System.out.println(AIMoney.Money_Increment);
		execute(analyzeThreat(0),analyzeThreat(1),analyzeThreat(2),analyzeDevelop(),
				analyzeAttackRisk(analyzeThreat(0),analyzeThreat(1),analyzeThreat(2)));

	}

	private void execute(int ThreatResult0, int ThreatResult1, int ThreatResult2,
			int DevelopResult, int AttackRiskResult ) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// System.out.printf("\nThreats are : %d %d %d \n",
//		ThreatResult0,ThreatResult1,ThreatResult2);
		// System.out.println(this.getCastlePercentage(1));
		if(AIMoney.Money>18000&&this.Pass==11){
			AIC.NextAge();
		}
		if(AIMoney.Money>35000&&this.Pass==12){
			AIC.NextAge();
		}
		if(ThreatResult0+ThreatResult1+ThreatResult2>=2300
				&&ThreatResult0+ThreatResult1+ThreatResult2<3000){
			this.CheckAndAdd(AIAction.KillerVirus, 0);
		}else{
			if(ThreatResult0+ThreatResult1+ThreatResult2>=3000
					&&ThreatResult0+ThreatResult1+ThreatResult2<4000){
				this.CheckAndAdd(AIAction.KillerVirus, 0);
				this.CheckAndAdd(AIAction.KillerVirus, 0);
			}else{
				if(ThreatResult0+ThreatResult1+ThreatResult2>=4000
						&&ThreatResult0+ThreatResult1+ThreatResult2<5000){
					this.CheckAndAdd(AIAction.KillerVirus, 0);
					this.CheckAndAdd(AIAction.GeneMissile, 0);
				}else{
					if(ThreatResult0+ThreatResult1+ThreatResult2>=5000){
						this.CheckAndAdd(AIAction.PhotonStrike, 0);
					}
				}
			}
		}
		if(ThreatResult0+ThreatResult1+ThreatResult2<2300){
			if(Math.abs(Math.max(ThreatResult0, Math.max(ThreatResult1, ThreatResult2))
					-(Math.max(ThreatResult0, Math.max(ThreatResult1, ThreatResult2))))>300){
				attack(this.getWeakPath(),AttackRiskResult);
				for(int i=0;i<=2;i++){
					if(i!=this.getWeakPath()){
						resist(i);
					}
				}
			}else{
				resist(0);
				resist(1);
				resist(2);
			}
		}

	}
	private void attack(int path_num,int attackRisk){
		this.CheckAndAdd(AIAction.Rifle, path_num);
		this.CheckAndAdd(AIAction.SpaceMan, path_num);
		this.CheckAndAdd(AIAction.Drone, path_num);
		if(attackRisk<300){
			this.CheckAndAdd(AIAction.Rifle, path_num);
			this.CheckAndAdd(AIAction.SpaceMan, path_num);
			this.CheckAndAdd(AIAction.Drone, path_num);
		}
		this.CheckAndAdd(AIAction.SpaceShip, path_num);
		this.CheckAndAdd(AIAction.RazerShip, path_num);
		this.CheckAndAdd(AIAction.Truck, path_num);
		this.CheckAndAdd(AIAction.SpaceCarrier, path_num);
		this.CheckAndAdd(AIAction.Sneaker, path_num);
		this.CheckAndAdd(AIAction.RobotWarrior, path_num);
		if(attackRisk<400){
			this.CheckAndAdd(AIAction.SpaceShip, path_num);
			this.CheckAndAdd(AIAction.RazerShip, path_num);
			this.CheckAndAdd(AIAction.Truck, path_num);
			this.CheckAndAdd(AIAction.SpaceCarrier, path_num);
			this.CheckAndAdd(AIAction.Sneaker, path_num);
			this.CheckAndAdd(AIAction.RobotWarrior, path_num);
		}
	}
	//Done
	private void resist(int path_num){
		Threat = analyzeThreat(path_num);
		boolean vacant = true;
		int dis;
		for(int i=0;i<DataBase.playerList.size();i++){
			if(DataBase.playerList.get(i).path==path_num){
				S_Unit u = DataBase.playerList.get(i); 
				dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG5-u.getX())*(db.START_LOC_X_ENM_STG5-u.getX())+
						(db.START_LOC_Y_ENM_STG5+165*path_num-u.getY())*(db.START_LOC_Y_ENM_STG5+165*path_num-u.getY()));
				for(int j=0;j<DataBase.enemyList.size();j++){
					if(DataBase.enemyList.get(j).getType()!=100){
						if(DataBase.enemyList.get(j).path==path_num) vacant = false;
					}
				}
				if (dis <=300&&vacant&&Threat<=250){
					this.CheckAndAdd(AIAction.Rifle, path_num);
					this.CheckAndAdd(AIAction.SpaceMan, path_num);
					this.CheckAndAdd(AIAction.Drone, path_num);
				}
				if (dis <=300&&vacant&&Threat>250&&Threat<=500){
					this.CheckAndAdd(AIAction.MedicTeam, getRandomPath());
					this.CheckAndAdd(AIAction.Sniper,getRandomPath() );
					this.CheckAndAdd(AIAction.SpaceShip, path_num);
					this.CheckAndAdd(AIAction.RazerShip, path_num);
				}
				if (dis <=300&&vacant&&Threat>500&&Threat<=800){
					this.CheckAndAdd(AIAction.Truck, path_num);
					this.CheckAndAdd(AIAction.SpaceCarrier, path_num);
					this.CheckAndAdd(AIAction.Sneaker, path_num);
					this.CheckAndAdd(AIAction.RobotWarrior, path_num);
				}
			}
		}
		// System.out.println("path "+path_num+" vacant is "+vacant);
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
	//Done 
	private int analyzeAttackRisk(int ThreatResult0,int ThreatResult1,int ThreatResult2){
		int weakThreat = Math.min(Math.min(ThreatResult0, ThreatResult1), ThreatResult2);
		return (int) (weakThreat*getCastlePercentage(1)*getCastlePercentage(1));
	}
	//Done
	private int getWeakPath(){
		int ThreatResult0 = analyzeThreat(0);
		int ThreatResult1 = analyzeThreat(0);
		int ThreatResult2 = analyzeThreat(0);
		int path = 0;
		int weak = ThreatResult0;
		if(ThreatResult1<=weak){
			path = 1;
			weak = ThreatResult1;
		}
		if(ThreatResult2<=weak){
			path = 2;
		}
		return path;
	}
	private int analyzeDevelop(){

		return 0;
	}
	//Done
	private int balanceByLevel(int prudentData){
		int result = (int) (prudentData/(Math.pow(3, this.Pass-11)));
		return result;
	}
	//Done
	private double getCastlePercentage(int Kind){
		double CastleHp = 0;
		double FullCastleHp = 0;
		if(Kind==0){
			for(int i=0;i<DataBase.enemyList.size();i++){
				if(DataBase.enemyList.get(i).getType()==100){
					CastleHp = DataBase.enemyList.get(i).getHp();
				}
			}
			switch(Pass){
			case 11: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV1;break;
			case 12: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV2;break;
			case 13: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV3;break;
			}
		}
		else{
			for(int i=0;i<DataBase.playerList.size();i++){
				if(DataBase.playerList.get(i).getType()==100){
					CastleHp = DataBase.playerList.get(i).getHp();
				}
			}
			switch(DataBase.pass){
			case 11: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV1;break;
			case 12: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV2;break;
			case 13: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV3;break;
			}
		}
		// System.out.printf("FUllHP is %f and Now is %f \n",FullCastleHp,CastleHp);
		return CastleHp/FullCastleHp;
	}
	//Done
	public void CheckAndAdd(AIAction action,int path_num){
		switch(action){
		case MedicTeam: if(this.Money>=DataBase.MEDICTEAM_P&&AIMoney.AIPass==11){
			AIC.addMedicTeam(path_num);
			AIMoney.Money-= DataBase.MEDICTEAM_P;
		}break;
		case Sniper: if(this.Money>=DataBase.SNIPER_P&&AIMoney.AIPass==11){
			AIC.addSniper(path_num);
			AIMoney.Money-= DataBase.SNIPER_P;
		}break;
		case Truck: if(this.Money>=DataBase.TRUCK_P&&AIMoney.AIPass==11){
			AIC.addTruck(path_num);
			AIMoney.Money-= DataBase.TRUCK_P;
		}break;
		case Rifle: if(this.Money>=DataBase.RIFLE_P&&AIMoney.AIPass==11){
			AIC.addRifle(path_num);
			AIMoney.Money-= DataBase.RIFLE_P;
		}break;
		case SpaceCarrier: if(this.Money>=DataBase.SPACECARRIER_P&&this.Pass==12){
			AIC.addSpaceCarrier(path_num);
			AIMoney.Money-= DataBase.SPACECARRIER_P;
		}break;
		case SpaceMan: if(this.Money>=DataBase.SPACEMAN_P&&this.Pass==12){
			AIC.addSpaceMan(path_num);
			AIMoney.Money-= DataBase.SPACEMAN_P;
		}break;
		case SpaceShip: if(this.Money>=DataBase.SPACESHIP_P&&this.Pass==12){
			AIC.addSpaceShip(path_num);
			AIMoney.Money-= DataBase.SPACESHIP_P;
		}break;
		case Drone: if(this.Money>=DataBase.DRONE_P&&this.Pass==13){
			AIC.addDrone(path_num);
			AIMoney.Money-= DataBase.DRONE_P;
		}break;
		case RazerShip: if(this.Money>=DataBase.RAZERSHIP_P&&this.Pass==13){
			AIC.addRazerShip(path_num);
			AIMoney.Money-= DataBase.RAZERSHIP_P;
		}break;
		case RobotWarrior: if(this.Money>=DataBase.ROBOTWARRIOR_P&&this.Pass==13){
			AIC.addRobotWarrior(path_num);
			AIMoney.Money-= DataBase.ROBOTWARRIOR_P;
		}break;
		case Sneaker: if(this.Money>=DataBase.SNEAKER_P&&this.Pass==13){
			AIC.addSneaker(path_num);
			AIMoney.Money-= DataBase.SNEAKER_P;
		}break;
		case LockScience: if(this.Money>=DataBase.TECH_LOCKSCIENCE_P&&this.Pass==12){
			AIC.LockScience();
			AIMoney.Money-= DataBase.TECH_LOCKSCIENCE_P;
		}break;
		case GeneMissile: if(this.Money>=DataBase.TECH_GENEMISSILE_P&&this.Pass==13){
			AIC.GeneMissile();
			AIMoney.Money-= DataBase.TECH_GENEMISSILE_P;
		}break;
		case KillerVirus: if(this.Money>=DataBase.TECH_KILLERVIRUS_P&&this.Pass==13){
			AIC.KillerVirus();
			AIMoney.Money-= DataBase.TECH_KILLERVIRUS_P;
		}break;
		case PhotonStrike: if(this.Money>=DataBase.TECH_PHOTONSTRIKE_P&&this.Pass==13){
			AIC.PhotonStrike();
			AIMoney.Money-= DataBase.TECH_PHOTONSTRIKE_P;
		}break;
		}
	}
	private int getRandomPath(){
		return (int) (Math.random()*3);
	}
	//Done
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
