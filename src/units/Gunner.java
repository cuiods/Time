package units;

import dataBase.DataBase;

public class Gunner extends Soldier implements Runnable {

		
		public Gunner(){
		
			this.x=0;
			this.y=0;
		    hp=db.GUNNER_HP;
		    setType(1);
		}
		
	  

	@Override
	public void run() {
<<<<<<< HEAD
		while(true){
			if(canAttack()){
				attack();
			}else{
				move();
			}
=======
		if(this.hp>0){
			move();
>>>>>>> origin/master
		}
	}

	@Override
	public void move() {
<<<<<<< HEAD
	    	try {
=======
		while(true){
    		try {
>>>>>>> origin/master
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		x+=db.GUNNER_SPD;
    		y+=db.GUNNER_SPD;
<<<<<<< HEAD
=======
		}
		
>>>>>>> origin/master
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
		if(distance>db.GUNNER_AR){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public void attack() {
<<<<<<< HEAD

		//取出可以攻打的对象
		Unit ce;
		if(this.kind==1){
			ce = db.enemyList.get(detect());
			if(ce.hp>0){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ce.hp-=db.GUNNER_ATK;
			}else{
=======
		if(canAttack()){
			//取出可以攻打的对象
			Unit ce;
			if(this.kind==1){
				ce = db.enemyList.get(detect());
			}else{
				ce=db.playerList.get(detect());
			}
			ce.hp-=db.GUNNER_ATK;
			if(ce.hp<=0){
>>>>>>> origin/master
				db.enemyList.remove(ce);
			}
		}else{
			ce=db.playerList.get(detect());
			if(ce.hp>0){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ce.hp-=db.GUNNER_ATK;
			}else{
				db.playerList.remove(ce);
			}
		}
		
		
	}





	
	

}
