package units;

import dataBase.DataBase;

public class Rifle extends Soldier implements Runnable{


	
	//initialization
	public Rifle(){
		x = DataBase.START_LOC_X_STG1;
		y = DataBase.START_LOC_Y_STG1;
    	hp=DataBase.SWORDMAN_HP;
    	setType(6);
    }

}
