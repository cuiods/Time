package Tech;

import dataBase.DataBase;

public class Tech_STG3_Hubble {
	public Tech_STG3_Hubble(){
		if(!DataBase.LockScience)
		DataBase.Tech_Harper = true;
	}
}
