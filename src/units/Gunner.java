package units;

import dataBase.DataBase;

public class Gunner extends Soldier implements Runnable {
	  // health point
		private int hp;
		// location
		private int x,y;
		private int speed;
		//attacking point
		private int atk;
		//attacking range
		private int ar;
		
		public Gunner(DataBase db){
			this.hp=db.GUNNER_HP;
			this.x=0;
			this.y=0;
			this.speed=db.GUNNER_SPD;
			this.atk=db.GUNNER_ATK;
			this.ar=db.GUNNER_AR;
		}
		
	   private int getX() {
			return x;
		}

		private void setX(int x) {
			this.x = x;
		}

		private int getY() {
			return y;
		}

		private void setY(int y) {
			this.y = y;
		}

	@Override
	public void run() {
		move();

	}

	@Override
	public void move() {
		x+=speed;
		y+=speed;
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detect() {
		// TODO Auto-generated method stub
		
	}

}
