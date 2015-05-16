package Tech;

import ui.PanelFight;
import dataBase.DataBase;

public class Tech_STG3_Hubble {
	public Tech_STG3_Hubble(){
		if(!DataBase.LockScience){
			DataBase.Tech_Harper = true;
<<<<<<< HEAD
			DataBase.Tech_Harper_TIME++;
			DataBase.Money-=DataBase.Tech_Harper_P;
			PanelFight.isTech_9=true;
=======
>>>>>>> origin/master
		}
	}
}
