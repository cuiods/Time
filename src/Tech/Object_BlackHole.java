package Tech;

import dataBase.DataBase;
import tools.Time;
import units.Soldier;
import units.Unit;

public class Object_BlackHole extends Soldier{
	public Object_BlackHole(){
		x = DataBase.BLACKHOLE_LOC_X_STG4;
		y = DataBase.BLACKHOLE_LOC_Y_STG4;
		hp = 100000000;
		attack = 10000000;
		attackRange = 300;
		this.setType(101);
	}
	@Override
	public void run() {
		Time t = new Time(DataBase.BLACKHOLE_TIMELIMIT);
		while(t.getRemainTime()>=0){
			this.attack();
		}
	}
	@Override
	public void move(){
		
	}
	
}
