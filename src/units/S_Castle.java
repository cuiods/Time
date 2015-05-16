package units;

import gamecontrol.Controller;

import java.io.Serializable;

import dataBase.DataBase;

public class S_Castle extends S_Unit implements Runnable, Serializable{
	public int addSpeed = 1;
	public S_Castle(){
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
//				synchronized (this) {
					if(Controller.gameframe.fightPanel!=null&&Controller.gameframe.fightPanel.win()==0){
						if(DataBase.playerList.size()>=2&&DataBase.playerList.get(0).getType() == 100&&DataBase.playerList.get(1).getType() == 100){
							 if(DataBase.playerList.get(0).hp>DataBase.playerList.get(1).hp){
							    DataBase.playerList.get(0).hp = DataBase.playerList.get(1).hp;
							  }else{
							    DataBase.playerList.get(1).hp = DataBase.playerList.get(0).hp;
							  }
						}
						if(DataBase.enemyList.size()>=2&&DataBase.enemyList.get(0).getType() == 100&&DataBase.enemyList.get(1).getType() == 100){
							if(DataBase.enemyList.get(0).hp>DataBase.enemyList.get(1).hp){
						    	DataBase.enemyList.get(0).hp = DataBase.enemyList.get(1).hp;
						    }else{
						    	DataBase.enemyList.get(1).hp = DataBase.enemyList.get(0).hp;
						    }
						}
					}
//				}
				break;
			case 5:
//				synchronized (this) {
					if(Controller.gameframe.fightPanel!=null&&Controller.gameframe.fightPanel.win()==0){
						int small1 = 1000000;
						int small2 = 1000000;
						if(DataBase.playerList.size()>=3&&DataBase.playerList.get(0).getType() == 100&&DataBase.playerList.get(1).getType() == 100&&DataBase.playerList.get(2).getType() == 100){
							if(DataBase.playerList.get(0).hp>DataBase.playerList.get(1).hp){
						    	small1 = DataBase.playerList.get(1).hp;
						    }else{
						    	small1 = DataBase.playerList.get(0).hp;
						    }
						    if(small1>DataBase.playerList.get(2).hp){
					    		small1 = DataBase.playerList.get(2).hp;
					    	}
						    DataBase.playerList.get(0).hp = DataBase.playerList.get(1).hp = DataBase.playerList.get(2).hp = small1;
						}
						if(DataBase.enemyList.size()>=3&&DataBase.enemyList.get(0).getType() == 100&&DataBase.enemyList.get(1).getType() == 100&&DataBase.enemyList.get(2).getType() == 100){
							if(DataBase.enemyList.get(0).hp>DataBase.enemyList.get(1).hp){
						    	small2 = DataBase.enemyList.get(1).hp;
						    }else{
						    	small2 = DataBase.enemyList.get(0).hp;
						    }
						    if(small1>DataBase.enemyList.get(2).hp){
					    		small2 = DataBase.enemyList.get(2).hp;
					    	}
						    DataBase.enemyList.get(0).hp = DataBase.enemyList.get(1).hp = DataBase.enemyList.get(2).hp = small2;
						}
				
					}
//				}
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
