package dataBase;

import java.util.ArrayList;

import units.Unit;

public class DataBase {
	//记录已到关卡数和当前游戏关卡数
	public static int pass = 0;
	public static int passAlready = 6;

	//记录是否暂停
	public static boolean isPause = false;

	//记录所有单位信息
	public static ArrayList<Unit> enemyList = new ArrayList<Unit>();
	public static ArrayList<Unit> playerList = new ArrayList<Unit>();

	//Parameters for stage1
	public static final int INITIAL_MONEY_STG1 = 200000;
	public static final int INITIAL_MONEY_INCREMENT_STG1 = 2;
	public static final int CASTLE_HP_STG1 = 3000;//我方城堡的生命值
	public static final int START_LOC_X_STG1 = 50;//设置第一关的出发位置
	public static final int START_LOC_Y_STG1 = 500;
	public static final int PATH_AGLX_STG1 = 2;//设置第一关路径的斜率
	public static final int PATH_AGLY_STG1 = -1;

	public static final int CASTLE_HP_ENM_STG1 = 2000;//敌方城堡的生命值
	public static final int START_LOC_X_ENM_STG1 = 950;//设置第一关敌人的出发位置
	public static final int START_LOC_Y_ENM_STG1 = 50;
	public static final int PATH_AGLX_ENM = -2;//设置第一关敌人路径的斜率
	public static final int PATH_AGLY_ENM = 1;

	//Parameters for stage2
	public static long StartTime = 0;
	public static final int INITIAL_MONEY_STG2 = 100000;
	public static final int INITIAL_MONEY_INCREMENT_STG2 = 5;
	public static final int CASTLE_HP_STG2 = 500;
	public static final int START_LOC_X_STG2 = 0;//设置第二关的出发位置
	public static final int START_LOC_Y_STG2 = 400;

	public static final int CASTLE_HP_ENM_STG2 = 1000;
	public static final int START_LOC_X_ENM_STG2 = 990;//设置第二关敌人的出发位置
	public static final int START_LOC_Y_ENM_STG2 = 180;
	public static final int TIMELIMIT_STG2 = 1000*60*10;

	//Parameters for stage3
	public static final int INITIAL_MONEY_STG3 = 100000;
	public static final int INITIAL_MONEY_INCREMENT_STG3 = 8;
	public static final int CASTLE_HP_STG3 = 2000;
	public static final int START_LOC_X_STG3 = 50;
	public static final int START_LOC_Y_STG3 = 500;
	public static final int SECONDCASTLE_LOC_X_STG3 = 150;
	public static final int SECONDCASTLE_LOC_Y_STG3 = 450;

	public static final int CASTLE_HP_ENM_STG3 = 1000;
	public static final int START_LOC_X_ENM_STG3 = 950;
	public static final int START_LOC_Y_ENM_STG3 = 50;
	
	//Parameters for stage4
	public static final int INITIAL_MONEY_STG4 = 100000;
	public static final int INITIAL_MONEY_INCREMENT_STG4 = 8;
	public static final int CASTLE_HP_STG4 = 2000;
	public static final int START_LOC_X_STG4 = 50;
	public static final int START_LOC_Y_STG4 = 500;
	public static final int BLACKHOLE_LOC_X_STG4 = 150;
	public static final int BLACKHOLE_LOC_Y_STG4 = 450;
	public static final int BLACKHOLE_TIMELIMIT = 20;

	public static final int CASTLE_HP_ENM_STG4 = 1000;
	public static final int START_LOC_X_ENM_STG4 = 950;
	public static final int START_LOC_Y_ENM_STG4 = 50;
	//General parameters for the game
	public static int Money = 200000; //记录玩家当前的金钱数
	public static int Money_Increment = 2;
	public static int Castle_HP_ply; //记录玩家当前城堡的生命值，要根据关的不同初始化不同的值
	public static int Castle_HP_enm;
	//Tech for stage1
	public static boolean Tech_CannonEnable = false;//各个可能出现的科技，先用12345替代
	public static boolean Tech_MoneyBoom = false;
	public static boolean Tech_Destroy = false;
	//Tech for stage2
	public static boolean Tech_MedicEnable = false;
	public static boolean Tech_TruckReinforce = false;
	public static boolean Tech_LessTime = false;
	public static boolean Tech_Heal = false;
	public static boolean Tech_CastleReinforce = false;
	//Tech for stage3
	public static boolean Tech_SecondCastle = false;
	public static boolean Tech_Harper = false;
	public static boolean Tech_SuperComputer = false;
	public static boolean Tech_HydrogenBomb = false;
	//Tech for stage4
	public static boolean Tech_Faith = false;
	public static boolean Tech_FourthTechRevolution = false;
	public static boolean Tech_BlackHoleProject = false;
	//Tech for stage5
	public static boolean Tech_CoverProject = false;
	public static boolean Tech_HaltScience = false;
	public static boolean Tech_Escape = false;

