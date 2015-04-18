package ai;

import units.Unit;

public class simpleAI extends AI implements Runnable{
	@Override
	public void detect() {
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		execute(analyze());
		}
	}

	@Override
	public int analyze() {
		Threat = 0;
		int atk=0;
		for(Unit u :db.playerList){
			switch(u.getType()){
			case 0: atk=1; break;
			case 1: atk=3; break;
			case 2: atk=5; break;
			}
			Threat+=u.getHp()*atk;
		}
		for(Unit u:db.enemyList){
			switch(u.getType()){
			case 0: atk=1; break;
			case 1: atk=3; break;
			case 2: atk=5; break;
			}
			Threat-=u.getHp()*atk*1.1;
		} 
		System.out.println(Threat);
		return Threat;
	}

	public void execute(int Threat) {
		AIcommander AIC = new AIcommander();
		if(Threat>-30&&Threat<0&&Math.random()>0.98){
			AIC.addSwordMan();
			AIC.addGunner();
		}else if(Threat>0&&Threat<200&&Math.random()>0.4){
			AIC.addSwordMan();
		}else if(Threat>=200&&Threat<240&&Math.random()>0.3){
			AIC.addSwordMan();
			AIC.addSwordMan();
		}else if(Threat>=240&&Threat<450&&Math.random()>0.4){
			AIC.addSwordMan();
			AIC.addSwordMan();
			AIC.addGunner();
		}else if(Threat>=450&&Threat<900){
			AIC.addCannon();
		}
	}

	@Override
	public void run() {
		detect();
		
	}

}
