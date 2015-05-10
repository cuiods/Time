package Tech;

import units.SecondCastle;
import dataBase.DataBase;

public class Tech_STG3_SecondCastle {
	public Tech_STG3_SecondCastle(){
		if(DataBase.Tech_SuperComputer = true){
			DataBase.Tech_SecondCastle = true;
			SecondCastle secastle = new SecondCastle();
			Thread ct = new Thread(secastle);
			ct.start();
			DataBase.playerList.add(secastle);
		}
	}
}
