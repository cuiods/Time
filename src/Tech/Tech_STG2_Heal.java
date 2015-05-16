package Tech;

import dataBase.DataBase;
import units.S_Unit;

public class Tech_STG2_Heal {
	public Tech_STG2_Heal(){
		DataBase.Tech_Heal = true;
		execute();
	}
	public void execute(){
	for(S_Unit u:DataBase.playerList){
		if(u.getType()!=100)
		u.setHp(getFullHP(u));
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
