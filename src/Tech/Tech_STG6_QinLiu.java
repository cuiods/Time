package Tech;

import dataBase.DataBase;

public class Tech_STG6_QinLiu {
      public Tech_STG6_QinLiu(){
    	  DataBase.Tech_QINLIU = true;
    	  execute();
      }
      private void execute(){
    	  if(DataBase.enemyList!=null){
    		 
    		  DataBase.enemyList.removeAll(DataBase.enemyList); 
    	  }
    	
    	  if(DataBase.playerList!=null){
    		  DataBase.playerList.removeAll(DataBase.playerList); 
    	  }
      }
}
