package dataBase;

import java.util.ArrayList;

import units.Unit;

public class DataBase {
	public static ArrayList<Unit> enemyList = new ArrayList<Unit>();
	public static ArrayList<Unit> playerList = new ArrayList<Unit>();
	
	public static final int CASTLE_HP_STG1 = 300;//我方城堡的生命值
	
	public static final int SWORDMAN_P = 100;//the price of swordman
	public static final int SWORDMAN_HP = 10;//The health point of swordman
	public static final int SWORDMAN_ATK = 1;//the attacking point of swordman
	public static final int SWORDMAN_AR = 10;//攻击范围 attacking range
	public static final int SWORDMAN_SPD = 20;//speed
	
	public static final int GUNNER_P = 300;
	public static final int GUNNER_HP = 7;
	public static final int GUNNER_ATK = 3;
	public static final int GUNNER_AR = 50;
	public static final int GUNNER_SPD = 15;
	
	public static final int CANNON_P = 1000;
	public static final int CANNON_HP = 15;
	public static final int CANNON_ATK = 5;
	public static final int CANNON_AR = 80;
	public static final int CANNON_SPD = 5;
}
