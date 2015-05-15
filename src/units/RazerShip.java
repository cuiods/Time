package units;

import dataBase.DataBase;

public class RazerShip extends Soldier implements Runnable{
	public RazerShip(){
		switch(DataBase.pass){
		case 4:
			x = DataBase.START_LOC_X_STG4;
			y = DataBase.START_LOC_Y_STG4;break;
		case 5:
			x = DataBase.START_LOC_X_STG5;
			y = DataBase.START_LOC_Y_STG5;break;
		}
	    hp=DataBase.RAZERSHIP_HP;
	    attack = DataBase.RAZERSHIP_ATK;
		attackRange = DataBase.RAZERSHIP_AR;
		speed = DataBase.RAZERSHIP_SPD;
	    setType(13);
	}
	
}
