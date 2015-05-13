package units;

import tools.Time;
import dataBase.DataBase;

public class Sneaker extends Soldier{
	public Sneaker(){
		x = DataBase.START_LOC_X_STG4;
		y = DataBase.START_LOC_Y_STG4;
	    hp=DataBase.SNEAKER_HP;
	    attack = DataBase.SNEAKER_ATK;
		attackRange = DataBase.SNEAKER_AR;
		speed = DataBase.SNEAKER_SPD;
	    setType(15);
	}
	@Override
	public boolean canAttack(){
		Time tm = new Time(DataBase.SNEAKER_TIMELIMIT);
		if(tm.getRemainTime()>=0){
			return false;
		}
		else{
			return super.canAttack();
		}
	}

}
