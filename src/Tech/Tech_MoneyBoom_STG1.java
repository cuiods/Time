package Tech;

import dataBase.DataBase;

public class Tech_MoneyBoom_STG1 {
	
	public Tech_MoneyBoom_STG1(){
		DataBase.Tech_MoneyBoom = true;
		DataBase.Money_Increment = (int) ((int) DataBase.Money_Increment*2.5);
	}
}
