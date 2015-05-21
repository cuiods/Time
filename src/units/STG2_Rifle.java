package units;

import dataBase.DataBase;

public class STG2_Rifle extends S_Soldier implements Runnable{


	
	//initialization
	public STG2_Rifle(){
		x = DataBase.START_LOC_X_STG2;
		y = DataBase.START_LOC_Y_STG2;
    	hp=DataBase.RIFLE_HP;
    	attack = DataBase.RIFLE_ATK;
    	this.Upgrade();
		attackRange = DataBase.RIFLE_AR;
		speed = DataBase.RIFLE_SPD;
    	setType(6);
    }

}
