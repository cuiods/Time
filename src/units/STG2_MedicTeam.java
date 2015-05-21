package units;

import dataBase.DataBase;

public class STG2_MedicTeam extends S_Soldier implements Runnable{
	public static int MedicTeam_Num = 0;
	public STG2_MedicTeam(){
		MedicTeam_Num++;
		x = DataBase.START_LOC_X_STG2;
		y = DataBase.START_LOC_Y_STG2;
	    hp=DataBase.MEDICTEAM_HP;
	    attack = DataBase.MEDICTEAM_ATK;
	    this.Upgrade();
		attackRange = DataBase.MEDICTEAM_AR;
		speed = DataBase.MEDICTEAM_SPD;
	    setType(3);
	}
	public void heal(){
		if(this.getKind()==0){
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit u = DataBase.enemyList.get(i);
			if(u.getType()!=100&&u.getHp()<getFullHP(u)){
			u.setHp((int) (u.getHp()+getFullHP(u)*DataBase.MEDICTEAM_HEAL*0.01));
			if(u.getHp()>getFullHP(u)){
				u.setHp(getFullHP(u));
			}
			}
		}
		}else{
			for(int i=0;i<DataBase.playerList.size();i++){
				S_Unit u = DataBase.playerList.get(i);
				if(u.getType()!=100&&u.getHp()<getFullHP(u)){
				u.setHp((int) (u.getHp()+getFullHP(u)*DataBase.MEDICTEAM_HEAL*0.01));
				if(u.getHp()>getFullHP(u)){
					u.setHp(getFullHP(u));
				}
				}
			}
		}
	}
	public int getFullHP(S_Unit u){
		switch(u.getType()){
		case 0:return DataBase.SWORDMAN_HP;
		case 1:return DataBase.GUNNER_HP;
		case 2:return DataBase.CANNON_HP;
		case 3:return DataBase.MEDICTEAM_HP;
		case 4:return DataBase.SNIPER_HP;
		case 5:return DataBase.TRUCK_HP;
		case 6:return DataBase.RIFLE_HP;
		default:return -1;
		}
	}
	public void run(){
		while(DataBase.threadContinue&&!isStop){
			if(hp<=0){
				isStop = true;
			}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		heal();
		}
	}
	public void attack(){}

}
