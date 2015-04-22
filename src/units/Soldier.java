package units;

import dataBase.DataBase;

public abstract class Soldier extends Unit{
	/*
	 必须在继承soldier的类中新建构造函数
	 且构造函数必须包含以下内容：
	1. 构造函数必须要有一个参数为DataBase data，然后把它赋值给类的参数DB，方便引用
	2.将实例变量按照Database里的相应值初始化
	3. 构造出来对象以后必须按照阵营添加到相应的arraylist中方便
	
	 */
	
	
	/*
	 单位设为SwordMan(步兵)，GUNNER(火枪手)，CANNON(火炮)三种;每个相应的参数值都已经在database类中写好。
	 */
	

	//找到距离swordman最小的敌人的index
		public int detect() {

			//to record the temporary minimum distance and its index
			int temp=0;			
			if(this.getKind()==1){
				if(DataBase.enemyList.size()!=0){
					//初始值为距离列表中第一个敌人的距离
					int minidistance= caldistance(this.x,DataBase.enemyList.get(0).getX(),
							this.y,DataBase.enemyList.get(0).getY());
					for(int i=0;i<DataBase.enemyList.size();i++){
						Unit enemy=DataBase.enemyList.get(i);
						int distance= caldistance(this.x,enemy.getX(),this.y,enemy.getY());
						//判断是否是当前最小距离
						if(distance<minidistance){
								minidistance=distance;
								temp=i;
						}
					}
					return temp;
				}else{
					return -1;
				}
			}else{
					if(DataBase.playerList.size()!=0){
						int minidistance= caldistance(this.x,DataBase.playerList.get(0).getX(),this.y,DataBase.playerList.get(0).getY());
						for(int i=0;i<DataBase.playerList.size();i++){
							Unit player=DataBase.playerList.get(i);
							int distance= caldistance(this.x,player.getX(),this.y,player.getY());
							//判断是否是当前最小距离
							if(distance<minidistance){
								minidistance=distance;
								temp=i;
							}
						}
						return temp;
					}else{
						return -1;
					}
				}
		}
		public void run() {
			while(true){
				if(this.hp<=0){
				//	this.die();
				}
				if(canAttack()){
					attack();
					
				}else{
					move();
				}
			}
		}

		@Override
		public void move() {
			int spd=0;
			switch(this.getType()){
			case 0:spd = DataBase.SWORDMAN_SPD;break;
			case 1:spd = DataBase.GUNNER_SPD;break;
			case 2:spd = DataBase.CANNON_SPD;break;
			case 3:spd = DataBase.MEDICTEAM__SPD;break;
			}

		    	try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(this.getKind()==1){
		    		x+=DataBase.PATH_AGLX_STG1*spd;
		    		y+=DataBase.PATH_AGLY_STG1*spd;
		    		}
		    		else{
		    			x+=DataBase.PATH_AGLX_ENM*spd;
		        		y+=DataBase.PATH_AGLY_ENM*spd;
		    		}
		}
			
		
		
		//判断与自己最近的敌人是否在攻击范围内
		public boolean canAttack(){
			int ar=0;
			switch(this.getType()){
			case 0:ar = DataBase.SWORDMAN_AR;break;
			case 1:ar = DataBase.GUNNER_AR;break;
			case 2:ar = DataBase.CANNON_AR;break;
			case 3:ar = DataBase.MEDICTEAM__AR;break;
			}
			//取出距离自己最近的那个敌人
			Unit ce;
			if(detect()!=-1){
				if(this.getKind()==1){
					 ce= DataBase.enemyList.get(detect());
				}else{
					 ce=DataBase.playerList.get(detect());
				}
				int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
				if(distance>ar){
					return false;
				}else{
					if(DataBase.playerList.contains(this)||DataBase.enemyList.contains(this)){
						return true;}
						else return false;
				}
			}else{
				return false;
			}
		}
		@Override
		public void attack() {
			int atk=0;
			switch(this.getType()){
			case 0:atk = DataBase.SWORDMAN_ATK;break;
			case 1:atk = DataBase.GUNNER_ATK;break;
			case 2:atk = DataBase.CANNON_ATK;break;
			}
			//取出可以攻打的对象
			Unit ce;
			if(this.getKind()==1){
				ce = DataBase.enemyList.get(detect());
				if(ce.hp>0&&this.hp>0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ce.hp-=atk;
				}else{
					if(ce.hp<=0)
					DataBase.enemyList.remove(ce);
					if(this.hp<=0)
						DataBase.playerList.remove(this);
				}
			}else{
				ce=DataBase.playerList.get(detect());
				if(ce.hp>0&&this.hp>0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ce.hp-=atk;
				}else{
					if(ce.hp<=0)
					DataBase.playerList.remove(ce);
					if(this.hp<=0)
						DataBase.enemyList.remove(this);
				}
			}
			
			
		}
		public void die(){			
				if(this.getKind()==0){
					try{
					DataBase.enemyList.remove(DataBase.enemyList.indexOf(this));
					}catch(java.lang.ArrayIndexOutOfBoundsException ex){
						
					}
				}
				else{
					try{
					DataBase.playerList.remove(DataBase.playerList.indexOf(this));
                    }catch(java.lang.ArrayIndexOutOfBoundsException ex){
						
					}
				}
		}
		
	
}
