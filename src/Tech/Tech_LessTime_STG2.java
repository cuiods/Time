package Tech;

import dataBase.DataBase;

public class Tech_LessTime_STG2 {
	public Tech_LessTime_STG2(){
		DataBase.Tech_LessTime = true;
		DataBase.StartTime-=1000*60*2;
	}
}
