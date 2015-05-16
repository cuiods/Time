package Tech;

import tools.Time;
import dataBase.DataBase;

//this tech allows all players' unit to be invisible for some time 
public class Tech_STG5_HaltScience {
	Time t;
	public Tech_STG5_HaltScience(){
		t = new Time(DataBase.HALTSCIENCE_TIMELIMIT);
		while(t.getRemainTime()>=0){
		DataBase.Tech_HaltScience = true;
		}
		DataBase.Tech_HaltScience = false;
	}
}
