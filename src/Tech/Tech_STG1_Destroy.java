package Tech;

import units.S_Unit;
import dataBase.DataBase;

public class Tech_STG1_Destroy {
	
	public Tech_STG1_Destroy(){
		
		DataBase.Tech_Destroy = true;
		execute();
		DataBase.Tech_Destroy = false;//第三个科技不是一次性的，可以多次买多次使用
	}
	public void execute(){
		for(S_Unit u :DataBase.enemyList){
			if(u.getType()!=100){
				u.setHp((int) (getFullHP(u)*0.2));//损失80%的血
			}
		}
		for(int i = 0; i<DataBase.enemyList.size(); i++){
			if(DataBase.enemyList.get(i).getHp() <= 0){
				DataBase.enemyList.remove(i);
			}
		}
	}
	public int getFullHP(S_Unit u){
		switch(u.getType()){
		case 0:return DataBase.SWORDMAN_HP;
		case 1:return DataBase.GUNNER_HP;
		case 2:return DataBase.CANNON_HP;
		case 3:return DataBase.MEDICTEAM_HP;
		case 4:return DataBase.SNIPER_HP;
		case 5:return DataBase.TRUCK_HP;
		case 6:return DataBase.RIFLE_HP;
		default:return -1;
		}
	}
}
