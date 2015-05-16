package units;

import dataBase.DataBase;

public class STG3_SecondCastle extends S_Soldier implements Runnable{
	public STG3_SecondCastle(){
		x = DataBase.SECONDCASTLE_LOC_X_STG3;
		y = DataBase.SECONDCASTLE_LOC_Y_STG3;
	    hp=DataBase.SECONDCASTLE_HP;
	    attack = DataBase.SECONDCASTLE_ATK;
		attackRange = DataBase.SECONDCASTLE_AR;
		speed = DataBase.SECONDCASTLE_SPD;
	    setType(101);
	}
}
