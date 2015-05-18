package Tech;

import tools.Time;
import dataBase.DataBase;

//this tech allows all players' unit to be invisible for some time 
public class Tech_STG5_HaltScience {
	Time t;
	public Tech_STG5_HaltScience(){
		t = new Time(DataBase.HALTSCIENCE_TIMELIMIT);
		DataBase.Tech_HaltScience = true;
		while(t.getRemainTime()>=0){
			try {
				Thread.sleep(990);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		DataBase.Tech_HaltScience = false;
	}
}
