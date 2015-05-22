package ai;

import Tech.Tech_ENM_STG4_GeneMissile;
import Tech.Tech_ENM_STG4_KillerVirus;
import Tech.Tech_ENM_STG3_LockScience;
import Tech.Tech_ENM_STG4_PhotonStrike;
import units.*;
import dataBase.DataBase;

public class AIcommander {
	public Tech_ENM_STG3_LockScience tech=null;
	public void addSwordMan(){
		STG1_SwordMan s = new STG1_SwordMan();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addGunner(){
		STG1_Gunner g = new STG1_Gunner();
		g.setKind(0);
		setLoc(g);
		Thread th = new Thread(g);
		th.start();
		DataBase.enemyList.add(g);
	}
	public void addCannon(){
		STG1_Cannon c = new STG1_Cannon();
		c.setKind(0);
		setLoc(c);
		Thread th = new Thread(c);
		th.start();
		DataBase.enemyList.add(c);
	}
	public void addMedicTeam(int path_num){
		STG2_MedicTeam m = new STG2_MedicTeam();
		m.setKind(0);
		m.path = path_num;
		Upgrade(m);
		setLoc(m);
		Thread th = new Thread(m);
		th.start();
		DataBase.enemyList.add(m);
	}
	public void addSniper(int path_num){
		STG2_Sniper s = new STG2_Sniper();
		s.setKind(0);
		s.path = path_num;
		Upgrade(s);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addTruck(int path_num){
		STG2_Truck t = new STG2_Truck();
		t.setKind(0);
		t.path = path_num;
		Upgrade(t);
		setLoc(t);
		Thread th = new Thread(t);
		th.start();
		DataBase.enemyList.add(t);
	}
	public void addRifle(int path_num){
		STG2_Rifle r = new STG2_Rifle();
		r.setKind(0);
		r.path = path_num;
		Upgrade(r);
		setLoc(r);
		Thread th = new Thread(r);
		th.start();
		DataBase.enemyList.add(r);
	}
	public void addSpaceShip(int path_num){
		STG3_SpaceShip s = new STG3_SpaceShip();
		s.setKind(0);
		s.path = path_num;
		Upgrade(s);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addSpaceMan(int path_num){
		STG3_SpaceMan s = new STG3_SpaceMan();
		s.setKind(0);
		s.path = path_num;
		Upgrade(s);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addSpaceCarrier(int path_num){
		STG3_SpaceCarrier s = new STG3_SpaceCarrier();
		s.setKind(0);
		s.path = path_num;
		Upgrade(s);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addDrone(int path_num){
		STG4_Drone d = new STG4_Drone();
		d.setKind(0);
		d.path = path_num;
		Upgrade(d);
		setLoc(d);
		Thread th = new Thread(d);
		th.start();
		DataBase.enemyList.add(d);
	}
	public void addRazerShip(int path_num){
		STG4_RazerShip r = new STG4_RazerShip();
		r.setKind(0);
		r.path = path_num;
		Upgrade(r);
		setLoc(r);
		Thread th = new Thread(r);
		th.start();
		DataBase.enemyList.add(r);
	}
	public void addRobotWarrior(int path_num){
		STG4_RobotWarrior r = new STG4_RobotWarrior();
		r.setKind(0);
		r.path = path_num;
		Upgrade(r);
		setLoc(r);
		Thread th = new Thread(r);
		th.start();
		DataBase.enemyList.add(r);
	}
	public void addSneaker(int path_num){
		STG4_Sneaker s = new STG4_Sneaker();
		s.setKind(0);
		s.path = path_num;
		Upgrade(s);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addCaptain(){
		STG6_Captain s = new STG6_Captain();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addDataMan(){
		STG6_DataMan s = new STG6_DataMan();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addArtDesigner(){
		STG6_Artdesigner s = new STG6_Artdesigner();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void addJobHunter(){
		STG6_JobHunter s = new STG6_JobHunter();
		s.setKind(0);
		setLoc(s);
		Thread th = new Thread(s);
		th.start();
		DataBase.enemyList.add(s);
	}
	public void LockScience(){
		System.out.println("LockScience");
	    tech = new Tech_ENM_STG3_LockScience();
		Thread th = new Thread(tech);
		th.start();
	}
	public void GeneMissile(){
		System.out.println("GeneMissile");
		Tech_ENM_STG4_GeneMissile tech = new Tech_ENM_STG4_GeneMissile();
		Thread th = new Thread(tech);
		th.start();
	}
	public void KillerVirus(){
		System.out.println("KillerVirus");
		Tech_ENM_STG4_KillerVirus tech = new Tech_ENM_STG4_KillerVirus();
		Thread th = new Thread(tech);
		th.start();
	}
	public void PhotonStrike(){
		System.out.println("PhotonStrike");
		Tech_ENM_STG4_PhotonStrike tech = new Tech_ENM_STG4_PhotonStrike();
		tech.execute();
	}
	public void Upgrade(S_Unit ce){
		if(DataBase.pass>10){
			ce.setHp((int) (ce.getHp()*Math.pow(1.5, AIMoney.AIPass-11)));
			ce.attack = (int) (ce.attack*Math.pow(2,AIMoney.AIPass-11));
		}
	}
	public void NextAge(){
		AIMoney.AIPass++;
		if(AIMoney.AIPass==11){
		AIMoney.Money-=DataBase.UPGRADE_CONDITION_LV2;
		}
		if(AIMoney.AIPass==12){
			AIMoney.Money-=DataBase.UPGRADE_CONDITION_LV3;
			}
	}
	public void setLoc(S_Unit u){
		switch(DataBase.pass){
		case 1 :u.setX(DataBase.START_LOC_X_ENM_STG1);
		u.setY(DataBase.START_LOC_Y_ENM_STG1); break;
		case 2: u.setX(DataBase.START_LOC_X_ENM_STG2);
		u.setY(DataBase.START_LOC_Y_ENM_STG2); break;
		case 3: u.setX(DataBase.START_LOC_X_ENM_STG3);
		u.setY(DataBase.START_LOC_Y_ENM_STG3); break;
		case 4:if(u.path==0){
			u.setX(DataBase.START_LOC_X_ENM_STG4);
			u.setY(DataBase.START_LOC_Y_ENM_STG4);
		}
		if(u.path==1){
			u.setX(DataBase.START_LOC_X_ENM_STG4);
			u.setY(DataBase.START_LOC_Y_ENM_STG4+240);
		}break;

		case 5:
			if(u.path==0){u.setX(DataBase.START_LOC_X_ENM_STG5);
		u.setY(DataBase.START_LOC_Y_ENM_STG5);}
			if(u.path==1){u.setX(DataBase.START_LOC_X_ENM_STG5);
			u.setY(DataBase.START_LOC_Y_ENM_STG5+165);}
			if(u.path==2){u.setX(DataBase.START_LOC_X_ENM_STG5);
			u.setY(DataBase.START_LOC_Y_ENM_STG5+330);}
			break;
		case 6:u.setX(DataBase.START_LOC_X_ENM_STG6);
		u.setY(DataBase.START_LOC_Y_ENM_STG6); break;
		case 11:
		case 12:
		case 13:if(u.path==0){u.setX(DataBase.START_LOC_X_ENM_STG5-100);
		u.setY(DataBase.START_LOC_Y_ENM_STG5);}
		if(u.path==1){u.setX(DataBase.START_LOC_X_ENM_STG5-100);
		u.setY(DataBase.START_LOC_Y_ENM_STG5+165);}
		if(u.path==2){u.setX(DataBase.START_LOC_X_ENM_STG5-100);
		u.setY(DataBase.START_LOC_Y_ENM_STG5+330);}
		break;
		}
	}
}
