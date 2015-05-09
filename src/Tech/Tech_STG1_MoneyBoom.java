package Tech;

import dataBase.DataBase;

public class Tech_STG1_MoneyBoom {
	
	public Tech_STG1_MoneyBoom(){
		DataBase.Tech_MoneyBoom = true;
		DataBase.Money_Increment = (int) ((int) DataBase.Money_Increment*2.5);
	}
}
