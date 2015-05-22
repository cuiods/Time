package Tech;

import gamecontrol.Controller;
import tools.MusicThread;
import units.STG3_SecondCastle;
import dataBase.DataBase;

public class Tech_STG3_SecondCastle {
	public Tech_STG3_SecondCastle(){
		if(!DataBase.LockScience){
			DataBase.Money -= DataBase.Tech_SecondCastle_P;
			DataBase.Tech_SecondCastle = true;
			STG3_SecondCastle secastle = new STG3_SecondCastle();
			DataBase.playerList.add(secastle);
			secastle.setKind(1);
			secastle.setHp(DataBase.SECONDCASTLE_HP);
			Thread ct = new Thread(secastle);
			ct.start();
			Controller.gameframe.repaint();
			new MusicThread("music/effects/secondcastle.wav", false).start();
		}
	}
}
