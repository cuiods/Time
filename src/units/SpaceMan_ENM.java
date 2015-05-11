package units;

import dataBase.DataBase;

public class SpaceMan_ENM extends Soldier{
	public SpaceMan_ENM(){
		x = DataBase.START_LOC_X_ENM_STG3;
		y = DataBase.START_LOC_Y_ENM_STG3;
    	hp=DataBase.SPACEMAN_HP;
    	attack = DataBase.SPACEMAN_ATK;
		attackRange = DataBase.SPACEMAN_AR;
		speed = DataBase.SPACEMAN_SPD;
    	setType(10);
    }
}
