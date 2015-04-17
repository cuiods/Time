package ai;
import dataBase.DataBase;
public abstract class AI {
	DataBase db = new DataBase();
	public int Threat=0;
	public abstract void detect();
	public abstract int analyze();
	public abstract void execute(int Threat);  
}
