package units;

import dataBase.DataBase;

public class Cannon extends Soldier implements Runnable {
	 
		

		public Cannon(){
			x = db.START_LOC_X_STG1;
			y = db.START_LOC_Y_STG1;
			hp=db.CANNON_HP;
			setType(2);
		}
}
