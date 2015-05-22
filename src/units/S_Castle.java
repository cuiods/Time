package units;

import gamecontrol.Controller;

import java.io.Serializable;

import ai.AIMoney;
import dataBase.DataBase;

public class S_Castle extends S_Unit implements Runnable, Serializable{
	public int addSpeed = 1;
	boolean updateLV2 = false;
	boolean updateLV3 = false;
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
		case 11:hp=DataBase.CASTLE_HP_CLASSIC_LV1;break;
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
		while(DataBase.threadContinue){
			if(this.getKind()==0){
				if(AIMoney.AIPass==12&&!this.updateLV2){
					this.hp+=DataBase.CASTLE_HP_CLASSIC_LV2-DataBase.CASTLE_HP_CLASSIC_LV1;
					this.updateLV2 = true;
				}
				if(AIMoney.AIPass==13&&!this.updateLV3){
					this.hp+=DataBase.CASTLE_HP_CLASSIC_LV3-DataBase.CASTLE_HP_CLASSIC_LV2;
					this.updateLV3 = true;
				}
			}
			if(this.getKind()==1){
				//System.out.println("This is player castle");
				if(DataBase.pass==12&&!this.updateLV2){
					this.hp+=(DataBase.CASTLE_HP_CLASSIC_LV2-DataBase.CASTLE_HP_CLASSIC_LV1);
					this.updateLV2 = true;
					System.out.println("Upgrade LV2");
				}
				if(DataBase.pass==13&&!this.updateLV3){
					this.hp+=(DataBase.CASTLE_HP_CLASSIC_LV3-DataBase.CASTLE_HP_CLASSIC_LV2);
					this.updateLV3 = true;
					System.out.println("Upgrade LV3");
				}
			}
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
							for(int i = 0; i <3; i++){
								if(small1>=DataBase.enemyList.get(i).hp){
									small1 = DataBase.enemyList.get(i).hp;
								}
							}
							DataBase.playerList.get(0).hp =small1;
						    DataBase.playerList.get(1).hp =small1;
						    DataBase.playerList.get(2).hp =small1;
						}
						if(DataBase.enemyList.size()>=3&&DataBase.enemyList.get(0).getType() == 100&&DataBase.enemyList.get(1).getType() == 100&&DataBase.enemyList.get(2).getType() == 100){
							for(int i = 0; i < 3; i++){
								if(DataBase.enemyList.get(i).hp<=small2){
									small2 = DataBase.enemyList.get(i).hp;
								}
							}
						    DataBase.enemyList.get(0).hp =small2;
						    DataBase.enemyList.get(1).hp =small2;
						    DataBase.enemyList.get(2).hp =small2;
						}
				
					}
//				}
				break;
			case 11:
			case 12:
			case 13:
				if(Controller.gameframe.classicPanel!=null&&Controller.gameframe.classicPanel.win()==0){
					int small1 = 1000000;
					int small2 = 1000000;
					if(DataBase.playerList.size()>=3&&DataBase.playerList.get(0).getType() == 100&&DataBase.playerList.get(1).getType() == 100&&DataBase.playerList.get(2).getType() == 100){
						for(int i = 0; i <3; i++){
							if(small1>=DataBase.enemyList.get(i).hp){
								small1 = DataBase.enemyList.get(i).hp;
							}
						}
						DataBase.playerList.get(0).hp =small1;
					    DataBase.playerList.get(1).hp =small1;
					    DataBase.playerList.get(2).hp =small1;
					}
					if(DataBase.enemyList.size()>=3&&DataBase.enemyList.get(0).getType() == 100&&DataBase.enemyList.get(1).getType() == 100&&DataBase.enemyList.get(2).getType() == 100){
						for(int i = 0; i < 3; i++){
							if(DataBase.enemyList.get(i).hp<=small2){
								small2 = DataBase.enemyList.get(i).hp;
							}
						}
					    DataBase.enemyList.get(0).hp =small2;
					    DataBase.enemyList.get(1).hp =small2;
					    DataBase.enemyList.get(2).hp =small2;
					}
			
				}
//			}
			break;
			}
			try {
				Thread.sleep(1000);
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
			case 5:if(hp+addSpeed<=DataBase.CASTLE_HP_STG5){return true;}break;
			}
			break;
		case 0:
			switch(DataBase.pass){
			case 1:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG1){return true;}break;
			case 2:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG2){return true;}break;
			case 3:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG3){return true;}break;
			case 4:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG4){return true;}break;
			case 5:if(hp+addSpeed<=DataBase.CASTLE_HP_ENM_STG5){return true;}break;
			}
			break;
		}
		return false;
	}

}
