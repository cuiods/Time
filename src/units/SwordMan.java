package units;

import dataBase.DataBase;

public class SwordMan extends Soldier implements Runnable{
	//swordman's health point
	private int hp;
	// location
	private int x,y;
	private int speed;
	//attacking point
	private int atk;
	//attacking range
	private int ar;
	
	//initialization
	public SwordMan(DataBase db){
    	this.hp=db.SWORDMAN_HP;
    	this.x=0;
    	this.y=0;
    	this.speed=db.SWORDMAN_SPD;
    	this.atk=db.SWORDMAN_ATK;
    	this.ar=db.SWORDMAN_AR ;
    	
    }
	
	
	private int getX() {
		return x;
	}
	private void setX(int x) {
		this.x = x;
	}
	private int getY() {
		return y;
	}
	private void setY(int y) {
		this.y = y;
	}
	
    
    @Override
	public void move() {
		x+=speed;
		y+=speed;
		
	}

	@Override
	public void attack() {
		
		
	}

	@Override
	public void detect() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		move();
	
		
	}
     
}
