package ai;

import Tech.Tech_ENM_STG4_GeneMissile;
import Tech.Tech_ENM_STG4_KillerVirus;
import Tech.Tech_ENM_STG3_LockScience;
import Tech.Tech_ENM_STG5_PhotonStrike;
import units.*;
import dataBase.DataBase;

public class AIcommander {
	public void addSwordMan(){
		SwordMan s = new SwordMan();
		s.setKind(0);
	    setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addGunner(){
		Gunner g = new Gunner();
		g.setKind(0);
		setLoc(g);
		Thread th = new Thread(g);
		th.start();
		DataBase.enemyList.add(g);
	}
	public void addCannon(){
		Cannon c = new Cannon();
		c.setKind(0);
		setLoc(c);
		Thread th = new Thread(c);
		th.start();
		DataBase.enemyList.add(c);
	}
	public void addMedicTeam(){
		MedicTeam m = new MedicTeam();
		m.setKind(0);
		setLoc(m);
		Thread th = new Thread(m);
		th.start();
		DataBase.enemyList.add(m);
	}
	public void addSniper(){
		Sniper s = new Sniper();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addTruck(){
		Truck t = new Truck();
		t.setKind(0);
		setLoc(t);
		Thread th = new Thread(t);
		th.start();
		DataBase.enemyList.add(t);
	}
	public void addRifle(){
		Rifle r = new Rifle();
		r.setKind(0);
		setLoc(r);
		Thread th = new Thread(r);
		th.start();
		DataBase.enemyList.add(r);
	}
	public void addSpaceShip(){
		SpaceShip s = new SpaceShip();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addSpaceMan(){
		SpaceMan s = new SpaceMan();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addSpaceCarrier(){
		SpaceCarrier s = new SpaceCarrier();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void GeneMissile(){
		Tech_ENM_STG4_GeneMissile tech = new Tech_ENM_STG4_GeneMissile();
		tech.execute();
	}
	public void KillerVirus(){
		Tech_ENM_STG4_KillerVirus tech = new Tech_ENM_STG4_KillerVirus();
		tech.execute();
	}
	public void LockScience(){
		Tech_ENM_STG3_LockScience tech = new Tech_ENM_STG3_LockScience();
		Thread th = new Thread(tech);
		th.start();
	}
	public void PhotonStrike(){
		Tech_ENM_STG5_PhotonStrike tech = new Tech_ENM_STG5_PhotonStrike();
		tech.execute();
	}
	public void setLoc(Unit u){
		switch(DataBase.pass){
		case 1 :u.setX(DataBase.START_LOC_X_ENM_STG1);
		u.setY(DataBase.START_LOC_Y_ENM_STG1); break;
		case 2: u.setX(DataBase.START_LOC_X_ENM_STG2);
		u.setY(DataBase.START_LOC_Y_ENM_STG2); break;
		case 3: u.setX(DataBase.START_LOC_X_ENM_STG3);
		u.setY(DataBase.START_LOC_Y_ENM_STG3); break;
		case 4:u.setX(DataBase.START_LOC_X_ENM_STG4);
		u.setY(DataBase.START_LOC_Y_ENM_STG4); break;
		case 5:u.setX(DataBase.START_LOC_X_ENM_STG5);
		u.setY(DataBase.START_LOC_Y_ENM_STG5); break;
		}
	}
}
