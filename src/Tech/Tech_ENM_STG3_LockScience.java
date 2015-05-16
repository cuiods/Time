package Tech;

import tools.Time;
import dataBase.DataBase;
public class Tech_ENM_STG3_LockScience implements Runnable {
	Time t;
	public Tech_ENM_STG3_LockScience(){
		t = new Time(DataBase.LOCKSCIENCE_TIMELIMIT);
	}
	public void execute(){
		DataBase.LockScience = true;
		while(t.getRemainTime()>=0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	    }
		DataBase.LockScience = false;
}

	@Override
	public void run() {
		this.execute();
		
	}
}
