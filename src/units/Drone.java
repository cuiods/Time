package units;

import dataBase.DataBase;

public class Drone extends Soldier implements Runnable{
	public Drone(){
		switch(DataBase.pass){
		case 4:
			x = DataBase.START_LOC_X_STG4;
			y = DataBase.START_LOC_Y_STG4;break;
		case 5:
			x = DataBase.START_LOC_X_STG5;
			y = DataBase.START_LOC_Y_STG5;break;
		}
	    hp=DataBase.DRONE_HP;
	    attack = DataBase.DRONE_ATK;
		attackRange = DataBase.DRONE_AR;
		speed = DataBase.DRONE_SPD;
	    setType(12);
	}
	

}
