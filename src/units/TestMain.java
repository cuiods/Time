package units;

import dataBase.DataBase;

public class TestMain {

	public static void main(String[] args) {
		STG1_SwordMan sm= new STG1_SwordMan();
        Thread t = new Thread(sm);
        t.start();
	}

}
