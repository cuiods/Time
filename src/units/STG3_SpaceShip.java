package units;

import dataBase.DataBase;

public class STG3_SpaceShip extends S_Soldier implements Runnable{
	public STG3_SpaceShip(){
		x = DataBase.START_LOC_X_STG3;
		y = DataBase.START_LOC_Y_STG3;
	    hp=DataBase.SPACESHIP_HP;
	    attack = DataBase.SPACESHIP_ATK;
	    this.Upgrade();
		attackRange = DataBase.SPACESHIP_AR;
		speed = DataBase.SPACESHIP_SPD;
	    setType(11);
	}

}
