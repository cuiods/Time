package units;

import dataBase.DataBase;

public abstract class S_Soldier extends S_Unit{
	public boolean attacking = false;
	public boolean moving = false;
	public boolean isStop = false;
	 
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
							synchronized (this) {
								S_Unit enemy=DataBase.enemyList.get(i);
								int distance= caldistance(this.x,enemy.getX(),this.y,enemy.getY());
								//判断是否是当前最小距离
								if(distance<minidistance){
									minidistance=distance;
									temp=i;
								}
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
							S_Unit player=DataBase.playerList.get(i);
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
		@Override
		public void run() {
			while(DataBase.threadContinue){
//				if(DataBase.pass!=this.getStageOfSoldier(this)){
//					if(!(DataBase.pass==5&&this.getStageOfSoldier(this)==4)){
//						break;
//					}
//				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if(this.hp<=0){
					break;
					}
					if(canAttack()){
						synchronized(this){
						this.moving = false;
						this.attacking = true;
						}
						attack();
						
					}else{
						synchronized(this){
						this.attacking = false;
						this.moving = true;
						}
						move();
					}
			}
		}

		@Override
		public void move() {
			int spd=0;
			if(!DataBase.isPause){
				spd = this.speed;
			}

		    	try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	switch(DataBase.pass){
	    		case 1:
	    			if(this.getKind()==1){
			    		x+=DataBase.PATH_AGLX_STG1*spd;
			    		y+=DataBase.PATH_AGLY_STG1*spd;
			    		}
			    		else{
			    			x+=DataBase.PATH_AGLX_ENM*spd;
			        		y+=DataBase.PATH_AGLY_ENM*spd;
			    		}
	    			break;
	    		case 2:
	    			if(this.getKind()==1){
			    		x+=spd;
			    		y=(int) (0.0000007*x*x*x-0.001*x*x+0.1566*x+399.32);
			    	}else{
			    		x-=spd;
			        	y=(int) (0.0000007*x*x*x-0.001*x*x+0.1566*x+399.32);
			    	}
		    		break;
	    		case 3:
	    			if(this.getKind()==1){
	    				if(DataBase.Tech_Harper_TIME==0){
		    				if(x<=270){
		    					x+=DataBase.PATH_AGLX_STG1*spd;
					    		y+=DataBase.PATH_AGLY_STG1*spd;
					    	}
		    			}else if(DataBase.Tech_Harper_TIME==1){
		    				if(x<=600){
		    					x+=DataBase.PATH_AGLX_STG1*spd;
					    		y+=DataBase.PATH_AGLY_STG1*spd;
		    				}
		    			}else{
		    				x+=DataBase.PATH_AGLX_STG1*spd;
				    		y+=DataBase.PATH_AGLY_STG1*spd;
		    			}
	    			}else{
			    		x+=DataBase.PATH_AGLX_ENM*spd;
			        	y+=DataBase.PATH_AGLY_ENM*spd;
			    	}
	    			break;
	    		case 6:
	    			if(this.getKind()==1){
			    		x+=spd;
			    		}
			    		else{
			    			x-=spd;
			    	}break;
			    default:
	    			if(this.getKind()==1){
			    		x+=spd;
			    		}
			    		else{
			    			x-=spd;
			    		}
	    			break;
	    		}
		}
					
		//判断与自己最近的敌人是否在攻击范围内
		public boolean canAttack(){
			int ar=0;
			ar = this.attackRange;
			//取出距离自己最近的那个敌人
			S_Unit ce;
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
					if((DataBase.playerList.contains(this)||DataBase.enemyList.contains(this))&&ce.getType()!=102){
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
			if(!DataBase.isPause){
				atk = this.attack;
			}
			//取出可以攻打的对象
			S_Unit ce;
			if(this.getKind()==1){
				ce = DataBase.enemyList.get(detect());
				if(ce.hp>0&&this.hp>0){
					try {
						if(this.getType()==4){
							Thread.sleep(1000);
						}
						else
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
						if(this.getType()==4){
							Thread.sleep(1000);
						}
						else
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
		public int getStageOfSoldier(S_Unit ce){
			switch(ce.getType()){
			case 0: 
			case 1:
			case 2: return 1;
			case 3:
			case 4:
			case 5:
			case 6: return 2;
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:return 3;
			case 12:
			case 13:
			case 14:
			case 15:return 4;
			default : return -1;
			
			}
		}
		
	
}
