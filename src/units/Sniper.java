package units;

import dataBase.DataBase;

public class Sniper extends Soldier{
	public Sniper(){
		x = DataBase.START_LOC_X_STG1;
		y = DataBase.START_LOC_Y_STG1;
	    hp=DataBase.SNIPER_HP;
	    setType(4);
	}
}
