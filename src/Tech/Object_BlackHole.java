package Tech;

import dataBase.DataBase;
import tools.Time;
import units.S_Soldier;
import units.S_Unit;

public class Object_BlackHole extends S_Soldier{
	public Object_BlackHole(){
		x = DataBase.BLACKHOLE_LOC_X_STG4;
		y = DataBase.BLACKHOLE_LOC_Y_STG4;
		hp = 10;
		attack = 0;
		attackRange = 400;
		this.setType(102);
	}
	@Override
	public void run() {
		Time t = new Time(DataBase.BLACKHOLE_TIMELIMIT);
		while(t.getRemainTime()>=0){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			this.attack();
		}
		DataBase.playerList.remove(this);
		DataBase.Tech_BlackHoleProject = false;
	}
	@Override
	public void move(){

	}
	@Override
	public void attack() {
		int atk=0;
		if(!DataBase.isPause){
			atk = this.attack;
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit ce = DataBase.enemyList.get(i);
			if(ce.getHp()>0&&this.hp>0&&caldistance(this.x,this.y,ce.x,ce.y)<=this.attackRange){
				if(ce.getType()!=100){
					ce.setHp(0);
					DataBase.enemyList.remove(ce);
				}
			}
		}
	}

}
