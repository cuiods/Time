package units;

import java.io.Serializable;

import dataBase.DataBase;

public abstract class Unit implements Serializable, Runnable{
	protected DataBase db;  //用于引用数据
	protected int x = 0;
	protected int y = 0;
	//士兵的种类（步兵0，火枪手1，火炮2,城堡100）
	private int type;
	//电脑的士兵代号为0 玩家的为1
	private int kind;//原谅我英语不好想不出合适的词0.0
		
	protected int hp;//health point
	
	public int ran = (int) (Math.random()*50);
	
	public abstract void move();  //用于变化x和y
	public abstract void attack();//用于攻击，减少攻击范围内敌方的生命值
	public abstract int detect();//返回距离自己最近的敌人的序号
	public abstract boolean canAttack();//用于检测距离自己最近的敌人是否在自己攻击范围内
	public int caldistance(int x1,int x2,int y1,int y2){
		
		return (int) Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getHp(){
		return hp;
	}
	public void setHp(int hp){
		this.hp = hp;
	}
	public abstract void run();
	
	
}
