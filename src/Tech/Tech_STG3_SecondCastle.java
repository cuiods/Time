package Tech;

import gamecontrol.Controller;
import units.SecondCastle;
import dataBase.DataBase;

public class Tech_STG3_SecondCastle {
	public Tech_STG3_SecondCastle(){
		if(DataBase.Tech_SuperComputer = true&&!DataBase.LockScience){
			DataBase.Tech_SecondCastle = true;
			SecondCastle secastle = new SecondCastle();
			DataBase.playerList.add(secastle);
			secastle.setKind(1);
			secastle.setHp(DataBase.SECONDCASTLE_HP);
			Thread ct = new Thread(secastle);
			ct.start();
			Controller.gameframe.repaint();
		}
	}
}
