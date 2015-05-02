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
	public void addMedicTeam(){
		MedicTeam m = new MedicTeam();
		m.setKind(0);
		setLoc(m);
		Thread th = new Thread(m);
		th.start();
		db.enemyList.add(m);
	}
	public void addSniper(){
		Sniper s = new Sniper();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		db.enemyList.add(s);
	}
	public void addTruck(){
		Truck t = new Truck();
		t.setKind(0);
		setLoc(t);
		Thread th = new Thread(t);
		th.start();
		db.enemyList.add(t);
	}
	public void addRifle(){
		Rifle r = new Rifle();
		r.setKind(0);
		setLoc(r);
		Thread th = new Thread(r);
		th.start();
		db.enemyList.add(r);
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
