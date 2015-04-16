package dataBase;

import java.util.ArrayList;

import units.Unit;

public class DataBase {
	public static ArrayList<Unit> enemyList = new ArrayList<Unit>();
	public static ArrayList<Unit> playerList = new ArrayList<Unit>();
	//Parameters for stage1
	public static final int CASTLE_HP_STG1 = 300;//我方城堡的生命值
	public static final int START_LOC_X_STG1 = 0;//设置第一关的出发位置
	public static final int START_LOC_Y_STG1 = 550;
	public static final int PATH_AGL_STG1 = -1;//设置第一关路径的斜率
	//General parameters for the game
	public static int Money = 2000; //记录玩家当前的金钱数
	public static int Castle_HP; //记录玩家当前城堡的生命值，要根据关的不同初始化不同的值
	public static boolean Tech_1 = false;//各个可能出现的科技，先用12345替代
	public static boolean Tech_2 = false;
	public static boolean Tech_3 = false;
	public static boolean Tech_4 = false;
	public static boolean Tech_5 = false;
	
	
	public static final int SWORDMAN_P = 100;//the price of swordman
	public static final int SWORDMAN_HP = 10;//The health point of swordman
	public static final int SWORDMAN_ATK = 1;//the attacking point of swordman
	public static final int SWORDMAN_AR = 10;//攻击范围 attacking range
	public static final int SWORDMAN_SPD = 4;//speed
	
	public static final int GUNNER_P = 300;
	public static final int GUNNER_HP = 7;
	public static final int GUNNER_ATK = 3;
	public static final int GUNNER_AR = 50;
	public static final int GUNNER_SPD = 3;
	
	public static final int CANNON_P = 1000;
	public static final int CANNON_HP = 15;
	public static final int CANNON_ATK = 5;
	public static final int CANNON_AR = 80;
	public static final int CANNON_SPD = 1;
}
