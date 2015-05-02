package units;

import dataBase.DataBase;

public class Sniper extends Soldier implements Runnable{
	public Sniper(){
		x = DataBase.START_LOC_X_STG2;
		y = DataBase.START_LOC_Y_STG2;
	    hp=DataBase.SNIPER_HP;
	    setType(4);
	}
}
