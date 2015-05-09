package Tech;

import units.Unit;
import dataBase.DataBase;

public class Tech_STG1_Destroy {
	
	public Tech_STG1_Destroy(){
		
		DataBase.Tech_Destroy = true;
		execute();
		DataBase.Tech_Destroy = false;//第三个科技不是一次性的，可以多次买多次使用
	}
	public void execute(){
		for(Unit u :DataBase.enemyList){
			if(u.getType()!=100){
			if(Math.random()>=0.2){
				u.setHp(0);;//按照80%概率让他死掉
			}
			}
		}
		for(int i = 0; i<DataBase.enemyList.size(); i++){
			if(DataBase.enemyList.get(i).getHp() <= 0){
				DataBase.enemyList.remove(i);
			}
		}
	}
}
