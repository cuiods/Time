package units;

import dataBase.DataBase;

public class HydrogenBomb extends Soldier implements Runnable{
	public HydrogenBomb(){
		x = DataBase.START_LOC_X_STG3;
		y = DataBase.START_LOC_Y_STG3;
	    hp=DataBase.HYDROGENBOMB_HP;
	    attack = DataBase.HYDROGENBOMB_ATK;
		attackRange = DataBase.HYDROGENBOMB_AR;
		speed = DataBase.HYDROGENBOMB_SPD;
	    setType(8);
	}
}
