package units;

import dataBase.DataBase;

public class RazerShip extends Soldier{
	public RazerShip(){
		x = DataBase.START_LOC_X_STG4;
		y = DataBase.START_LOC_Y_STG4;
	    hp=DataBase.RAZERSHIP_HP;
	    attack = DataBase.RAZERSHIP_ATK;
		attackRange = DataBase.RAZERSHIP_AR;
		speed = DataBase.RAZERSHIP_SPD;
	    setType(13);
	}
	
}
