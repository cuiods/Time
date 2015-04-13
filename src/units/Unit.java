package units;

public abstract class Unit {
	public int DB;  //用于引用数据
	public int P;   
	public int HP;
	public int ATK;
	public int AR;
	public abstract void move();  //用于变化x和y
	public abstract void attack();//用于攻击，减少攻击范围内敌方的生命值
	public abstract void detect();//用于检测攻击范围内的敌方
}
