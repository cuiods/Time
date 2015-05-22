package units;

import dataBase.DataBase;



public class STG1_SwordMan extends S_Soldier implements Runnable{


	
	//initialization
	public STG1_SwordMan(){
		x = DataBase.START_LOC_X_STG1;
		y = DataBase.START_LOC_Y_STG1;
    	hp=DataBase.SWORDMAN_HP;
    	attack = DataBase.SWORDMAN_ATK;
		attackRange = DataBase.SWORDMAN_AR;
		speed = DataBase.SWORDMAN_SPD;
    	setType(0);
    }
     
}
