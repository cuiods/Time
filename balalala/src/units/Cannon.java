package units;

import dataBase.DataBase;

public class Cannon extends Soldier implements Runnable {
	 
		
		public Cannon(DataBase data){
			
			x=0;
			y=0;
			
		}
		
	
	@Override
	public void run() {
		
       move();
	}

	@Override
	public void move() {
		x+=db.CANNON_SPD;
		y+=db.CANNON_SPD;
	}
	
	//判断与自己最近的敌人是否在攻击范围内
	public boolean canAttack(){
		//取出距离自己最近的那个敌人
		Unit ce= db.enemyList.get(detect());
		int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
		if(distance>db.GUNNER_AR){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public void attack() {
		if(canAttack()){
			Unit ce = db.enemyList.get(detect());
			ce.hp-=db.GUNNER_ATK;
			if(ce.hp<=0){
				db.enemyList.remove(ce);
			}
		}
		
	}



}
