package units;

import dataBase.DataBase;

public class Gunner extends Soldier implements Runnable {

		
		public Gunner(){
			x = DataBase.START_LOC_X_STG1;
			y = DataBase.START_LOC_Y_STG1;
		    hp=DataBase.GUNNER_HP;
		    attack = DataBase.GUNNER_ATK;
			attackRange = DataBase.GUNNER_AR;
			speed = DataBase.GUNNER_SPD;
		    setType(1);
		}
}
