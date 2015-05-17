package units;

import dataBase.DataBase;

public class STG6_DataMan extends S_Soldier implements Runnable{
	public STG6_DataMan(){
		x = DataBase.START_LOC_X_STG6;
		y = DataBase.START_LOC_Y_STG6;
		hp=DataBase.DATAMAN_HP;
		attack = DataBase.DATAMAN_ATK;
		attackRange = DataBase.DATAMAN_AR;
		speed = DataBase.DATAMAN_SPD;
		setType(19);
	}
}
