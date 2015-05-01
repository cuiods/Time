package units;

import java.io.Serializable;

import dataBase.DataBase;

public class Castle extends Unit implements Runnable, Serializable{
	
	public int addSpeed = 1;
	
	public Castle(){
		x = DataBase.START_LOC_X_STG1 ;
		y = DataBase.START_LOC_Y_STG1 ;
		hp = DataBase.CASTLE_HP_STG1;
		setType(100);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int detect() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canAttack() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		while(true){
			if(hp+addSpeed<=DataBase.CASTLE_HP_STG1&&this.getKind() == 1){
				hp+=addSpeed;
			}
			if(hp+addSpeed<=DataBase.CASTLE_HP_ENM&&this.getKind() == 0){
				hp+=addSpeed;
			}
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
