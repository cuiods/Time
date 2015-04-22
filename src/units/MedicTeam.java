package units;

import dataBase.DataBase;

public class MedicTeam extends Soldier implements Runnable{
	public MedicTeam(){
		x = DataBase.START_LOC_X_STG1;
		y = DataBase.START_LOC_Y_STG1;
	    hp=DataBase.MEDICTEAM_HP;
	    setType(3);
	}
	public void heal(){
		if(this.getKind()==0){
		for(int i=0;i<DataBase.enemyList.size();i++){
			Unit u = DataBase.enemyList.get(i);
			u.setHp((int) (u.getHp()+u.getHp()*DataBase.MEDICTEAM_HEAL*0.01));
		}
		}
	}
	public void run(){
		while(true){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		heal();
		}
	}

}
