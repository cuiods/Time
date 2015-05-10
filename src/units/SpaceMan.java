package units;

import dataBase.DataBase;

public class SpaceMan extends Soldier implements Runnable{
	public SpaceMan(){
		x = DataBase.START_LOC_X_STG3;
		y = DataBase.START_LOC_Y_STG3;
    	hp=DataBase.SPACEMAN_HP;
    	attack = DataBase.SPACEMAN_ATK;
		attackRange = DataBase.SPACEMAN_AR;
		speed = DataBase.SPACEMAN_SPD;
    	setType(10);
    }
}
