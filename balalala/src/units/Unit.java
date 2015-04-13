package units;

import dataBase.DataBase;

public abstract class Unit {
	
	protected int x;
	protected int y;
	protected DataBase db;  //用于引用数据
	

	protected int price;   
	protected int hp;//health point
	protected int atk;//attacking point
	protected int ar;//attacking range
	public abstract void move();  //用于变化x和y
	public abstract void attack();//用于攻击，减少攻击范围内敌方的生命值
	public abstract int detect();//返回距离自己最近的敌人的序号
	public abstract boolean canAttack();//用于检测距离自己最近的敌人是否在自己攻击范围内
	public int caldistance(int x1,int x2,int y1,int y2){
		
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
