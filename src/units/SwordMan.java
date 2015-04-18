package units;



public class SwordMan extends Soldier implements Runnable{


	
	//initialization
	public SwordMan(){
		x = db.START_LOC_X_STG1;
		y = db.START_LOC_Y_STG1;
    	hp=db.SWORDMAN_HP;
    	setType(0);
    }
     
}
