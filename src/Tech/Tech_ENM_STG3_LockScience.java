package Tech;

import ai.AIMoney;
import tools.Time;
import dataBase.DataBase;
public class Tech_ENM_STG3_LockScience implements Runnable {
	public Time t;
	public Tech_ENM_STG3_LockScience(){
		AIMoney.Money -= DataBase.TECH_LOCKSCIENCE_P;
		t = new Time(DataBase.LOCKSCIENCE_TIMELIMIT);
	}
	public void execute(){
		DataBase.LockScience = true;
		while(t.getRemainTime()>=0&&DataBase.threadContinue){
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
