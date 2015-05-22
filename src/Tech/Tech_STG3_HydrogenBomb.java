package Tech;

import tools.MusicThread;
import dataBase.DataBase;

public class Tech_STG3_HydrogenBomb {
	public Tech_STG3_HydrogenBomb(){
		if(DataBase.Tech_SuperComputer&&!DataBase.LockScience)
		DataBase.Tech_HydrogenBomb = true;
		DataBase.Money -= DataBase.Tech_HydrogenBomb_P;
		new MusicThread("music/effects/qingdan.wav", false).start();
	}
}
