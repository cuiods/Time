package Tech;

import ai.AIMoney;
import tools.Time;
import units.S_Unit;
import dataBase.DataBase;
//treat the tech as a thread because i want to draw the information....forgive me
public class Tech_ENM_STG4_KillerVirus implements Runnable{
	public void execute(){
		AIMoney.Money -= DataBase.TECH_KILLERVIRUS_P;
		DataBase.virus=true;
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getType()!=100&&ce.getType()!=101&&(!ce.invisible)){
				ce.setHp((int) (ce.getHp()*0.6));
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
			DataBase.virus = false;
		}
		
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}


}
