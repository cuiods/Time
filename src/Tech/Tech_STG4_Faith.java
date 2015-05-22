package Tech;

import tools.MusicThread;
import ui.PanelFight;
import units.S_Unit;
import dataBase.DataBase;

public class Tech_STG4_Faith {
	public Tech_STG4_Faith(){
		if(DataBase.Tech_FourthTechRevolution){
			DataBase.Tech_Faith = true;
			execute();
		}
	}
	public void execute(){
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit u = DataBase.playerList.get(i);
			u.attack+=5;
		}
		DataBase.Money -= DataBase.Tech_Faith_P;
		PanelFight.isTech_13=true;
		new MusicThread("music/effects/faith.wav", false).start();
		DataBase.Tech_Faith = false;
	}
}
