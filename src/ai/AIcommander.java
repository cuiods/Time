package ai;

import units.*;
import dataBase.DataBase;

public class AIcommander {
	DataBase db = new DataBase();
	public void addSwordMan(){
		SwordMan s = new SwordMan();
		s.setKind(0);
	    setLoc(s);
		Thread th = new Thread(s);
		th.start();
		db.enemyList.add(s);
	}
	public void addGunner(){
		Gunner g = new Gunner();
		g.setKind(0);
		setLoc(g);
		Thread th = new Thread(g);
		th.start();
		db.enemyList.add(g);
	}
	public void addCannon(){
		Cannon c = new Cannon();
		c.setKind(0);
		setLoc(c);
		Thread th = new Thread(c);
		th.start();
		db.enemyList.add(c);
	}
	public void addSquad1(){
		
	}
	public void addSquad2(){
		
	}
	public void addSquad3(){
		
	}
	public void setLoc(Unit u){
		u.setX(db.START_LOC_X_ENM_STG1);
		u.setY(db.START_LOC_Y_ENM_STG1);
	}
}
