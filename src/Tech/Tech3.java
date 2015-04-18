package Tech;

import units.Unit;
import dataBase.DataBase;

public class Tech3 {
	DataBase db = new DataBase();
	public Tech3(){
		db.Tech_3 = true;
		execute();
		db.Tech_3 = false;//第三个科技不是一次性的，可以多次买多次使用
	}
	public void execute(){
		for(Unit u :db.enemyList){
			if(Math.random()>=0.2){
				u.setHp(0);;//按照80%概率让他死掉
			}
		}
		for(int i = 0; i<db.enemyList.size(); i++){
			if(db.enemyList.get(i).getHp() <= 0){
				db.enemyList.remove(i);
			}
		}
	}
}
