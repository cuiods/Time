package Tech;

import dataBase.DataBase;

public class Tech2 {
	DataBase db = new DataBase();
	public Tech2(){
		db.Tech_2 = true;
		db.Money_Increment = (int) ((int) db.Money_Increment*1.5);
	}
}
