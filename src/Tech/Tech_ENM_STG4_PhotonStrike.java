package Tech;

import units.S_Unit;
import dataBase.DataBase;

public class Tech_ENM_STG4_PhotonStrike {
	public void execute(){
		if(!DataBase.Tech_CoverProject){
			for(int i=0;i<DataBase.playerList.size();i++){
				S_Unit ce = DataBase.playerList.get(i);
				ce.setHp(0);
				DataBase.playerList.remove(ce);
			}
		}
	}
}
