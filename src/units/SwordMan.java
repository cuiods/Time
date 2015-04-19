package units;

import dataBase.DataBase;



public class SwordMan extends Soldier implements Runnable{


	
	//initialization
	public SwordMan(){
		x = DataBase.START_LOC_X_STG1;
		y = DataBase.START_LOC_Y_STG1;
    	hp=DataBase.SWORDMAN_HP;
    	setType(0);
    }
     
}
