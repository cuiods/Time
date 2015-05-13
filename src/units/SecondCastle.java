package units;

import dataBase.DataBase;

public class SecondCastle extends Soldier implements Runnable{
	public SecondCastle(){
		x = DataBase.SECONDCASTLE_LOC_X_STG3;
		y = DataBase.SECONDCASTLE_LOC_Y_STG3;
	    hp=DataBase.SECONDCASTLE_HP;
	    attack = DataBase.SECONDCASTLE_ATK;
		attackRange = DataBase.SECONDCASTLE_AR;
		speed = DataBase.SECONDCASTLE_SPD;
	    setType(101);
	}
}
