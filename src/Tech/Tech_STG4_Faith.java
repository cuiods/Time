package Tech;

import units.S_Unit;
import dataBase.DataBase;

public class Tech_STG4_Faith {
	public Tech_STG4_Faith(){
		if(DataBase.Tech_FourthTechRevolution){
			DataBase.Tech_Faith = true;
			execute();
		}
	}
	public void execute(){
		for(S_Unit u: DataBase.playerList){
			u.attack+=1;
		}
	}
}
