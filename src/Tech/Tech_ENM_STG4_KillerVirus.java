package Tech;

import units.S_Unit;
import dataBase.DataBase;

public class Tech_ENM_STG4_KillerVirus {
	public Tech_ENM_STG4_KillerVirus(){
		DataBase.virus=true;
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getType()!=100&&ce.getType()!=101){
				ce.setHp(ce.getHp()-30);
			}
		}
	}


}
