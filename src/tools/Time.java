package tools;

import dataBase.DataBase;

public class Time implements Runnable{
	/*
	 * by @niansong
	 */
	/*
	 * 创建对象开始计时，getremaintime方法获取开始计时到现在还有多长时间
	 * 倒计时设为10min
	 */
	long now;
	long timeleft;
	long timeLimit;
	public Time(long tl){
		timeLimit = tl;
		DataBase.StartTime = System.currentTimeMillis();
		Thread th = new Thread(this);
		th.start();
	}
	public int getRemainTime(){
		now = System.currentTimeMillis();
		timeleft = timeLimit-(now - DataBase.StartTime);
		return (int) (timeleft/1000);
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
	}
}
