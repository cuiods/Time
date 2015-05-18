package Tech;

import units.S_Unit;
import dataBase.DataBase;

public class Tech_ENM_STG4_KillerVirus {
	public void execute(){
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			ce.setHp(ce.getHp()-30);
		}
	}
}
