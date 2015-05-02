package tools;

import dataBase.DataBase;

public class Time {
	/*
	 * by @niansong
	 */
	/*
	 * 创建对象开始计时，getremaintime方法获取开始计时到现在还有多长时间
	 * 倒计时设为10min
	 */
	long start;
	long now;
	long timeleft;
	long timeLimit = DataBase.TIMELIMIT_STG2;
	public Time(){
		start = System.currentTimeMillis();
	}
	public int getRemainTime(){
		now = System.currentTimeMillis();
		timeleft = timeLimit-(now - start);
		return (int) (timeleft/1000);
	}
}
