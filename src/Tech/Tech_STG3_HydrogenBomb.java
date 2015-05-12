package Tech;

import dataBase.DataBase;

public class Tech_STG3_HydrogenBomb {
	public Tech_STG3_HydrogenBomb(){
		if(DataBase.Tech_SuperComputer&&!DataBase.LockScience)
		DataBase.Tech_HydrogenBomb = true;
	}
}
