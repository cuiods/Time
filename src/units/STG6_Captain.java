package units;

import dataBase.DataBase;

public class STG6_Captain extends S_Soldier implements Runnable {
	public STG6_Captain(){
		x = DataBase.START_LOC_X_STG6;
		y = DataBase.START_LOC_Y_STG6;
		hp=DataBase.CAPTAIN_HP;
		attack = DataBase.CAPTAIN_ATK;
		attackRange = DataBase.CAPTAIN_AR;
		speed = DataBase.CAPTAIN_SPD;
		setType(16);
	}
}
