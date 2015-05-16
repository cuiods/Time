package Tech;

import units.S_Unit;
import dataBase.DataBase;

public class Tech_ENM_STG4_GeneMissile {
	public void execute(){
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getType()==getGene()){
				ce.setHp(0);
				DataBase.playerList.remove(ce);
			}
		}
	}
	public int getGene(){
		return (int) (Math.random()*4)+12;
	}
}
