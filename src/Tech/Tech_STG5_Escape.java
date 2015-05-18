package Tech;

import tools.Time;
import dataBase.DataBase;
//store 80% of the money and it will be doubled and get it back in 30 secs
public class Tech_STG5_Escape implements Runnable{
	Time t;
	int Deposit = 0;
	public Tech_STG5_Escape(){
		t = new Time(DataBase.ESCAPE_TIMELIMIT);
		Deposit = DataBase.Money/2;
		DataBase.Money -= Deposit;
		this.run();
	}
	@Override
	public void run() {
		while(t.getRemainTime()>=0){
			System.out.println(t.getRemainTime());
			try {
				Thread.sleep(990);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		DataBase.Money+= 2*Deposit; 
	}
	public void execute(){
		Thread th = new Thread(this);
		th.start();
	}
}
