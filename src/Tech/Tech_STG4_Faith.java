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
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit u = DataBase.playerList.get(i);
			u.attack+=5;
		}
		DataBase.Tech_Faith = false;
	}
}
