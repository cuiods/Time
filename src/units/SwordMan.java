package units;

import dataBase.DataBase;

public class SwordMan extends Soldier implements Runnable{


	
	//initialization
	public SwordMan(DataBase data){
    	x=0;
    	y=0;
    	hp=db.SWORDMAN_HP;
    	
    }
	
	
	
	
    
    @Override
	public void move() {
		x+=db.SWORDMAN_SPD;
		y+=db.SWORDMAN_SPD;
		
	}

	//判断与自己最近的敌人是否在攻击范围内
	public boolean canAttack(){
		//取出距离自己最近的那个敌人
		Unit ce= db.enemyList.get(detect());
		int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
		if(distance>db.SWORDMAN_AR){
			return false;
		}else{
			return true;
		}
	}
	
public void attack() {
	if(canAttack()){
		Unit ce = db.enemyList.get(detect());
		ce.hp-=db.SWORDMAN_ATK;
		if(ce.hp<=0){
			db.enemyList.remove(ce);
		}
	}
		
	}
	@Override
	public void run() {
		move();
	
		
	}
     
}
