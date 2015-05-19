package units;

import tools.DrawUnits;
import dataBase.DataBase;

public class STG3_HydrogenBomb extends S_Soldier implements Runnable{
	public boolean notAttacked = true;
	//to bomb when attack
	public int time=1000;
	public int detectRange;
	public STG3_HydrogenBomb(){
		x = DataBase.START_LOC_X_STG3;
		y = DataBase.START_LOC_Y_STG3;
		hp=DataBase.HYDROGENBOMB_HP;
		attack = DataBase.HYDROGENBOMB_ATK;
		attackRange = DataBase.HYDROGENBOMB_AR;
		speed = DataBase.HYDROGENBOMB_SPD;
		detectRange = DataBase.HYDROGENBOMB_DR;
		setType(8);
	}
	@Override
	public int detect() {
		//to record the temporary minimum distance and its index
		int temp=0;			
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
				x+=DataBase.PATH_AGLX_STG1*spd;
				y+=DataBase.PATH_AGLY_STG1*spd;
			}
			else{
				x+=DataBase.PATH_AGLX_ENM*spd;
				y+=DataBase.PATH_AGLY_ENM*spd;
			}
			break;
		case 4:
			if(this.getKind()==1){
				x+=spd;
			}
			else{
				x+=spd;
			}
			break;
		}
	}

	//判断与自己最近的敌人是否在攻击范围内
	@Override
	public boolean canAttack(){
		int dr=0;
		dr = this.detectRange;
		//取出距离自己最近的那个敌人
		S_Unit ce;
		if(detect()!=-1){
			ce= DataBase.enemyList.get(detect());			
			int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
			if(distance>dr){
				return false;
			}else{
				return true;
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
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit ce = DataBase.enemyList.get(i);
			if(ce.hp>0&&this.hp>0&&caldistance(this.x,this.y,ce.x,ce.y)<=this.attackRange){
				if(ce.getType()!=100){
					ce.setHp(0);
					DataBase.enemyList.remove(ce);
				}
				else{
					if(DataBase.enemyList.size()==1)
						ce.setHp(ce.getHp()-200);
				}
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
	@Override
	public void run(){

		while(notAttacked&&DataBase.threadContinue){
			if(this.hp<=0){
				break;
			}
			if(canAttack()&&this.notAttacked){
				synchronized(this){
					this.moving = false;
					this.attacking = true;
					attack();
					this.notAttacked = false;
				}
			}else{
				synchronized(this){
					this.attacking = false;
					this.moving = true;
				}
				move();
			}
			//			System.out.println(notAttacked);
		}
		DataBase.enemyList.remove(this);
	}
}
