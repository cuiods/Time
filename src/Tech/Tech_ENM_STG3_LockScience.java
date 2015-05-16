package Tech;

import tools.Time;
import dataBase.DataBase;

public class Tech_ENM_STG3_LockScience {
	public Time locktime;
	public void execute(){
		locktime = new Time(DataBase.LOCKSCIENCE_TIMELIMIT);
		while(locktime.getRemainTime()>=0){
			DataBase.LockScience = true;
	    }
		DataBase.LockScience = false;
}
}
