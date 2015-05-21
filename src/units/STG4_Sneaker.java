package units;

import tools.Time;
import dataBase.DataBase;

public class STG4_Sneaker extends S_Soldier implements Runnable{
	private Time tm;
	public STG4_Sneaker(){
		invisible = true;
		tm = new Time(DataBase.SNEAKER_TIMELIMIT);
		switch(DataBase.pass){
		case 4:
			x = DataBase.START_LOC_X_STG4;
			y = DataBase.START_LOC_Y_STG4;break;
		case 5:
			x = DataBase.START_LOC_X_STG5;
			y = DataBase.START_LOC_Y_STG5;break;
		}
	    hp=DataBase.SNEAKER_HP;
	    attack = DataBase.SNEAKER_ATK;
	    this.Upgrade();
		attackRange = DataBase.SNEAKER_AR;
		speed = DataBase.SNEAKER_SPD;
	    setType(15);
	}
	@Override
	public boolean canAttack(){
		if(this.tm.getRemainTime()>=0){
			this.invisible = true;
			return false;
		}
		else{
			this.invisible = false;
			return super.canAttack();
		}
	}
	@Override
	public void run() {
		while(DataBase.threadContinue){
			if(this.hp<=0){
				//	this.die();
				break;
				}
				if(canAttack()){
					synchronized(this){
					this.moving = false;
					this.attacking = true;
					}
					attack();
					
				}else{
					synchronized(this){
					this.attacking = false;
					this.moving = true;
					}
					move();
				}
		}
	}

}
