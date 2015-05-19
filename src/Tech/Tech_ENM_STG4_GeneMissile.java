package Tech;

import tools.Time;
import units.S_Unit;
import dataBase.DataBase;
//treat the tech as a thread because i want to draw the information....forgive me
public class Tech_ENM_STG4_GeneMissile implements Runnable {
	
	public void execute(){
		DataBase.GeneMissile=true;
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getType()==getGene()){
				ce.setHp(0);
				DataBase.playerList.remove(ce);
			}
		}
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getType()==getGene()){
				ce.setHp(0);
				DataBase.playerList.remove(ce);
			}
		}
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getType()==getGene()){
				ce.setHp(0);
				DataBase.playerList.remove(ce);
			}
		}
		Time t = new Time(2000);
		   while(t.getRemainTime()>=0&&DataBase.threadContinue){
			   try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		   }
		   DataBase.GeneMissile=false;
	}
	 
	public int getGene(){
		return (int) (Math.random()*4)+12;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}
}
