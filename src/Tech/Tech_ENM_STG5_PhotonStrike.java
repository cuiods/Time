package Tech;

import units.Unit;
import dataBase.DataBase;

public class Tech_ENM_STG5_PhotonStrike {
	public void execute(){
		if(!DataBase.Tech_CoverProject){
			for(int i=0;i<DataBase.playerList.size();i++){
				Unit ce = DataBase.playerList.get(i);
				ce.setHp(0);
				DataBase.playerList.remove(ce);
			}
		}
	}
}
