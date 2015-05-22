package Tech;

import tools.MusicThread;
import ui.PanelFight;
import dataBase.DataBase;

public class Tech_STG3_Hubble {
	public Tech_STG3_Hubble(){
		if(!DataBase.LockScience){
			DataBase.Tech_Harper = true;
			DataBase.Tech_Harper_TIME++;
			DataBase.Money-=DataBase.Tech_Harper_P;
			new MusicThread("music/effects/shadow.wav", false).start();
		}
	}
}
