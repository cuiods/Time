package Tech;

import tools.Time;
import dataBase.DataBase;
//store 80% of the money and it will be doubled and get it back in 30 secs
public class Tech_STG5_Escape implements Runnable{
	Time t;
	int Deposit = 0;
	public Tech_STG5_Escape(){
		DataBase.Tech_Escape = true;
		t = new Time(DataBase.ESCAPE_TIMELIMIT);
		Deposit = DataBase.Money/2;
		DataBase.Money -= Deposit;
		this.execute();
	}
	@Override
	public void run() {
		while(t.getRemainTime()>=0){
			System.out.println(t.getsRemainTime());
		}
		DataBase.Money+= 2*Deposit; 
		DataBase.Tech_Escape = false;
	}
	public void execute(){
		Thread th = new Thread(this);
		th.start();
	}
}
