package Tech;

import dataBase.DataBase;

public class Tech_STG6_Ren {
	public Tech_STG6_Ren(){
		DataBase.Tech_REN=true;
		execute();
	}
	private void execute(){
		for(int i=0;i<DataBase.enemyList.size();i++){
			if(DataBase.enemyList.get(i).getType()!=100){
				DataBase.enemyList.get(i).setHp((int) (DataBase.enemyList.get(i).getHp()*0.8));
			}
		}
	}
}
