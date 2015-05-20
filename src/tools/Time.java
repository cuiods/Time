package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		if(DataBase.pass==2){
			if(DataBase.StartTime == 0){
				DataBase.StartTime = System.currentTimeMillis();
			}
		}else{
			DataBase.StartTime = System.currentTimeMillis();
		}
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
	
	public static String getTimeNow(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
		return format.format(new Date());
	}
	
	@Override
	public void run() {
		while(DataBase.threadContinue){
			this.remainTime = updateRemainTime();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
