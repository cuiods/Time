package units;

import dataBase.DataBase;

public class Truck extends Soldier{
	public Truck(){
		x = DataBase.START_LOC_X_STG1;
		y = DataBase.START_LOC_Y_STG1;
	    hp=DataBase.TRUCK_HP;
	    setType(5);
	}
	public void attack(){}
	public void run(){
		while(true){
			if(this.hp<=5&&this.hp>=0){
				SwordMan s = new SwordMan();
				s.setKind(this.getKind());
				Thread th = new Thread(s);
				th.start();
				if(this.getKind()==0){
				db.enemyList.add(s);
				}else{
					db.playerList.add(s);
				}
			}else if(this.hp<0){}
			else{
				move();
			}
		}
	}
}

