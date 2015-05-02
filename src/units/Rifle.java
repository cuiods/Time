package units;

import dataBase.DataBase;

public class Rifle extends Soldier implements Runnable{


	
	//initialization
	public Rifle(){
		x = DataBase.START_LOC_X_STG2;
		y = DataBase.START_LOC_Y_STG2;
    	hp=DataBase.RIFLE_HP;
    	setType(6);
    }

}
