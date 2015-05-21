package units;

import dataBase.DataBase;

public class STG4_Drone extends S_Soldier implements Runnable{
	public STG4_Drone(){
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
	    this.Upgrade();
		attackRange = DataBase.DRONE_AR;
		speed = DataBase.DRONE_SPD;
	    setType(12);
	}
	

}
