package Tech;

import tools.Time;
import dataBase.DataBase;

public class Tech_ENM_STG3_LockScience {
	public void execute(){
		Time t = new Time(DataBase.LOCKSCIENCE_TIMELIMIT);
		while(t.getRemainTime()>=0){
			DataBase.LockScience = true;
	}
		DataBase.LockScience = false;
}
}
