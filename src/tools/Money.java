package tools;
import dataBase.DataBase;
public class Money implements Runnable{
	public int Money_Increment = 0;
	@Override
	public void run() {
		while(DataBase.threadContinue){
			switch(DataBase.pass){
			case 1: if(DataBase.Tech_MoneyBoom){
				Money_Increment = (int) (DataBase.INITIAL_MONEY_INCREMENT_STG1*2.5);
			}
			else	Money_Increment = DataBase.INITIAL_MONEY_INCREMENT_STG1;break;
			case 11:
			case 2:Money_Increment = DataBase.INITIAL_MONEY_INCREMENT_STG2;break;
			case 12:
			case 3:Money_Increment = DataBase.INITIAL_MONEY_INCREMENT_STG3;break;
			case 13:
			case 4:Money_Increment = DataBase.INITIAL_MONEY_INCREMENT_STG4;break;
			case 5:Money_Increment = DataBase.INITIAL_MONEY_INCREMENT_STG5;break;
			}
			if(!DataBase.isPause){
				DataBase.Money+=Money_Increment;
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
