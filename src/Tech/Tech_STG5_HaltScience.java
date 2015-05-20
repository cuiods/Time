package Tech;

import tools.Time;
import units.S_Unit;
import dataBase.DataBase;

//this tech allows all players' unit to be invisible for some time 
public class Tech_STG5_HaltScience implements Runnable{
	Time t;
	public Tech_STG5_HaltScience(){
		t = new Time(DataBase.HALTSCIENCE_TIMELIMIT);
		Thread th = new Thread(this);
		th.start();
	}
	public void run(){
		DataBase.Tech_HaltScience = true;
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			ce.invisible = true;
		}
		while(t.getRemainTime()>=0){
		}
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			ce.invisible = false;
		}
		DataBase.Tech_HaltScience = false;
	}
}
