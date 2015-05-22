package Tech;

import tools.MusicThread;
import dataBase.DataBase;

public class Tech_STG4_BlackHoleProject {
	public Tech_STG4_BlackHoleProject(){
		if(DataBase.Tech_FourthTechRevolution == true){
			DataBase.Tech_BlackHoleProject = true;
			Object_BlackHole bh = new Object_BlackHole();
			bh.setKind(1);
			DataBase.playerList.add(bh);
			Thread th = new Thread(bh);
			th.start();
			DataBase.Money -= DataBase.Tech_BlackHoleProject_P;
			new MusicThread("music/effects/blackhole.wav", false).start();
		}
	}
}
