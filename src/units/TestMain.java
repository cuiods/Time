package units;

import dataBase.DataBase;

public class TestMain {

	public static void main(String[] args) {
		SwordMan sm= new SwordMan();
        Thread t = new Thread(sm);
        t.start();
	}

}
