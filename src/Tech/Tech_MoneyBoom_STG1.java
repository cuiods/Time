package Tech;

import dataBase.DataBase;

public class Tech_MoneyBoom_STG1 {
	DataBase db = new DataBase();
	public Tech_MoneyBoom_STG1(){
		db.Tech_MoneyBoom = true;
		db.Money_Increment = (int) ((int) db.Money_Increment*2.5);
	}
}
