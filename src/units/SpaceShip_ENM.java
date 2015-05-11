package units;

import dataBase.DataBase;

public class SpaceShip_ENM extends Soldier{
	public SpaceShip_ENM(){
		x = DataBase.START_LOC_X_ENM_STG3;
		y = DataBase.START_LOC_Y_ENM_STG3;
	    hp=DataBase.SPACESHIP_HP;
	    attack = DataBase.SPACESHIP_ATK;
		attackRange = DataBase.SPACESHIP_AR;
		speed = DataBase.SPACESHIP_SPD;
	    setType(11);
	}

}
