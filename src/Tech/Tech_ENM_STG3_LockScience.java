package Tech;

import tools.Time;
import dataBase.DataBase;

public class Tech_ENM_STG3_LockScience {
	public void execute(){
		Time t = new Time(DataBase.LOCKSCIENCE_TIMELIMIT);
		while(t.getRemainTime()>=0){
			DataBase.LockScience = true;
			System.out.println("ScienceLocked");
			System.out.println(t.getRemainTime());
			System.out.println(DataBase.LockScience);
	}
		DataBase.LockScience = false;
}
}