    //Price of Technologies
	public static final int Tech_CannonEnable_P = 1000;//效果：能造cannon了
	public static final int Tech_MoneyBoom_P = 2500;//效果：让金钱增长速度变成1.5倍
	public static final int Tech_Destroy_P = 500;//效果：随机摧毁敌人80%的单位
	public static final int Tech_MedicEnable_p = 1000;
	public static final int Tech_TruckReinforce_P = 1200;
	public static final int Tech_LessTime_P = 2000;
	public static final int Tech_Heal_P = 500;
	public static final int Tech_CastleReinforce_P = 900;
	public static final int Tech_SecondCastle_P = 4000;
	public static final int Tech_Harper_P = 2000;
	public static final int Tech_SuperComputer_P = 2500;
	public static final int Tech_HydrogenBomb_P = 3000;
	/*
	 * Units for stage1
	 */
	public static final int SWORDMAN_P = 100;//the price of swordman
	public static final int SWORDMAN_HP = 50;//The health point of swordman
	public static final int SWORDMAN_ATK = 1;//the attacking point of swordman
	public static final int SWORDMAN_AR = 60;//攻击范围 attacking range
	public static final int SWORDMAN_SPD = 4;//speed

	public static final int GUNNER_P = 300;
	public static final int GUNNER_HP = 21;
	public static final int GUNNER_ATK = 3;
	public static final int GUNNER_AR = 120;
	public static final int GUNNER_SPD = 3;

	public static final int CANNON_P = 1000;
	public static final int CANNON_HP = 50;
	public static final int CANNON_ATK = 5;
	public static final int CANNON_AR = 180;
	public static final int CANNON_SPD = 1;

	/*
	 * Units for stage2
	 */
	public static final int MEDICTEAM_P = 200;
	public static final int MEDICTEAM_HP = 10;
	public static final int MEDICTEAM_ATK = 0;
	public static final int MEDICTEAM_AR = 0;
	public static final int MEDICTEAM_SPD = 0;
	public static final int MEDICTEAM_HEAL = 10;

	public static final int SNIPER_P = 500;
	public static final int SNIPER_HP = 20;
	public static final int SNIPER_ATK = 20;
	public static final int SNIPER_AR = 500;
	public static final int SNIPER_SPD = 0;

	public static final int TRUCK_P = 400;
	public static final int TRUCK_HP = 100;
	public static final int TRUCK_ATK = 0;
	public static final int TRUCK_AR = 0;
	public static final int TRUCK_SPD = 4;

	public static final int RIFLE_P = 100;
	public static final int RIFLE_HP = 50;
	public static final int RIFLE_ATK = 1;
	public static final int RIFLE_AR = 60;
	public static final int RIFLE_SPD = 4;

	/*
	 * Units for stage3
	 */
	public static final int SECONDCASTLE_P = 0;
	public static final int SECONDCASTLE_HP = 1000;
	public static final int SECONDCASTLE_ATK = 2;
	public static final int SECONDCASTLE_AR = 50;
	public static final int SECONDCASTLE_SPD = 0;
	
	public static final int HYDROGENBOMB_P = 800;
	public static final int HYDROGENBOMB_HP = 1000;
	public static final int HYDROGENBOMB_ATK = 200;
	public static final int HYDROGENBOMB_AR = 300;
	public static final int HYDROGENBOMB_SPD = 20;
	
	public static final int SPACEMAN_P = 500;
	public static final int SPACEMAN_HP = 50;
	public static final int SPACEMAN_ATK = 1;
	public static final int SPACEMAN_AR = 60;
	public static final int SPACEMAN_SPD = 4;
	
	public static final int SPACECARRIER_P = 3000;
	public static final int SPACECARRIER_HP = 300;
	public static final int SPACECARRIER_ATK = 2;
	public static final int SPACECARRIER_AR = 60;
	public static final int SPACECARRIER_SPD = 4;
	
	public static final int SPACESHIP_P = 1000;
	public static final int SPACESHIP_HP = 21;
	public static final int SPACESHIP_ATK = 3;
	public static final int SPACESHIP_AR = 120;
	public static final int SPACESHIP_SPD = 3;
	
	public static void recover(){
		enemyList.removeAll(enemyList);
		playerList.removeAll(playerList);
		switch(pass){
		case 1: Money = INITIAL_MONEY_STG1;
		Money_Increment = INITIAL_MONEY_INCREMENT_STG1;break;
		case 2:Money = INITIAL_MONEY_STG2;
		Money_Increment = INITIAL_MONEY_INCREMENT_STG2;break;
		case 3:break;
		case 4:break;
		}

		Tech_CannonEnable = false;
		Tech_MoneyBoom = false;
		Tech_Destroy = false;
		Tech_MedicEnable = false;
		Tech_TruckReinforce = false;
		Tech_LessTime = false;
		Tech_Heal = false;
		Tech_CastleReinforce = false;
	}
}
