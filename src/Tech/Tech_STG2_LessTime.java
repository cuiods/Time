package Tech;

import dataBase.DataBase;

public class Tech_STG2_LessTime {
	public Tech_STG2_LessTime(){
		DataBase.Tech_LessTime = true;
		
		DataBase.StartTime-=1000*60*2;
		
	}
}
