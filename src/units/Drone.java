package units;

import dataBase.DataBase;

public class Drone extends Soldier{
	public Drone(){
		x = DataBase.START_LOC_X_STG4;
		y = DataBase.START_LOC_Y_STG4;
	    hp=DataBase.DRONE_HP;
	    attack = DataBase.DRONE_ATK;
		attackRange = DataBase.DRONE_AR;
		speed = DataBase.DRONE_SPD;
	    setType(12);
	}
	

}
