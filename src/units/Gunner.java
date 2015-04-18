package units;

import dataBase.DataBase;

public class Gunner extends Soldier implements Runnable {

		
		public Gunner(){
			x = db.START_LOC_X_STG1;
			y = db.START_LOC_Y_STG1;
		    hp=db.GUNNER_HP;
		    setType(1);
		}
}
