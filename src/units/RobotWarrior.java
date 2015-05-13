package units;

import dataBase.DataBase;

public class RobotWarrior extends Soldier{
	public RobotWarrior(){
		x = DataBase.START_LOC_X_STG4;
		y = DataBase.START_LOC_Y_STG4;
	    hp=DataBase.ROBOTWARRIOR_HP;
	    attack = DataBase.ROBOTWARRIOR_ATK;
		attackRange = DataBase.ROBOTWARRIOR_AR;
		speed = DataBase.ROBOTWARRIOR_SPD;
	    setType(14);
	}
}
