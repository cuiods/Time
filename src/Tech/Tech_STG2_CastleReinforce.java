package Tech;

import dataBase.DataBase;
import units.Unit;

public class Tech_STG2_CastleReinforce {
	public Tech_STG2_CastleReinforce(){
		DataBase.Tech_CastleReinforce = true;
		execute();
	}
	public void execute(){
	for(Unit u: DataBase.playerList){
		if(u.getType()==100){
			u.setHp(DataBase.CASTLE_HP_STG2);
		}
	}
	}
}
