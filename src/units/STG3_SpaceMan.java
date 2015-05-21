package units;

import dataBase.DataBase;

public class STG3_SpaceMan extends S_Soldier implements Runnable{
	public STG3_SpaceMan(){
		x = DataBase.START_LOC_X_STG3;
		y = DataBase.START_LOC_Y_STG3;
    	hp=DataBase.SPACEMAN_HP;
    	attack = DataBase.SPACEMAN_ATK;
    	this.Upgrade();
		attackRange = DataBase.SPACEMAN_AR;
		speed = DataBase.SPACEMAN_SPD;
    	setType(10);
    }
}
