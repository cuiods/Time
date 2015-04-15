package units;

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
	

	//电脑的士兵代号为0 玩家的为1
	int kind;//原谅我英语不好想不出合适的词0.0
	
	//找到距离swordman最小的敌人的index
		public int detect() {

			//to record the temporary minimum distance and its index
			int temp=0;
			
			if(this.kind==1){
				//初始值为距离列表中第一个敌人的距离
				int minidistance= caldistance(this.x,db.enemyList.get(0).getX(),this.y,db.enemyList.get(0).getY());
				for(int i=0;i<db.enemyList.size();i++){
					Unit enemy=db.enemyList.get(i);
					int distance= caldistance(this.x,enemy.getX(),this.y,enemy.getY());
					//判断是否是当前最小距离
					if(distance<minidistance){
							minidistance=distance;
							temp=i;
					}
				}
			}else if(this.kind==0){
				int minidistance= caldistance(this.x,db.playerList.get(0).getX(),this.y,db.playerList.get(0).getY());
				for(int i=0;i<db.playerList.size();i++){
					Unit player=db.playerList.get(i);
					int distance= caldistance(this.x,player.getX(),this.y,player.getY());
					//判断是否是当前最小距离
					if(distance<minidistance){
							minidistance=distance;
							temp=i;
					}
				}
			}
			
			return temp;
		}
		
	
}
