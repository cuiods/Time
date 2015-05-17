package units;

import dataBase.DataBase;

public class STG6_Artdesigner extends S_Soldier implements Runnable{
	public STG6_Artdesigner(){
		x = DataBase.START_LOC_X_STG6;
		y = DataBase.START_LOC_Y_STG6;
		hp=DataBase.ARTDESIGNER_HP;
		attack = DataBase.ARTDESIGNER_ATK;
		attackRange = DataBase.ARTDESIGNER_AR;
		speed = DataBase.ARTDESIGNER_SPD;
		setType(18);
	}
}
