package units;

import dataBase.DataBase;

public class SwordMan extends Soldier implements Runnable{


	
	//initialization
	public SwordMan(){
    	this.x=0;
    	this.y=0;
    	hp=db.SWORDMAN_HP;
    	setType(0);
    }
	
	
	
	
    
    @Override
	public void move()  {
    	while(true){
    		try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		x+=db.SWORDMAN_SPD;
    		y+=db.SWORDMAN_SPD;
    		
    	}
		
		
	}

	//判断与自己最近的敌人是否在攻击范围内
	public boolean canAttack(){
		//取出距离自己最近的那个敌人
		Unit ce;
		if(this.kind==1){
			 ce= db.enemyList.get(detect());
		}else{
			 ce=db.playerList.get(detect());
		}
		int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
		if(distance>db.SWORDMAN_AR){
			return false;
		}else{
			return true;
		}
	}
	
public void attack() {
	if(canAttack()){
		//取出可以攻打的对象
		Unit ce;
		if(this.kind==1){
			ce = db.enemyList.get(detect());
		}else{
			ce=db.playerList.get(detect());
		}
		ce.hp-=db.SWORDMAN_ATK;
		if(ce.hp<=0){
			db.enemyList.remove(ce);
		}
	}
		
	}
	@Override
	public void run() {
		if(this.hp>0){
			move();
			while(true){
				int i = this.detect();
				System.out.println(i);
				canAttack();
				attack();
			}
		}
		
	}
     
}
