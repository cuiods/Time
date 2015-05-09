package units;

import dataBase.DataBase;

public class Truck extends Soldier{
	public boolean NotRelease = true;
	public Truck(){
		x = DataBase.START_LOC_X_STG2;
		y = DataBase.START_LOC_Y_STG2;
	    hp=DataBase.TRUCK_HP;
	    setType(5);
	}
	public void attack(){}
	public void run(){
		while(true){
			if(this.getKind()==0){
				if(NotRelease&&this.caldistance(x, y, DataBase.START_LOC_X_STG2, DataBase.START_LOC_Y_STG2)<=100){
					this.Release();
				}
			}
			else{
				if(NotRelease&&this.caldistance(x, y, DataBase.START_LOC_X_ENM_STG2, DataBase.START_LOC_Y_ENM_STG2)<=100){
					this.Release();
				}
			}
			if(this.hp<=5&&this.hp>=0&&NotRelease){
				this.Release();
			}else if(this.hp<0&&NotRelease){
				this.Release();
			}
			else{
				move();
			}
		}
	}
	public void Release(){
		for(int i=0;i<=1;i++){
			Rifle r = new Rifle();
			r.setKind(this.getKind());
			r.setX(this.getX());
			r.setY(this.getY());
			if(this.getKind()==0){
				DataBase.enemyList.add(r);
				}else{
					DataBase.playerList.add(r);
				}
			Thread th = new Thread(r);
			th.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		this.NotRelease = false;
	}
}

