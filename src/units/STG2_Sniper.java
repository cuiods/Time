package units;

import dataBase.DataBase;

public class STG2_Sniper extends S_Soldier implements Runnable{
	public static int Sniper_Num = 0;
	public STG2_Sniper(){
		x = DataBase.START_LOC_X_STG2;
		y = DataBase.START_LOC_Y_STG2;
	    hp=DataBase.SNIPER_HP;
	    attack = DataBase.SNIPER_ATK;
	    this.Upgrade();
		attackRange = DataBase.SNIPER_AR;
		speed = DataBase.SNIPER_SPD;
	    setType(4);
	}
}
