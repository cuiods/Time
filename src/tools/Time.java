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
	int remainTime;
	public Time(long tl){
		timeLimit = tl;
		DataBase.StartTime = System.currentTimeMillis();
		Thread th = new Thread(this);
		th.start();
	}
	public int getRemainTime(){
		return this.remainTime;
	}
	public int updateRemainTime(){
		now = System.currentTimeMillis();
		timeleft = timeLimit-(now - DataBase.StartTime);
		return (int) (timeleft/1000);
	}
	@Override
	public void run() {
		this.remainTime = updateRemainTime();
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
