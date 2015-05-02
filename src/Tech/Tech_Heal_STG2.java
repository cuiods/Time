package Tech;

import dataBase.DataBase;
import units.Unit;

public class Tech_Heal_STG2 {
	public void execute(){
	for(Unit u:DataBase.playerList){
		if(u.getType()!=100)
		u.setHp(getFullHP(u));
	}
	}
	public int getFullHP(Unit u){
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
