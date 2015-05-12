package units;

import tools.DrawUnits;
import dataBase.DataBase;

public class HydrogenBomb extends Soldier implements Runnable{
	public boolean notAttacked = true;
	public HydrogenBomb(){
		x = DataBase.START_LOC_X_STG3;
		y = DataBase.START_LOC_Y_STG3;
	    hp=DataBase.HYDROGENBOMB_HP;
	    attack = DataBase.HYDROGENBOMB_ATK;
		attackRange = DataBase.HYDROGENBOMB_AR;
		speed = DataBase.HYDROGENBOMB_SPD;
	    setType(8);
	}
	@Override
	public void run(){
		
		while(notAttacked){
			if(this.hp<=0){
				}
				if(canAttack()&&this.notAttacked){
					synchronized(this){
					this.moving = false;
					this.attacking = true;
					DrawUnits.starting=true;

					}
					attack();
					this.notAttacked = false;
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
