package units;

import dataBase.DataBase;

public class SpaceCarrier_ENM extends Soldier{
	public boolean NotRelease = true;
	public SpaceCarrier_ENM(){
		x = DataBase.START_LOC_X_ENM_STG3;
		y = DataBase.START_LOC_Y_ENM_STG3;
		hp=DataBase.SPACECARRIER_HP;
		attack = DataBase.SPACECARRIER_ATK;
		attackRange = DataBase.SPACECARRIER_AR;
		speed = DataBase.SPACECARRIER_SPD;
		setType(9);
	}
	public void attack(){}
	public void run(){
		while(true){
			if(this.getKind()==0){
				if(NotRelease&&this.caldistance(x, y, DataBase.START_LOC_X_STG3, DataBase.START_LOC_Y_STG3)<=100){
					this.Release();
				}
			}
			else{
				if(NotRelease&&this.caldistance(x, y, DataBase.START_LOC_X_ENM_STG3, DataBase.START_LOC_Y_ENM_STG3)<=100){
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
			SpaceMan_ENM s = new SpaceMan_ENM();
			s.setKind(this.getKind());
			s.setX(this.getX());
			s.setY(this.getY());
			if(this.getKind()==0){
				DataBase.enemyList.add(s);
			}else{
				DataBase.playerList.add(s);
			}
			Thread th = new Thread(s);
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
