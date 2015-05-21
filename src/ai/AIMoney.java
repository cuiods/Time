package ai;

import dataBase.DataBase;

public class AIMoney implements Runnable{
	public static int Money = DataBase.INITIAL_MONEY_CLASSIC;
	public static int AIPass = 11;
	public int Money_Increment = 0;
	@Override
	public void run() {
		while(DataBase.threadContinue){
			switch(this.AIPass){
			case 11:
			case 2:Money_Increment = DataBase.INITIAL_MONEY_INCREMENT_STG3;break;
			case 12:
			case 3:Money_Increment = DataBase.INITIAL_MONEY_INCREMENT_STG4;break;
			case 13:
			case 4:Money_Increment = DataBase.INITIAL_MONEY_INCREMENT_STG5;break;
			}
			if(!DataBase.isPause){
				this.Money+=Money_Increment;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
