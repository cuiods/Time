package units;

import gamecontrol.Controller;

import java.io.Serializable;

import dataBase.DataBase;

public class Castle extends Unit implements Runnable, Serializable{
	public int addSpeed = 1;
	public Castle(){
		switch(DataBase.pass){
		case 1:x = DataBase.START_LOC_X_STG1 ;
		y = DataBase.START_LOC_Y_STG1 ;
		hp = DataBase.CASTLE_HP_STG1;break;
		case 2:x = DataBase.START_LOC_X_STG2 ;
		y = DataBase.START_LOC_Y_STG2 ;
		hp = DataBase.CASTLE_HP_STG2;break;
		case 3:x = DataBase.START_LOC_X_STG3;
		y = DataBase.START_LOC_Y_STG3;
		hp = DataBase.CASTLE_HP_STG3;break;
		case 4:x = DataBase.START_LOC_X_STG4;
		y = DataBase.START_LOC_Y_STG4;
		hp = DataBase.CASTLE_HP_STG4;break;
		}
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
			if(needAdd()){
				hp+=addSpeed;
			}
			switch(DataBase.pass){
			case 4:
				synchronized (this) {
					if(Controller.gameframe.fightPanel!=null&&Controller.gameframe.fightPanel.win()==0){
					    if(DataBase.playerList.get(0).hp>DataBase.playerList.get(1).hp){
					    	DataBase.playerList.get(0).hp = DataBase.playerList.get(1).hp;
					    }else{
					    	DataBase.playerList.get(1).hp = DataBase.playerList.get(0).hp;
					    }
					    if(DataBase.enemyList.get(0).hp>DataBase.enemyList.get(1).hp){
					    	DataBase.enemyList.get(0).hp = DataBase.enemyList.get(1).hp;
					    }else{
					    	DataBase.enemyList.get(1).hp = DataBase.enemyList.get(0).hp;
					    }
					}
				}
				break;
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private boolean needAdd(){
		switch(getKind()){
		case 1:
			switch(DataBase.pass){
			case 1:if(hp+addSpeed<=DataBase.CASTLE_HP_STG1){return true;}break;
			case 2:if(hp+addSpeed<=DataBase.CASTLE_HP_STG2){return true;}break;
			case 3:if(hp+addSpeed<=DataBase.CASTLE_HP_STG3){return true;}break;
			case 4:if(hp+addSpeed<=DataBase.CASTLE_HP_STG4){return true;}break;
			}
			break;
		case 0:
			switch(DataBase.pass){
			case 1:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG1){return true;}break;
			case 2:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG2){return true;}break;
			case 3:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG3){return true;}break;
			case 4:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG4){return true;}break;
			}
			break;
		}
		return false;
	}

}
