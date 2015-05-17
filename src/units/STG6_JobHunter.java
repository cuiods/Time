package units;

import dataBase.DataBase;

public class STG6_JobHunter extends S_Soldier implements Runnable{
	public STG6_JobHunter(){
		x = DataBase.START_LOC_X_STG6;
		y = DataBase.START_LOC_Y_STG6;
		hp=DataBase.JOBHUNTER_HP;
		attack = DataBase.JOBHUNTER_ATK;
		attackRange = DataBase.JOBHUNTER_AR;
		speed = DataBase.JOBHUNTER_SPD;
		setType(17);
	}
}
