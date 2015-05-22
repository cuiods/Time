package units;

import dataBase.DataBase;

public class STG4_RobotWarrior extends S_Soldier implements Runnable{
	public STG4_RobotWarrior(){
		switch(DataBase.pass){
		case 4:
			x = DataBase.START_LOC_X_STG4;
			y = DataBase.START_LOC_Y_STG4;break;
		case 5:
			x = DataBase.START_LOC_X_STG5;
			y = DataBase.START_LOC_Y_STG5;break;
		}
	    hp=DataBase.ROBOTWARRIOR_HP;
	    attack = DataBase.ROBOTWARRIOR_ATK;
		attackRange = DataBase.ROBOTWARRIOR_AR;
		speed = DataBase.ROBOTWARRIOR_SPD;
	    setType(14);
	}
}
