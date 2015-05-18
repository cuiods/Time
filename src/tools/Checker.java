package tools;

import units.S_Unit;
import dataBase.DataBase;

public class Checker implements Runnable{
	public void check(){
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getHp()<=0||outOfBoundCheck(ce)){
				DataBase.playerList.remove(ce);
			}
			
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit ce = DataBase.enemyList.get(i);
			if(ce.getHp()<=0||outOfBoundCheck(ce)){
				DataBase.enemyList.remove(ce);
			}
		}
	}
	public void run(){
		while(!DataBase.isPause){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		this.check();
		}
	}
	public boolean outOfBoundCheck(S_Unit ce){
		boolean result = false;
		if(ce.getX()<-200||ce.getX()>1200||ce.getY()<-200||ce.getY()>800){
			result = true;
		}
		return result;
	}
}
