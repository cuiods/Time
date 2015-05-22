package Tech;

import tools.MusicThread;
import dataBase.DataBase;

public class Tech_STG3_SuperComputer {
	public Tech_STG3_SuperComputer(){
		if(!DataBase.LockScience){
			DataBase.Tech_SuperComputer = true;
			DataBase.Money -= DataBase.Tech_SuperComputer_P;
			new MusicThread("music/effects/supercomputer.wav", false).start();
		}
	}
}
