package ai;

import dataBase.DataBase;

public class simpleAI_Classic extends AI implements Runnable{
	public int AgeLevel = 11;
	public int Threat = 0;
	public int Pass = 11;
	public int Money = 0;
	AIMoney m;
	public simpleAI_Classic(){
		this.Pass = AIMoney.AIPass;
		this.Money = AIMoney.Money;
		Thread th = new Thread(m);
		th.start();
	}
	@Override
	public void detect() {
		this.Pass = AIMoney.AIPass;
		this.Money = AIMoney.Money;
		execute(analyze(0),0);
		execute(analyze(1),1);
		execute(analyze(2),2);
		
	}

	private void execute(int analyze, int path_num) {
		
		
	}

	private int analyze(int path_num) {
		
		return 0;
	}
	@Override
	public void run() {
		while(DataBase.threadContinue){
			detect();
		}
		
	}

	@Override
	public int analyze() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void execute(int Threat) {
		// TODO 自动生成的方法存根
		
	}

}
